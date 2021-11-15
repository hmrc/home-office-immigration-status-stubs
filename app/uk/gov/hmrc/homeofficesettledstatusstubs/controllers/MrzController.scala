/*
 * Copyright 2021 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.homeofficesettledstatusstubs.controllers

import play.api.libs.json.JsValue
import play.api.mvc.{Action, ControllerComponents, Result}
import uk.gov.hmrc.homeofficesettledstatusstubs.models.StatusResponse
import uk.gov.hmrc.homeofficesettledstatusstubs.models.searches.MrzSearch
import uk.gov.hmrc.homeofficesettledstatusstubs.services.StubDataService
import uk.gov.hmrc.play.bootstrap.backend.controller.BackendController

import javax.inject.Inject

class MrzController @Inject()(cc: ControllerComponents, stubDataService: StubDataService)
    extends BackendController(cc) {

  //todo add filter/action to add this.
  final val HTTP_HEADER_CONTENT_TYPE_JSON = "Content-Type" -> "application/json"

  def getImmigrationStatus: Action[JsValue] = Action(parse.tolerantJson) { implicit request =>
    val correlationId = request.headers.get("X-Correlation-Id").getOrElse("00000000")
    withValidParameters(correlationId, request.body)
      .fold(
        identity,
        search => stubDataService.mrzSearch(search)
      )
      .withHeaders(HTTP_HEADER_CONTENT_TYPE_JSON)
  }

  private def withValidParameters(
    correlationId: String,
    body: JsValue): Either[Result, MrzSearch] = {

    val docTypeOpt = (body \ "documentType").asOpt[String]
    val documentNumOpt = (body \ "documentNumber").asOpt[String]
    val dateOfBirthOpt = (body \ "dateOfBirth").asOpt[String]
    val nationalityOpt = (body \ "nationality").asOpt[String]
    val startDateOpt = (body \ "statusCheckRange" \ "startDate").asOpt[String]
    val endDateOpt = (body \ "statusCheckRange" \ "endDate").asOpt[String]

    {
      for {
        docType <- docTypeOpt
        docNum  <- documentNumOpt
        dob     <- dateOfBirthOpt
        nation  <- nationalityOpt
        start   <- startDateOpt
        end     <- endDateOpt
      } yield {
        Right(MrzSearch(correlationId, docType, docNum, dob, nation, start, end))
      }
    }.getOrElse(
      Left(
        generateValidationFailure(
          correlationId,
          docTypeOpt,
          documentNumOpt,
          dateOfBirthOpt,
          nationalityOpt,
          startDateOpt,
          endDateOpt
        ))
    )
  }

  private def generateValidationFailure(
    correlationId: String,
    docTypeOpt: Option[String],
    documentNumOpt: Option[String],
    dobOpt: Option[String],
    nationalityOpt: Option[String],
    startDateOpt: Option[String],
    endDateOpt: Option[String]): Result = {
    def errorField(hasError: Boolean, name: String, code: String): Option[(String, String)] =
      if (hasError) Some((name, code)) else None

    val fields = Seq(
      errorField(docTypeOpt.isEmpty, "documentType", "ERR_INVALID_DOCUMENT_TYPE"),
      errorField(documentNumOpt.isEmpty, "documentNumber", "ERR_MISSING_DOCUMENT_NUMBER"),
      errorField(dobOpt.isEmpty, "dateOfBirth", "ERR_MISSING_DOB"),
      errorField(nationalityOpt.isEmpty, "nationality", "ERR_MISSING_NATIONALITY"),
      errorField(
        startDateOpt.isEmpty || endDateOpt.isEmpty,
        "statusCheckRange",
        "ERR_INVALID_CHECK_STATUS_RANGE")
    ).flatten

    BadRequest(StatusResponse.errorResponseBody(correlationId, "ERR_VALIDATION", fields))
  }

}
