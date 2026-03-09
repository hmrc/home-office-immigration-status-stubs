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
import stubData.Data
import base.BaseSpec

class StatusCheckResultSpec extends BaseSpec {

  private val validNationalities: List[String]   = List("ABC", "ZZZ", "MDA")
  private val invalidNationalities: List[String] = List("", " ", "A", "AB", "ABCD")

  private def statusCheckResult(nationality: String): StatusCheckResult =
    Data.wolfgangTraube.copy(nationality = nationality)

  val json: JsObject = Json.obj(
    "fullName"    -> "Wolfgang Traube",
    "dateOfBirth" -> "1983-08-26",
    "nationality" -> "DEU",
    "statuses"    -> List(
      Json.obj(
        "productType"             -> "EUS",
        "statusStartDate"         -> "2021-06-29",
        "statusEndDate"           -> "2022-01-28",
        "immigrationStatus"       -> "COA_IN_TIME_GRANT",
        "noRecourseToPublicFunds" -> true
      )
    )
  )

  "StatusCheckResult" must {
    "serialise to Json" in {
      Json.toJson(Data.wolfgangTraube) mustBe json
    }

    "deserialise from Json" in {
      json.as[StatusCheckResult] mustBe Data.wolfgangTraube
    }

    "error when JSON is invalid" in {
      JsObject.empty.validate[StatusCheckResult] mustBe a[JsError]
    }

    Seq("ABC", "ZZZ", "MDA").foreach { nationality =>
      s"return the nationality $nationality when valid nationality passed=[$nationality]" in {
        statusCheckResult(nationality).nationality mustBe nationality
      }
    }

    Seq("", " ", "A", "AB", "ABCD").foreach { nationality =>
      s"return error when invalid nationality passed=[$nationality]" in {
        val exception: RuntimeException = intercept[RuntimeException] {
          statusCheckResult(nationality)
        }

        exception.getMessage mustBe "requirement failed: nationality must be a 3 letter ISO 3166-1 code"
      }
    }
  }
}
