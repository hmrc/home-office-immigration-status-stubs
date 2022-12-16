/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.homeofficesettledstatusstubs.models

import play.api.libs.json.{Format, Json}

import java.time.LocalDate

final case class StatusCheckResult(
  fullName: String,
  dateOfBirth: LocalDate,
  // (ICAO 3 letter acronym - ISO 3166-1)
  nationality: String,
  statuses: List[ImmigrationStatus]
) {
  require(nationality.length == 3, "nationality should be a 3 letter ISO 3166-1 code")
}

object StatusCheckResult {
  implicit val formats: Format[StatusCheckResult] = Json.format[StatusCheckResult]
}
