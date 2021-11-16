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

package uk.gov.hmrc.homeofficesettledstatusstubs.models.searches

import uk.gov.hmrc.homeofficesettledstatusstubs.models.StatusCheckResult

final case class NinoSearch(
  correlationId: String,
  nino: String,
  dateOfBirth: String,
  familyName: String,
  givenName: String,
  statusCheckRange: StatusCheckRange)
    extends Searchable {

  override def validateResult(result: StatusCheckResult): Boolean = {
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

  private def dateToPattern(dateOfBirth: String): String =
    dateOfBirth
      .map {
        case ch if ch == 'X' => "\\d"
        case ch              => ch
      }
      .mkString("^", "", "$")
}
