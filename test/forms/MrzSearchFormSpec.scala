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
import play.api.data._
import support.BaseSpec

class MrzSearchFormSpec extends BaseSpec {

  private val emptyMrzSearchForm: Form[MrzSearch] =
    new MrzSearchForm().apply(correlationId = "00000000").bind(Map.empty[String, String])

  private val validMrzSearchForm: Form[MrzSearch] = new MrzSearchForm()
    .apply(correlationId = "00000000")
    .bind(
      Map(
        "correlationId"              -> "00000000",
        "documentType"               -> "PASSPORT",
        "documentNumber"             -> "MAKE-GRADUATE-ILR",
        "dateOfBirth"                -> "2000-01-01",
        "nationality"                -> "AFG",
        "statusCheckRange.startDate" -> "2024-01-24",
        "statusCheckRange.endDate"   -> "2024-01-27"
      )
    )

  private val invalidMrzSearchForm: Form[MrzSearch] = new MrzSearchForm()
    .apply(correlationId = "00000000")
    .bind(
      Map(
        "documentType"               -> "PASSPORT",
        "documentNumber"             -> "MAKE-GRADUATE-ILR",
        "dateOfBirth"                -> tomorrow,
        "nationality"                -> "AFG",
        "statusCheckRange.startDate" -> "2024-01-24",
        "statusCheckRange.endDate"   -> "2024-01-24"
      )
    )

  "MrzSearchForm" should {
    "return no errors when form is valid" in {
      validMrzSearchForm.get       shouldBe mrzSearch
      validMrzSearchForm.hasErrors shouldBe false
    }

    "return errors when form is invalid" in {
      invalidMrzSearchForm.errors shouldBe List(
        FormError("dateOfBirth", List("ERR_INVALID_DOB")),
        FormError("statusCheckRange", List("ERR_INVALID_CHECK_STATUS_RANGE"))
      )

      emptyMrzSearchForm.errors shouldBe List(
        FormError("documentType", List("ERR_MISSING_DOCUMENT_TYPE")),
        FormError("documentNumber", List("ERR_MISSING_DOCUMENT_NUMBER")),
        FormError("dateOfBirth", List("ERR_MISSING_DOB")),
        FormError("nationality", List("ERR_MISSING_NATIONALITY")),
        FormError("statusCheckRange", List("ERR_MISSING_CHECK_STATUS_RANGE"))
      )

      invalidMrzSearchForm.hasErrors shouldBe true
      emptyMrzSearchForm.hasErrors   shouldBe true
    }

    "return the correct result when filled" in {
      emptyMrzSearchForm.fill(mrzSearch).get shouldBe mrzSearch
    }
  }
}
