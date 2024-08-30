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

import java.time.LocalDate

class ImmigrationStatusSpec extends BaseSpec {

  private val status: ImmigrationStatus = ImmigrationStatus(
    statusStartDate = LocalDate.of(2021, 1, 1),
    statusEndDate = Some(LocalDate.of(2021, 12, 31)),
    productType = "EUS",
    immigrationStatus = "LTR",
    noRecourseToPublicFunds = true
  )

  private val json: JsObject = Json.obj(
    "statusStartDate"         -> "2021-01-01",
    "statusEndDate"           -> "2021-12-31",
    "productType"             -> "EUS",
    "immigrationStatus"       -> "LTR",
    "noRecourseToPublicFunds" -> true
  )

  "ImmigrationStatus" should {
    "serialise to JSON" in {
      Json.toJson(status) shouldBe json
    }

    "deserialise from JSON" in {
      json.as[ImmigrationStatus] shouldBe status
    }

    "error when JSON is invalid" in {
      JsObject.empty.validate[ImmigrationStatus] shouldBe a[JsError]
    }

  }
}
