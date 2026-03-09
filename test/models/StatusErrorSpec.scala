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

package models

import play.api.libs.json.{JsError, JsObject, Json}
import base.BaseSpec

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

  "StatusError" must {
    "serialise to JSON" in {
      Json.toJson(statusError) mustBe json
    }

    "deserialise from JSON" in {
      json.as[StatusError] mustBe statusError
    }

    "error when JSON is invalid" in {
      JsObject.empty.validate[StatusError] mustBe a[JsError]
    }
  }

  "Field" must {
    "serialise to JSON" in {
      Json.toJson(statusError.fields.head) mustBe json("fields").as[Seq[JsObject]].head
    }

    "deserialise from JSON" in {
      json("fields").as[Seq[Field]].head mustBe statusError.fields.head
    }

    "error when JSON is invalid" in {
      JsObject.empty.validate[Field] mustBe a[JsError]
    }
  }

}
