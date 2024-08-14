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

import models.searches.MrzSearch
import play.api.data.Form
import play.api.data.Forms.mapping

import java.time.LocalDate

class MrzSearchForm extends StatusSearchForm {

  def apply(correlationId: String, today: LocalDate = LocalDate.now()): Form[MrzSearch] =
    Form[MrzSearch] {
      mapping(
        "correlationId"    -> maintain(correlationId),
        "documentType"     -> nonEmptyText("ERR_MISSING_DOCUMENT_TYPE"),
        "documentNumber"   -> nonEmptyText("ERR_MISSING_DOCUMENT_NUMBER"),
        "dateOfBirth"      -> validDate("ERR_MISSING_DOB", "ERR_INVALID_DOB", allowWild = true)
          .verifying(dobConstraints(today))
          .transform(_.toString, LocalDate.parse),
        "nationality"      -> nonEmptyText("ERR_MISSING_NATIONALITY"),
        "statusCheckRange" -> statusCheckRangeMapping
      )(MrzSearch.apply)(m => Option(Tuple.fromProductTyped(m)))
    }
}
