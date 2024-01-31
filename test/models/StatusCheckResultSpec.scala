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

import stubData.DemoStubData
import support.BaseSpec

class StatusCheckResultSpec extends BaseSpec {

  private val validNationalities: List[String]   = List("ABC", "ZZZ", "MDA")
  private val invalidNationalities: List[String] = List("", " ", "A", "AB", "ABCD")

  private def statusCheckResult(nationality: String): StatusCheckResult =
    DemoStubData.wolfgangTraube.copy(nationality = nationality)

  "StatusCheckResult" should {
    validNationalities.foreach { nationality =>
      s"return the nationality $nationality when valid nationality passed=[$nationality]" in {
        statusCheckResult(nationality).nationality shouldBe nationality
      }
    }

    invalidNationalities.foreach { nationality =>
      s"return error when invalid nationality passed=[$nationality]" in {
        val exception: RuntimeException = intercept[RuntimeException] {
          statusCheckResult(nationality)
        }

        exception.getMessage shouldBe "requirement failed: nationality should be a 3 letter ISO 3166-1 code"
      }
    }
  }
}
