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

import models.searches.NinoSearch
import play.api.data._
import base.BaseSpec

class NinoSearchFormBuilderSpec extends BaseSpec {

  private val validNinoSearchForm: Form[NinoSearch] = NinoSearchFormBuilder(correlationId = "00000000")
    .bind(
      Map(
        "correlationId"              -> "00000000",
        "nino"                       -> "SP123456B",
        "dateOfBirth"                -> "2000-01-01",
        "familyName"                 -> "Make",
        "givenName"                  -> "MAKE-GRADUATE-ILR",
        "statusCheckRange.startDate" -> "2024-01-24",
        "statusCheckRange.endDate"   -> "2024-01-27"
      )
    )

  "NinoSearchForm" must {
    "return no errors when form is valid" in {
      validNinoSearchForm.get       mustBe ninoSearch
      validNinoSearchForm.hasErrors mustBe false
    }

    "return errors when form is invalid" in {
      val invalidNinoSearchForm: Form[NinoSearch] = NinoSearchFormBuilder(correlationId = "00000000")
        .bind(
          Map(
            "nino"                       -> "SP12345",
            "dateOfBirth"                -> tomorrow,
            "familyName"                 -> "Make",
            "givenName"                  -> "MAKE-GRADUATE-ILR",
            "statusCheckRange.startDate" -> "2024-01-24",
            "statusCheckRange.endDate"   -> "2024-01-24"
          )
        )

      invalidNinoSearchForm.errors mustBe List(
        FormError("nino", List("ERR_INVALID_NINO")),
        FormError("dateOfBirth", List("ERR_INVALID_DOB")),
        FormError("statusCheckRange", List("ERR_INVALID_CHECK_STATUS_RANGE"))
      )

      invalidNinoSearchForm.hasErrors mustBe true
    }

    "return errors when form is empty" in {
      val emptyNinoSearchForm: Form[NinoSearch] =
        NinoSearchFormBuilder(correlationId = "00000000").bind(Map.empty[String, String])

      emptyNinoSearchForm.errors mustBe List(
        FormError("nino", List("ERR_MISSING_NINO")),
        FormError("dateOfBirth", List("ERR_MISSING_DOB")),
        FormError("familyName", List("ERR_MISSING_FAMILY_NAME")),
        FormError("givenName", List("ERR_MISSING_GIVEN_NAME")),
        FormError("statusCheckRange", List("ERR_MISSING_CHECK_STATUS_RANGE"))
      )

      emptyNinoSearchForm.hasErrors mustBe true
    }

    "return the correct result when filled" in {
      val emptyNinoSearchForm: Form[NinoSearch] =
        NinoSearchFormBuilder(correlationId = "00000000").bind(Map.empty[String, String])

      emptyNinoSearchForm.fill(ninoSearch).get mustBe ninoSearch
    }
  }
}
