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

import models.token.TokenRequest
import play.api.data._
import base.BaseSpec

class TokenFormBuilderSpec extends BaseSpec {

  private val tokenRequest: TokenRequest = TokenRequest(
    grant_type = "client_credentials",
    client_id = "hmrc",
    client_secret = "TBC"
  )

  "TokenForm" must {
    "return no errors when form is valid" in {
      val validTokenForm: Form[TokenRequest] = TokenFormBuilder()
        .bind(
          Map(
            "grant_type"    -> tokenRequest.grant_type,
            "client_id"     -> tokenRequest.client_id,
            "client_secret" -> tokenRequest.client_secret
          )
        )

      validTokenForm.get       mustBe tokenRequest
      validTokenForm.hasErrors mustBe false
    }

    "return errors when form is invalid" in {
      val invalidTokenForm: Form[TokenRequest] = TokenFormBuilder()
        .bind(
          Map(
            "grant_type"    -> "grant",
            "client_id"     -> "id",
            "client_secret" -> "TBC"
          )
        )

      invalidTokenForm.errors mustBe List(
        FormError("grant_type", List("Wrong grant type.")),
        FormError("client_id", List("Unknown client_id."))
      )

      invalidTokenForm.hasErrors mustBe true
    }

    "return errors when form is empty" in {
      val emptyTokenForm: Form[TokenRequest] = TokenFormBuilder().bind(Map.empty[String, String])

      emptyTokenForm.errors mustBe List(
        FormError("grant_type", List("error.required")),
        FormError("client_id", List("error.required")),
        FormError("client_secret", List("error.required"))
      )

      emptyTokenForm.hasErrors mustBe true
    }

    "return the correct result when filled" in {
      val emptyTokenForm: Form[TokenRequest] = TokenFormBuilder().bind(Map.empty[String, String])

      emptyTokenForm.fill(tokenRequest).get mustBe tokenRequest
    }
  }
}
