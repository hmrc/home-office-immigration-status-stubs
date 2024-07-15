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

package models

import play.api.data.FormError
import play.api.http.Status.BAD_REQUEST
import play.api.libs.json.Json
import support.BaseSpec

class StatusResponseSpec extends BaseSpec {

  private def errorResponseBody(fields: Seq[FormError]): String = StatusResponse
    .errorResponseBody(
      correlationId = "00000000",
      errCode = "ERR_VALIDATION",
      status = BAD_REQUEST,
      fields = fields
    )
    .asJson
    .toString

  private def errorResponse(fields: Seq[Field]): ErrorResponse = ErrorResponse(
    correlationId = "00000000",
    error = StatusError(
      errCode = "ERR_VALIDATION",
      fields = fields
    )
  )

  "StatusResponse" when {
    ".errorResponseBody" should {
      "produce the expected error response body JSON string" when {
        "key and messages are present" in {
          val errorResponseBodyFields: Seq[FormError] = Seq(
            FormError(
              key = "familyName",
              messages = Seq("ERR_MISSING_FAMILY_NAME")
            )
          )

          val errorResponseFields: Seq[Field] = Seq(
            Field(
              code = "ERR_MISSING_FAMILY_NAME",
              name = "familyName"
            )
          )

          errorResponseBody(errorResponseBodyFields) shouldBe Json.toJson(errorResponse(errorResponseFields)).toString()
        }

        "key and messages are absent" in {
          errorResponseBody(Nil) shouldBe Json.toJson(errorResponse(Nil)).toString()
        }
      }
    }
  }
}
