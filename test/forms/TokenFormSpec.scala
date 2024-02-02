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

import models.token.TokenRequest
import play.api.data._
import support.BaseSpec

class TokenFormSpec extends BaseSpec {

  private val tokenRequest: TokenRequest = TokenRequest(
    grant_type = "client_credentials",
    client_id = "hmrc",
    client_secret = "TBC"
  )

  private val emptyTokenForm: Form[TokenRequest] = new TokenForm().apply().bind(Map.empty[String, String])

  private val validTokenForm: Form[TokenRequest] = new TokenForm()
    .apply()
    .bind(
      Map(
        "grant_type"    -> "client_credentials",
        "client_id"     -> "hmrc",
        "client_secret" -> "TBC"
      )
    )

  private val invalidTokenForm: Form[TokenRequest] = new TokenForm()
    .apply()
    .bind(
      Map(
        "grant_type"    -> "grant",
        "client_id"     -> "id",
        "client_secret" -> "TBC"
      )
    )

  "TokenForm" should {
    "return no errors when form is valid" in {
      validTokenForm.get       shouldBe tokenRequest
      validTokenForm.hasErrors shouldBe false
    }

    "return errors when form is invalid" in {
      invalidTokenForm.errors shouldBe List(
        FormError("grant_type", List("Wrong grant type.")),
        FormError("client_id", List("Unknown client_id."))
      )

      emptyTokenForm.errors shouldBe List(
        FormError("grant_type", List("error.required")),
        FormError("client_id", List("error.required")),
        FormError("client_secret", List("error.required"))
      )

      invalidTokenForm.hasErrors shouldBe true
      emptyTokenForm.hasErrors   shouldBe true
    }

    "return the correct result when filled" in {
      emptyTokenForm.fill(tokenRequest).get shouldBe tokenRequest
    }
  }
}
