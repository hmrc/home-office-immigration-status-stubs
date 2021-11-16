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

import play.api.libs.json.{Format, JsValue, Json}
import play.api.mvc._
import play.api.{Configuration, Environment}
import uk.gov.hmrc.domain.Nino
import uk.gov.hmrc.play.bootstrap.backend.controller.BackendController
import uk.gov.hmrc.homeofficesettledstatusstubs.models._
import uk.gov.hmrc.homeofficesettledstatusstubs.models.searches.NinoSearch
import uk.gov.hmrc.homeofficesettledstatusstubs.services.StubDataService

import java.util.UUID
import javax.inject.{Inject, Singleton}
import scala.concurrent.Future

@Singleton
class NinoController @Inject()(
  val env: Environment,
  cc: ControllerComponents,
  stubDataService: StubDataService)(implicit val configuration: Configuration)
    extends BackendController(cc) {

  //todo add filter/action to add this.
  final val HTTP_HEADER_CONTENT_TYPE_JSON = "Content-Type" -> "application/json"

  def publicFundsByNino: Action[JsValue] = Action(parse.tolerantJson) { implicit request =>
    val correlationId = request.headers.get("X-Correlation-Id").getOrElse("00000000")

    withValidParameters(correlationId, request.body)
      .fold(
        identity,
        search => stubDataService.ninoSearch(search)
      )
      .withHeaders(HTTP_HEADER_CONTENT_TYPE_JSON)
  }

  private def withValidParameters(
    correlationId: String,
    body: JsValue): Either[Result, NinoSearch] = {
    val ninoOpt = (body \ "nino").asOpt[String].map(_.replaceAll(" ", "").toUpperCase)
    val givenNameOpt = (body \ "givenName").asOpt[String]
    val familyNameOpt = (body \ "familyName").asOpt[String]
    val dateOfBirthOpt = (body \ "dateOfBirth").asOpt[String]
    val startDateOpt = (body \ "statusCheckRange" \ "startDate").asOpt[String]
    val endDateOpt = (body \ "statusCheckRange" \ "endDate").asOpt[String]

    val query = (ninoOpt, givenNameOpt, familyNameOpt, dateOfBirthOpt, startDateOpt, endDateOpt)

    query match {
      case (Some(nino), Some(givenName), Some(familyName), Some(dateOfBirth), Some(_), Some(_)) =>
        if (Nino.isValid(nino)) {
          Right(NinoSearch(correlationId, nino, dateOfBirth, familyName, givenName))
        } else {
          Left(ninoValidationError(correlationId))
        }
      case _ =>
        Left(
          generateValidationFailure(
            correlationId,
            ninoOpt,
            givenNameOpt,
            familyNameOpt,
            dateOfBirthOpt))
    }
  }

  private def generateValidationFailure(
    correlationId: String,
    ninoOpt: Option[String],
    dateOfBirthOpt: Option[String],
    familyNameOpt: Option[String],
    givenNameOpt: Option[String]): Result = {
    val fields = Seq(
      errorField(ninoOpt.isEmpty, "nino", "ERR_MISSING_NINO"),
      errorField(dateOfBirthOpt.isEmpty, "dateOfBirth", "ERR_MISSING_DOB"),
      errorField(familyNameOpt.isEmpty, "familyName", "ERR_MISSING_FAMILY_NAME"),
      errorField(givenNameOpt.isEmpty, "giveName", "ERR_MISSING_GIVEN_NAME")
    ).flatten

    BadRequest(StatusResponse.errorResponseBody(correlationId, "ERR_VALIDATION", fields))
  }

  private def errorField(hasError: Boolean, name: String, code: String): Option[(String, String)] =
    if (hasError) Some((name, code)) else None

  private def ninoValidationError(correlationId: String) =
    BadRequest(
      StatusResponse.errorResponseBody(
        correlationId,
        "ERR_VALIDATION",
        fields = Seq("nino" -> "ERR_INVALID_NINO"))
    )

}
