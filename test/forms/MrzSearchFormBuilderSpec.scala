/*
 * Copyright 2026 HM Revenue & Customs
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
import base.BaseSpec

class MrzSearchFormBuilderSpec extends BaseSpec {

  "MrzSearchForm" must {
    "return no errors when form is valid" in {
      val validMrzSearchForm: Form[MrzSearch] = MrzSearchFormBuilder(correlationId = "00000000")
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

      validMrzSearchForm.get       mustBe mrzSearch
      validMrzSearchForm.hasErrors mustBe false
    }

    "return errors when form is invalid" in {
      val invalidMrzSearchForm: Form[MrzSearch] = MrzSearchFormBuilder(correlationId = "00000000")
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

      invalidMrzSearchForm.errors mustBe List(
        FormError("dateOfBirth", List("ERR_INVALID_DOB")),
        FormError("statusCheckRange", List("ERR_INVALID_CHECK_STATUS_RANGE"))
      )

      invalidMrzSearchForm.hasErrors mustBe true
    }

    "return errors when form is empty" in {
      val emptyMrzSearchForm: Form[MrzSearch] =
        MrzSearchFormBuilder(correlationId = "00000000").bind(Map.empty[String, String])

      emptyMrzSearchForm.errors mustBe List(
        FormError("documentType", List("ERR_MISSING_DOCUMENT_TYPE")),
        FormError("documentNumber", List("ERR_MISSING_DOCUMENT_NUMBER")),
        FormError("dateOfBirth", List("ERR_MISSING_DOB")),
        FormError("nationality", List("ERR_MISSING_NATIONALITY")),
        FormError("statusCheckRange", List("ERR_MISSING_CHECK_STATUS_RANGE"))
      )

      emptyMrzSearchForm.hasErrors mustBe true
    }

    "return the correct result when filled" in {
      val emptyMrzSearchForm: Form[MrzSearch] =
        MrzSearchFormBuilder(correlationId = "00000000").bind(Map.empty[String, String])

      emptyMrzSearchForm.fill(mrzSearch).get mustBe mrzSearch
    }
  }
}
