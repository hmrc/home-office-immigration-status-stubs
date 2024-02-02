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
import play.api.data._
import support.BaseSpec

class NinoSearchFormSpec extends BaseSpec {

  private val emptyNinoSearchForm: Form[NinoSearch] =
    new NinoSearchForm().apply(correlationId = "00000000").bind(Map.empty[String, String])

  private val validNinoSearchForm: Form[NinoSearch] = new NinoSearchForm()
    .apply(correlationId = "00000000")
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

  private val invalidNinoSearchForm: Form[NinoSearch] = new NinoSearchForm()
    .apply(correlationId = "00000000")
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

  "NinoSearchForm" should {
    "return no errors when form is valid" in {
      validNinoSearchForm.get       shouldBe ninoSearch
      validNinoSearchForm.hasErrors shouldBe false
    }

    "return errors when form is invalid" in {
      invalidNinoSearchForm.errors shouldBe List(
        FormError("nino", List("ERR_INVALID_NINO")),
        FormError("dateOfBirth", List("ERR_INVALID_DOB")),
        FormError("statusCheckRange", List("ERR_INVALID_CHECK_STATUS_RANGE"))
      )

      emptyNinoSearchForm.errors shouldBe List(
        FormError("nino", List("ERR_MISSING_NINO")),
        FormError("dateOfBirth", List("ERR_MISSING_DOB")),
        FormError("familyName", List("ERR_MISSING_FAMILY_NAME")),
        FormError("givenName", List("ERR_MISSING_GIVEN_NAME")),
        FormError("statusCheckRange", List("ERR_MISSING_CHECK_STATUS_RANGE"))
      )

      invalidNinoSearchForm.hasErrors shouldBe true
      emptyNinoSearchForm.hasErrors   shouldBe true
    }

    "return the correct result when filled" in {
      emptyNinoSearchForm.fill(ninoSearch).get shouldBe ninoSearch
    }
  }
}
