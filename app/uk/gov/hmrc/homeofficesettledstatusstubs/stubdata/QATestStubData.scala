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

import java.time.LocalDate

object QATestStubData extends DataSet {

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
        productType = "STUDY",
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

  val ALEXANDRACARMENQuinn = StatusCheckResult(
    "ALEXANDRA-CARMEN Quinn",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        productType = "EUS|EUN_JFM",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val MajaGlowa = StatusCheckResult(
    "Maja Głowa",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        productType = "EUS|TCN_JFM",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val SupermanALEXANDRACARMEN = StatusCheckResult(
    "Superman ALEXANDRA-CARMEN",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        productType = "EUS_FMFW",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val ONEILLHancock = StatusCheckResult(
    "O'NEILL Hancock",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        statusEndDate = Some(LocalDate.parse("05/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val arthurHancock = StatusCheckResult(
    "árthur Hancock",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        statusEndDate = Some(LocalDate.parse("05/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val JohnSmith33 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        statusEndDate = Some(LocalDate.parse("05/02/2022", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = true
      )
    )
  )

  val johnSmith32 = StatusCheckResult(
    "John Smith",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    Nil
  )

  override val records: Seq[Record] = Seq(
    (johnSmith1, "SP317690D", "PASSPORT", "SP9412794"),
    (johnSmith3, "SP233073C", "PASSPORT", "SP5937773"),
    (johnSmith4, "SP146882A", "PASSPORT", "SP7512294"),
    (johnSmith5, "SP996057A", "PASSPORT", "SP2234474"),
    (claudRoslyn6, "SP890342A", "PASSPORT", "SP3755262"),
    (johnSmith7, "SP810345D", "PASSPORT", "SP6874856"),
    (johnSmith8, "SP048960B", "PASSPORT", "SP6387559"),
    (johnSmith9, "SP367573C", "PASSPORT", "SP1366811"),
    (johnSmith12, "SP033627A", "PASSPORT", "SP5923781"),
    (johnSmith13, "SP537999A", "PASSPORT", "SP2123990"),
    (johnSmith16, "SP857496A", "PASSPORT", "SP6068096"),
    (johnSmith17, "SP018395A", "PASSPORT", "SP5476028"),
    (johnSmith20, "SP190167C", "PASSPORT", "SP8877397"),
    (johnSmith21, "SP003270D", "PASSPORT", "SP7339518"),
    (johnSmith23, "SP158163D", "PASSPORT", "SP7902006"),
    (johnSmith26, "SP190793C", "PASSPORT", "SP2152606"),
    (johnSmith27, "SP921303A", "PASSPORT", "SP9735953"),
    (johnSmith30, "SP323834A", "PASSPORT", "SP5518985"),
    (johnSmith31, "SP352776C", "PASSPORT", "SP7868170"),
    (johnSmith32, "SP426589B", "PASSPORT", "SP7732098"),
    (ALEXANDRACARMENQuinn, "SP142783D", "PASSPORT", "SP8291415"),
    (MajaGlowa, "SP911798A", "PASSPORT", "SP2312615"),
    (SupermanALEXANDRACARMEN, "SP715935D", "PASSPORT", "SP8700770"),
    (ONEILLHancock, "SP997679C", "PASSPORT", "SP6368116"),
    (arthurHancock, "SP501555A", "PASSPORT", "SP6112504"),
    (JohnSmith33, "SP183480C", "PASSPORT", "SP4239309")
  ).map((Record.apply _).tupled)

}
