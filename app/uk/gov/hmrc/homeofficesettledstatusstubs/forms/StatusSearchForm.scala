/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.homeofficesettledstatusstubs.forms

import play.api.data.Forms.{mapping, optional, text}
import play.api.data.Mapping
import play.api.data.validation.{Constraint, Invalid, Valid}
import uk.gov.hmrc.homeofficesettledstatusstubs.models.searches.StatusCheckRange

import java.time.LocalDate
import scala.util.Try

trait StatusSearchForm {

  def maintain(correlationId: String): Mapping[String] =
    optional(text).transform[String](_ => correlationId, _ => None)

  def nonEmptyText(error: String): Mapping[String] =
    optional(text)
      .verifying(
        error,
        maybeAns => maybeAns.exists(_.trim.nonEmpty)
      )
      .transform(_.get, Some(_))

  def validDate(missing: String, invalid: String, allowWild: Boolean = false): Mapping[LocalDate] =
    nonEmptyText(missing)
      .transform[String](s => if (allowWild) s.replace("XX", "01") else s, identity)
      .verifying(invalid, s => Try(LocalDate.parse(s)).isSuccess)
      .transform[LocalDate](LocalDate.parse, _.toString)

  private def startDateEndDateMapping: Mapping[StatusCheckRange] = {
    val invalid = "ERR_INVALID_CHECK_STATUS_RANGE"
    mapping(
      "startDate" -> validDate(invalid, invalid),
      "endDate"   -> validDate(invalid, invalid)
    )(StatusCheckRange.apply)(StatusCheckRange.unapply)
      .verifying(
        invalid,
        scr => scr.startDate.isBefore(scr.endDate)
      )
  }

  def statusCheckRangeMapping: Mapping[StatusCheckRange] =
    optional(startDateEndDateMapping)
      .verifying("ERR_MISSING_CHECK_STATUS_RANGE", _.isDefined)
      .transform(_.get, Some(_))

  def dobConstraints(today: LocalDate): Constraint[LocalDate] =
    Constraint[LocalDate]((date: LocalDate) => if (date.isBefore(today)) Valid else Invalid("ERR_INVALID_DOB"))

}
