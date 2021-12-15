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

object zambranoStubData extends DataSet {

  val swiss1 = StatusCheckResult(
    "Sarah Smith",
    LocalDate.parse("11/05/1990", formatter),
    "AFG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss2 = StatusCheckResult(
    "Ignác Šarlota",
    LocalDate.parse("20/10/1956", formatter),
    "ALB",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("30/04/2015", formatter),
        statusEndDate = Some(LocalDate.parse("29/05/2020", formatter)),
        productType = "EUS",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss3 = StatusCheckResult(
    "Robin Tens",
    LocalDate.parse("30/06/1969", formatter),
    "DZA",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("21/07/2021", formatter),
        statusEndDate = Some(LocalDate.parse("20/07/2050", formatter)),
        productType = "EUS",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss4 = StatusCheckResult(
    "Lawrence Smith",
    LocalDate.parse("04/10/1954", formatter),
    "WSM",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/07/2020", formatter),
        statusEndDate = Some(LocalDate.parse("19/09/2021", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      )
    )
  )

  val swiss5 = StatusCheckResult(
    "Stefanie Reason",
    LocalDate.parse("27/02/1974", formatter),
    "AND",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/01/2021", formatter),
        statusEndDate = None,
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss6 = StatusCheckResult(
    "Sabeen Muhammad",
    LocalDate.parse("06/05/1980", formatter),
    "AGO",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/07/2020", formatter),
        statusEndDate = Some(LocalDate.parse("19/09/2021", formatter)),
        productType = "FRONTIER_WORKER",
        immigrationStatus = "PERMIT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss7 = StatusCheckResult(
    "Joe Bloggs",
    LocalDate.parse("06/05/1980", formatter),
    "AIA",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("16/08/2021", formatter),
        statusEndDate = Some(LocalDate.parse("15/08/2022", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss8 = StatusCheckResult(
    "Josh Bloggs",
    LocalDate.parse("10/05/1990", formatter),
    "ATA",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2021", formatter)),
        productType = "GRADUATE",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss9 = StatusCheckResult(
    "Wolfgang Traube",
    LocalDate.parse("26/08/1983", formatter),
    "ATG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("29/06/2021", formatter),
        statusEndDate = None,
        productType = "EUS",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = true
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("28/01/2021", formatter),
        statusEndDate = Some(LocalDate.parse("28/06/2021", formatter)),
        productType = "WORK",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = true
      )
    )
  )

  val swiss10 = StatusCheckResult(
    "Ben Bloggs",
    LocalDate.parse("11/05/1990", formatter),
    "ARG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2021", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss11 = StatusCheckResult(
    "Sam Smith",
    LocalDate.parse("11/05/1990", formatter),
    "ARM",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2023", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("01/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("01/08/2021", formatter)),
        productType = "SPORTSPERSON",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("01/07/2021", formatter),
        statusEndDate = Some(LocalDate.parse("01/08/2020", formatter)),
        productType = "SPORTSPERSON",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = true
      )
    )
  )

  val swiss12 = StatusCheckResult(
    "Jen Bright",
    LocalDate.parse("11/05/1990", formatter),
    "ABW",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2023", formatter)),
        productType = "EUS",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("01/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("01/09/2019", formatter)),
        productType = "SETTLEMENT",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss13 = StatusCheckResult(
    "Alison Wright",
    LocalDate.parse("11/05/1990", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2020", formatter)),
        productType = "TEMP_WORKER",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2019", formatter)),
        productType = "TEMP_WORKER",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss14 = StatusCheckResult(
    "Alison Wright",
    LocalDate.parse("11/05/1990", formatter),
    "AZE",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2020", formatter)),
        productType = "BNO",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2019", formatter)),
        productType = "BNO",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss15 = StatusCheckResult(
    "Sarah Smith",
    LocalDate.parse("11/05/1990", formatter),
    "BHS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2020", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2019", formatter)),
        productType = "GRADUATE",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss16 = StatusCheckResult(
    "Lucy Sprag",
    LocalDate.parse("11/05/1990", formatter),
    "BHR",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2020", formatter)),
        productType = "FRONTIER_WORKER",
        immigrationStatus = "PERMIT",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2019", formatter)),
        productType = "EUS",
        immigrationStatus = "POST_GRACE_PERIOD_COA_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss17 = StatusCheckResult(
    "Jimmy Brown",
    LocalDate.parse("11/05/1990", formatter),
    "BGD",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2020", formatter)),
        productType = "EUS",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2019", formatter)),
        productType = "WORK",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      )
    )
  )

  val swiss18 = StatusCheckResult(
    "Eve Vassil",
    LocalDate.parse("22/05/1976", formatter),
    "BRB",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/03/2024", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("17/06/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/09/2021", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/03/2019", formatter),
        statusEndDate = Some(LocalDate.parse("19/09/2019", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss19 = StatusCheckResult(
    "Pete Wolf",
    LocalDate.parse("30/06/1969", formatter),
    "BLR",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("21/07/2021", formatter),
        statusEndDate = Some(LocalDate.parse("20/07/2050", formatter)),
        productType = "EUS",
        immigrationStatus = "ING",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss20 = StatusCheckResult(
    "Stefano Reese",
    LocalDate.parse("27/02/1974", formatter),
    "BLZ",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2020", formatter)),
        productType = "FRONTIER_WORKER",
        immigrationStatus = "PERMIT",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2019", formatter)),
        productType = "EUS",
        immigrationStatus = "POST_GRACE_PERIOD_COA_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss21 = StatusCheckResult(
    "Sarah Smith",
    LocalDate.parse("11/05/1990", formatter),
    "BEN",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = true
      )
    )
  )

  val swiss22 = StatusCheckResult(
    "Sam Smith",
    LocalDate.parse("11/05/1990", formatter),
    "BMU",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2023", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("01/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("01/08/2021", formatter)),
        productType = "SPORTSPERSON",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("01/07/2021", formatter),
        statusEndDate = Some(LocalDate.parse("01/08/2020", formatter)),
        productType = "SPORTSPERSON",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = true
      )
    )
  )

  val swiss23 = StatusCheckResult(
    "Jen Bright",
    LocalDate.parse("11/05/1990", formatter),
    "BTN",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2023", formatter)),
        productType = "EUS",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("01/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("01/09/2019", formatter)),
        productType = "SETTLEMENT",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss24 = StatusCheckResult(
    "Alison Wright",
    LocalDate.parse("11/05/1990", formatter),
    "BOL",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2020", formatter)),
        productType = "TEMP_WORKER",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2019", formatter)),
        productType = "TEMP_WORKER",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss25 = StatusCheckResult(
    "Alison Wright",
    LocalDate.parse("11/05/1990", formatter),
    "BES",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2020", formatter)),
        productType = "BNO",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2019", formatter)),
        productType = "BNO",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss26 = StatusCheckResult(
    "Sarah Smith",
    LocalDate.parse("11/05/1990", formatter),
    "BIH",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2020", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2019", formatter)),
        productType = "GRADUATE",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss27 = StatusCheckResult(
    "Lucy Sprag",
    LocalDate.parse("11/05/1990", formatter),
    "BWA",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2020", formatter)),
        productType = "FRONTIER_WORKER",
        immigrationStatus = "PERMIT",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2019", formatter)),
        productType = "EUS",
        immigrationStatus = "POST_GRACE_PERIOD_COA_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss28 = StatusCheckResult(
    "Jimmy Brown",
    LocalDate.parse("11/05/1990", formatter),
    "BVT",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2020", formatter)),
        productType = "EUS",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2019", formatter)),
        productType = "WORK",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      )
    )
  )

  val swiss29 = StatusCheckResult(
    "Eve Vassil",
    LocalDate.parse("22/05/1976", formatter),
    "BRA",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/03/2024", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("17/06/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/09/2021", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/03/2019", formatter),
        statusEndDate = Some(LocalDate.parse("19/09/2019", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss30 = StatusCheckResult(
    "Pete Wolf",
    LocalDate.parse("30/06/1969", formatter),
    "IOT",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("21/07/2021", formatter),
        statusEndDate = Some(LocalDate.parse("20/07/2050", formatter)),
        productType = "EUS",
        immigrationStatus = "ING",
        noRecourseToPublicFunds = false
      )
    )
  )

  val swiss31 = StatusCheckResult(
    "Stefano Reese",
    LocalDate.parse("27/02/1974", formatter),
    "BRN",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2020", formatter)),
        productType = "FRONTIER_WORKER",
        immigrationStatus = "PERMIT",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2019", formatter)),
        productType = "EUS",
        immigrationStatus = "POST_GRACE_PERIOD_COA_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  override val records: Seq[Record] = Seq(
    (swiss1, "NP806400D", "PASSPORT", "21111112"),
    (swiss2, "ZK192387A", "PASSPORT", "12111112"),
    (swiss3, "SG699952C", "PASSPORT", "11211112"),
    (swiss4, "AB586891B", "PASSPORT", "11121112"),
    (swiss5, "NZ138230D", "PASSPORT", "11112112"),
    (swiss6, "MZ999673A", "PASSPORT", "11111212"),
    (swiss7, "KC463235B", "PASSPORT", "11111122"),
    (swiss8, "SK206961B", "PASSPORT", "31111112"),
    (swiss9, "CL621962D", "PASSPORT", "13111112"),
    (swiss10, "ZB858372C", "PASSPORT", "11311112"),
    (swiss11, "MW449616D", "PASSPORT", "11131112"),
    (swiss12, "EP324395A", "PASSPORT", "11113112"),
    (swiss13, "HX655935B", "PASSPORT", "11111312"),
    (swiss14, "YX582198A", "PASSPORT", "11111132"),
    (swiss15, "JA386912A", "PASSPORT", "41111112"),
    (swiss16, "OR467671C", "PASSPORT", "14111112"),
    (swiss17, "KZ590149B", "PASSPORT", "11411112"),
    (swiss18, "XS956634C", "PASSPORT", "11141112"),
    (swiss19, "BS615566D", "PASSPORT", "11114112"),
    (swiss20, "HE312289B", "PASSPORT", "11111412"),
    (swiss21, "BP316737A", "PASSPORT", "11111142"),
    (swiss22, "CR998059A", "PASSPORT", "51111112"),
    (swiss23, "HM837305B", "PASSPORT", "15111112"),
    (swiss24, "JA362166C", "PASSPORT", "11511112"),
    (swiss25, "AZ750242B", "PASSPORT", "11151112"),
    (swiss26, "AG567289A", "PASSPORT", "11115112"),
    (swiss27, "ZT637433B", "PASSPORT", "11111512"),
    (swiss28, "ST155067A", "PASSPORT", "11111152"),
    (swiss29, "LW801391B", "PASSPORT", "61111112"),
    (swiss30, "BR019651A", "PASSPORT", "16111112"),
    (swiss31, "AC165243D", "PASSPORT", "11611112")
  ).map((Record.apply _).tupled)

}
