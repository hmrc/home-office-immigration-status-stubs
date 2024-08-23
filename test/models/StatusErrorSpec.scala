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

import play.api.libs.json.{JsError, JsObject, Json}
import support.BaseSpec

class StatusErrorSpec extends BaseSpec {

  private val statusError: StatusError = StatusError(
    errCode = "ERR_VALIDATION",
    fields = Seq(
      Field(
        code = "ERR_MISSING_FAMILY_NAME",
        name = "familyName"
      )
    )
  )

  private val json = Json.obj(
    "errCode" -> "ERR_VALIDATION",
    "fields"  -> Json.arr(Json.obj("code" -> "ERR_MISSING_FAMILY_NAME", "name" -> "familyName"))
  )

  "StatusError" should {
    "serialise to JSON" in {
      Json.toJson(statusError) shouldBe json
    }

    "deserialise from JSON" in {
      json.as[StatusError] shouldBe statusError
    }

    "error when JSON is invalid" in {
      JsObject.empty.validate[StatusError] shouldBe a[JsError]
    }
  }

  "Field" should {
    "serialise to JSON" in {
      Json.toJson(statusError.fields.head) shouldBe json("fields").as[Seq[JsObject]].head
    }

    "deserialise from JSON" in {
      json("fields").as[Seq[Field]].head shouldBe statusError.fields.head
    }

    "error when JSON is invalid" in {
      JsObject.empty.validate[Field] shouldBe a[JsError]
    }
  }

}
