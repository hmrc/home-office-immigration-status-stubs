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

package uk.gov.hmrc.homeofficesettledstatusstubs.services

import play.api.mvc._
import uk.gov.hmrc.homeofficesettledstatusstubs.models._
import uk.gov.hmrc.homeofficesettledstatusstubs.stubdata.StubData

import javax.inject.{Inject, Singleton}
import play.api.libs.json.Json
import uk.gov.hmrc.homeofficesettledstatusstubs.models.searches._
import uk.gov.hmrc.play.bootstrap.backend.controller.BackendController

@Singleton
class StubDataService @Inject()(cc: ControllerComponents) extends BackendController(cc) {

  private def search[S <: Searchable](searchable: S)(firstCheck: S => Option[StatusCheckResult])(
    fallBack: S => Option[ErrorResponse]): Result =
    resultFor(searchable.correlationId, firstCheck(searchable))(fallBack(searchable)) match {
      case Some(response @ ErrorResponse(_, status, _)) => new Status(status)(Json.toJson(response))
      case Some(response @ SuccessResponse(_, result)) if searchable.validateResult(result) =>
        Ok(Json.toJson(response))
      case _ =>
        NotFound(
          StatusResponse
            .errorResponseBody(searchable.correlationId, "ERR_NOT_FOUND", NOT_FOUND, Nil))
    }

  def mrzSearch(mrzSearch: MrzSearch): Result =
    search(mrzSearch)(s => StubData.mrzToResult.get(s.docType, s.documentNum))(s =>
      checkOtherMrz(s.correlationId, s.docType, s.documentNum))

  def ninoSearch(ninoSearch: NinoSearch): Result =
    search(ninoSearch)(s => StubData.ninoToResult.get(s.nino))(s =>
      checkOtherNinos(s.correlationId, s.nino))

  private def resultFor(correlationId: String, search: => Option[StatusCheckResult])(
    fallBack: => Option[ErrorResponse]): Option[StatusResponse] =
    search match {
      case Some(result) => Some(SuccessResponse(correlationId, result))
      case None         => fallBack
    }

  private def checkOtherMrz(
    correlationId: String,
    docType: String,
    docNum: String): Option[ErrorResponse] =
    (docType, docNum) match { //todo kerry nidhi check
      case ("NAT", "E8HDYKTB3") => Some(conflict(correlationId))
      case ("NAT", "E8HDYKTB4") => Some(tooManyRequests(correlationId))
      case ("NAT", "E8HDYKTB5") => Some(internalServerError(correlationId))
      case _                    => None
    }

  private def checkOtherNinos(correlationId: String, nino: String): Option[ErrorResponse] =
    nino match {
      case "HK089820A" => Some(conflict(correlationId))
      case "TP991941C" => Some(tooManyRequests(correlationId))
      case "BY880209A" => Some(internalServerError(correlationId))
      case _           => None
    }

  private val conflict: String => ErrorResponse = statusResponse(CONFLICT, "ERR_CONFLICT")
  private val tooManyRequests: String => ErrorResponse = statusResponse(TOO_MANY_REQUESTS)
  private val internalServerError: String => ErrorResponse = statusResponse(INTERNAL_SERVER_ERROR)

  private def statusResponse(status: Int, error: String = "[NOT_USED]")(correlationId: String) =
    ErrorResponse(
      status = status,
      correlationId = correlationId,
      error = StatusError(error)
    )
}
