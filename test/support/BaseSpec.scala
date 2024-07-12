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

package support

import models._
import models.searches._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import play.api.test.Helpers.stubControllerComponents
import services.StubDataService

import java.time.LocalDate

trait BaseSpec extends AnyWordSpecLike with Matchers {

  private val (nine, ten) = (9, 10)
  val twoDaysAgo: String  = LocalDate.now().minusDays(2).toString
  val nineDaysAgo: String = LocalDate.now().minusDays(nine).toString
  val tenDaysAgo: String  = LocalDate.now().minusDays(ten).toString
  val yesterday: String   = LocalDate.now().minusDays(1).toString
  val tomorrow: String    = LocalDate.now().plusDays(1).toString

  val stubDataService: StubDataService = new StubDataService(stubControllerComponents())

  val ninoSearch: NinoSearch = NinoSearch(
    correlationId = "00000000",
    nino = "SP123456B",
    dateOfBirth = "2000-01-01",
    familyName = "Make",
    givenName = "MAKE-GRADUATE-ILR",
    statusCheckRange = StatusCheckRange(
      startDate = LocalDate.parse("2024-01-24"),
      endDate = LocalDate.parse("2024-01-27")
    )
  )

  val mrzSearch: MrzSearch = MrzSearch(
    correlationId = "00000000",
    docType = "PASSPORT",
    documentNum = "MAKE-GRADUATE-ILR",
    dob = "2000-01-01",
    nationality = "AFG",
    statusCheckRange = StatusCheckRange(
      startDate = LocalDate.parse("2024-01-24"),
      endDate = LocalDate.parse("2024-01-27")
    )
  )

  val statusCheckResult: StatusCheckResult = StatusCheckResult(
    fullName = "Michael Makson",
    dateOfBirth = LocalDate.parse("2000-01-01"),
    nationality = "AFG",
    statuses = List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("2024-01-24"),
        statusEndDate = Some(LocalDate.parse("2024-01-27")),
        productType = "GRADUATE",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )
}
