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
    fallBack: S => Option[StatusResponse]): Result =
    resultFor(searchable.correlationId, firstCheck(searchable))(fallBack(searchable)) match {
      case Some(response @ StatusResponse(_, _, Some(error), status)) =>
        val newStatus = status.getOrElse(400)
        new Status(newStatus)(Json.toJson(response))
      case Some(StatusResponse(_, None, None, _)) => //todo no.
        Ok("")
      case Some(response @ StatusResponse(_, Some(result), _, _))
          if searchable.validateResult(result) =>
        Ok(Json.toJson(response))
      case _ =>
        NotFound(StatusResponse.errorResponseBody(searchable.correlationId, "ERR_NOT_FOUND"))
    }

  def mrzSearch(mrzSearch: MrzSearch): Result =
    search(mrzSearch)(s => StubData.mrzToResult.get(s.docType, s.documentNum))(_ => None) //todo add fall back for error cases

  def ninoSearch(ninoSearch: NinoSearch): Result =
    search(ninoSearch)(s => StubData.ninoToResult.get(s.nino))(s =>
      checkOtherNinos(s.correlationId, s.nino))

  private def resultFor(correlationId: String, search: => Option[StatusCheckResult])(
    fallBack: => Option[StatusResponse]): Option[StatusResponse] =
    search match {
      case Some(result) => Some(StatusResponse(correlationId, Some(result)))
      case None         => fallBack
    }

  private def checkOtherNinos(correlationId: String, nino: String): Option[StatusResponse] =
    nino match {
      case "HK089820A" =>
        Some(
          StatusResponse(
            status = Some(409),
            correlationId = correlationId,
            result = None,
            error = Some(StatusError("ERR_CONFLICT"))
          ))
      case "TP991941C" =>
        Some(
          StatusResponse(
            status = Some(429),
            correlationId = correlationId,
            result = None,
            error = Some(StatusError("[NOT_USED]"))
          ))
      case "BY880209A" =>
        Some(
          StatusResponse(
            status = Some(500),
            correlationId = correlationId,
            result = None,
            error = Some(StatusError("[NOT_USED]"))
          ))
      case _ => None
    }

}
