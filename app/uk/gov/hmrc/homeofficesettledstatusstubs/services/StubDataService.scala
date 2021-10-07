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
import uk.gov.hmrc.play.bootstrap.backend.controller.BackendController

@Singleton
class StubDataService @Inject()(cc: ControllerComponents) extends BackendController(cc) {

  def ninoSearch(
    correlationId: String,
    nino: String,
    givenName: String,
    familyName: String,
    dateOfBirth: String): Result =
    resultFor(correlationId, nino) match {
      case Some(response @ StatusResponse(_, _, Some(error), status)) =>
        val newStatus = status.getOrElse(400)
        new Status(newStatus)(Json.toJson(response))
      case Some(StatusResponse(_, None, None, _)) =>
        Ok("")
      case Some(response @ StatusResponse(_, Some(result), _, _))
          if fieldsMatch(result, givenName, familyName, dateOfBirth) =>
        Ok(Json.toJson(response))
      case Some(response @ StatusResponse(_, Some(result), _, _)) =>
        NotFound(StatusResponse.errorResponseBody(correlationId, "ERR_NOT_FOUND"))
      case None =>
        NotFound(StatusResponse.errorResponseBody(correlationId, "ERR_NOT_FOUND"))
    }

  def resultFor(correlationId: String, nino: String): Option[StatusResponse] =
    StubData.results.get(nino) match {
      case Some(result) => Some(StatusResponse(correlationId, Some(result)))
      case None         => checkOtherStatus(correlationId, nino)
    }

  def checkOtherStatus(correlationId: String, nino: String): Option[StatusResponse] = nino match {
    case "HK089820A" =>
      Some(
        StatusResponse(
          status = Some(409),
          correlationId = correlationId,
          result = None,
          error = Some(StatusError("ERR_CONFLICT"))
        ))
    case "ZL341566D" =>
      Some(
        StatusResponse(
          correlationId,
          result = None
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

  def dateToPattern(dateOfBirth: String): String =
    dateOfBirth
      .map {
        case ch if ch == 'X' => "\\d"
        case ch              => ch
      }
      .mkString("^", "", "$")

  def fieldsMatch(
    result: StatusCheckResult,
    givenName: String,
    familyName: String,
    dateOfBirth: String): Boolean = {
    val givenNameMatches = result.fullName
      .split(" ")
      .headOption
      .exists(_.toUpperCase.startsWith(givenName.take(1).toUpperCase))
    val familyNameMatches = result.fullName
      .split(" ")
      .reverse
      .headOption
      .exists(_.toUpperCase.startsWith(familyName.take(3).toUpperCase))
    val dateOfBirthMatches = result.dateOfBirth.toString.matches(dateToPattern(dateOfBirth))
    givenNameMatches && familyNameMatches && dateOfBirthMatches
  }

}
