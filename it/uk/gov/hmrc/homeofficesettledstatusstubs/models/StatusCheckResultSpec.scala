/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.homeofficesettledstatusstubs.models

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

import java.time.LocalDate

class StatusCheckResultSpec extends AnyWordSpecLike with Matchers {

  "StatusCheckResultSpec" should {
    val invalidContries = List("", " ", "A", "AB", "ABCD")
    invalidContries.foreach { country =>
      s"return error when invalid country passed=[$country]" in {
        val caught = intercept[RuntimeException] {
          StatusCheckResult("name", LocalDate.now(), country, List.empty)
        }

        caught.getMessage shouldBe "requirement failed: nationality should be a 3 letter ISO 3166-1 code"
      }
    }

    val validContries = List("ABC", "ZZZ", "MDA")
    validContries.foreach { country =>
      s"return object when valid country passed=[$country]" in {
        val res = StatusCheckResult("name", LocalDate.now(), country, List.empty)

        res.nationality shouldBe country
      }
    }
  }
}
