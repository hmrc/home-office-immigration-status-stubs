/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.homeofficesettledstatusstubs.stubdata

import uk.gov.hmrc.homeofficesettledstatusstubs.models._
import uk.gov.hmrc.homeofficesettledstatusstubs.stubdata.DemoStubData.formatter

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object QATestStubData {

  val formatter = DateTimeFormatter.ofPattern("d/MM/yyyy")

  val johnSmith = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2021", formatter),
        statusEndDate = Some(LocalDate.parse("05/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith1 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2021", formatter),
        statusEndDate = Some(LocalDate.parse("05/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith3 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("15/08/2021", formatter),
        statusEndDate = Some(LocalDate.parse("25/08/2021", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("06/10/2021", formatter),
        productType = "EUS",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith4 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("06/10/2021", formatter),
        productType = "EUS",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith5 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ALB",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2021", formatter),
        statusEndDate = Some(LocalDate.parse("05/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val claudRoslyn6 = StatusCheckResult(
    "Claud Roslyn",
    LocalDate.parse("15/10/1971", formatter),
    "PER",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("15/08/2021", formatter),
        statusEndDate = Some(LocalDate.parse("25/08/2021", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("06/10/2021", formatter),
        statusEndDate = Some(LocalDate.parse("05/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith7 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("15/08/2021", formatter),
        statusEndDate = Some(LocalDate.parse("25/08/2021", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("08/10/2021", formatter),
        productType = "EUS",
        immigrationStatus = "POST_GRACE_PERIOD_COA_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith8 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("08/10/2021", formatter),
        productType = "EUS",
        immigrationStatus = "POST_GRACE_PERIOD_COA_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith9 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("07/10/2021", formatter),
        statusEndDate = Some(LocalDate.parse("05/02/2023", formatter)),
        productType = "WORK",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )
  val johnSmith10 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2020", formatter),
        productType = "WORK",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )
  val johnSmith12 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/02/2020", formatter),
        statusEndDate = Some(LocalDate.parse("09/07/2021", formatter)),
        productType = "WORK",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith13 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("07/10/2021", formatter),
        statusEndDate = Some(LocalDate.parse("05/02/2023", formatter)),
        productType = "DEPENDANT",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )
  val johnSmith16 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/02/2020", formatter),
        statusEndDate = Some(LocalDate.parse("09/07/2021", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith17 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/02/2020", formatter),
        statusEndDate = Some(LocalDate.parse("09/07/2023", formatter)),
        productType = "DEPENDANT",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith20 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/02/2020", formatter),
        statusEndDate = Some(LocalDate.parse("09/07/2021", formatter)),
        productType = "DEPENDANT",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )
  val johnSmith21 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/02/2020", formatter),
        statusEndDate = Some(LocalDate.parse("09/07/2023", formatter)),
        productType = "BNO",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith23 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/02/2020", formatter),
        statusEndDate = Some(LocalDate.parse("09/07/2023", formatter)),
        productType = "BNO",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith26 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/02/2020", formatter),
        statusEndDate = Some(LocalDate.parse("09/07/2021", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith27 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/02/2020", formatter),
        statusEndDate = Some(LocalDate.parse("09/07/2023", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )
  val johnSmith30 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("08/10/2021", formatter),
        statusEndDate = Some(LocalDate.parse("09/08/2021", formatter)),
        productType = "GRADUATE",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )
  val johnSmith31 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("06/10/2021", formatter),
        statusEndDate = Some(LocalDate.parse("05/02/2022", formatter)),
        productType = "FRONTIER_WORKER",
        immigrationStatus = "PERMIT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith32 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    Nil
  )

  val ALEXANDRACARMENQuinn = StatusCheckResult(
    "ALEXANDRA-CARMEN Quinn",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("2021-10-20", formatter),
        productType = "EUS_EUN_JFM",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val MajaGłowa = StatusCheckResult(
    "Maja Głowa",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("2021-10-20", formatter),
        productType = "EUS_TCN_JFM",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val results: Map[String, StatusCheckResult] = Map(
    "SP317690D" -> johnSmith1,
    "SP233073C" -> johnSmith3,
    "SP146882A" -> johnSmith4,
    "SP996057A" -> johnSmith5,
    "SP890342A" -> claudRoslyn6,
    "SP810345D" -> johnSmith7,
    "SP048960B" -> johnSmith8,
    "SP367573C" -> johnSmith9,
    "SP033627A" -> johnSmith12,
    "SP537999A" -> johnSmith13,
    "SP857496A" -> johnSmith16,
    "SP018395A" -> johnSmith17,
    "SP190167C" -> johnSmith20,
    "SP003270D" -> johnSmith21,
    "SP158163D" -> johnSmith23,
    "SP190793C" -> johnSmith26,
    "SP921303A" -> johnSmith27,
    "SP323834A" -> johnSmith30,
    "SP352776C" -> johnSmith31,
    "SP426589B" -> johnSmith32,
    "SP142783D" -> ALEXANDRACARMENQuinn,
    "SP911798A" -> MajaGłowa
  )
}
