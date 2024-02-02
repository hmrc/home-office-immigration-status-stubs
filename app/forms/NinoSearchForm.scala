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

package forms

import models.searches.NinoSearch
import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.validation._
import uk.gov.hmrc.domain.Nino

import java.time.LocalDate

class NinoSearchForm extends StatusSearchForm {

  private def ninoConstraint: Constraint[String] = Constraint[String] { (nino: String) =>
    if (Nino.isValid(nino)) Valid else Invalid("ERR_INVALID_NINO")
  }

  def apply(correlationId: String, today: LocalDate = LocalDate.now()): Form[NinoSearch] =
    Form[NinoSearch] {
      mapping(
        "correlationId"    -> maintain(correlationId),
        "nino"             -> nonEmptyText("ERR_MISSING_NINO").verifying(ninoConstraint),
        "dateOfBirth"      -> validDate("ERR_MISSING_DOB", "ERR_INVALID_DOB", allowWild = true)
          .verifying(dobConstraints(today))
          .transform(_.toString, LocalDate.parse),
        "familyName"       -> nonEmptyText("ERR_MISSING_FAMILY_NAME"),
        "givenName"        -> nonEmptyText("ERR_MISSING_GIVEN_NAME"),
        "statusCheckRange" -> statusCheckRangeMapping
      )(NinoSearch.apply)(NinoSearch.unapply)
    }
}
