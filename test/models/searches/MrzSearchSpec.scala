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

package models.searches

import support.BaseSpec

class MrzSearchSpec extends BaseSpec {

  "MrzSearch" when {
    ".validateResult" should {
      "return true" when {
        "validation is successful" in {
          mrzSearch.validateResult(statusCheckResult) shouldBe true
        }
      }

      "return false" when {
        "validation is unsuccessful" in {
          mrzSearch.copy(dob = "1980-01-01").validateResult(statusCheckResult) shouldBe false
        }
      }
    }
  }
}
