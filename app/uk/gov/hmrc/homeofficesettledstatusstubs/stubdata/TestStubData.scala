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

package uk.gov.hmrc.homeofficesettledstatusstubs.stubdata

import uk.gov.hmrc.homeofficesettledstatusstubs.models._

import java.time.LocalDate

object TestStubData extends DataSet {

  val ignacSarlota = StatusCheckResult(
    "Ignác Šarlota",
    LocalDate.parse("20/10/1956", formatter),
    "CHE",
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

  val robinTens = StatusCheckResult(
    "Robin Tens",
    LocalDate.parse("30/06/1969", formatter),
    "NLD",
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

  val lawrenceSmith = StatusCheckResult(
    "Lawrence Smith",
    LocalDate.parse("04/10/1954", formatter),
    "CHE",
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

  val stefanieReason = StatusCheckResult(
    "Stefanie Reason",
    LocalDate.parse("27/02/1974", formatter),
    "EST",
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

  val sabeenMuhammad = StatusCheckResult(
    "Sabeen Muhammad",
    LocalDate.parse("06/05/1980", formatter),
    "SGS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/07/2020", formatter),
        statusEndDate = Some(LocalDate.parse("19/09/2021", formatter)),
        productType = "FRONTIER_WORKER",
        immigrationStatus = "PERMIT",
        noRecourseToPublicFunds = true
      )
    )
  )

  //  val chidiebubeBabatunde = StatusCheckResult(
  //    "Chidiebube Babatunde",
  //    LocalDate.parse("23/06/1996", formatter),
  //    "LCA",
  //    List(
  //      ImmigrationStatus(
  //        statusStartDate = LocalDate.parse("16/08/2021", formatter),
  //        statusEndDate = Some(LocalDate.parse("15/08/2022", formatter)),
  //        productType = "FRONTIER_WORKER",
  //        immigrationStatus = "PERMIT",
  //        noRecourseToPublicFunds = false
  //      )
  //    )
  //  )

  val joeBloggs = StatusCheckResult(
    "Joe Bloggs",
    LocalDate.parse("06/05/1980", formatter),
    "SGS",
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

  val joshBloggs = StatusCheckResult(
    "Josh Bloggs",
    LocalDate.parse("10/05/1990", formatter),
    "SGS",
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

  val wolfgangTraube = StatusCheckResult(
    "Wolfgang Traube",
    LocalDate.parse("26/08/1983", formatter),
    "DEU",
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

  val benBloggs = StatusCheckResult(
    "Ben Bloggs",
    LocalDate.parse("11/05/1990", formatter),
    "SGS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2021", formatter)),
        productType = "BNO",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val samSmith = StatusCheckResult(
    "Sam Smith",
    LocalDate.parse("11/05/1990", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2023", formatter)),
        productType = "SPORTSPERSON",
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

  val jenBright = StatusCheckResult(
    "Jen Bright",
    LocalDate.parse("11/05/1990", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2023", formatter)),
        productType = "SETTLEMENT",
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

  val alisonWright = StatusCheckResult(
    "Alison Wright",
    LocalDate.parse("11/05/1990", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "TEMP_WORKER",
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

  val aliWrightson = StatusCheckResult(
    "Alison Wright",
    LocalDate.parse("11/05/1990", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "BNO",
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

  val sarahSmith = StatusCheckResult(
    "Sarah Smith",
    LocalDate.parse("11/05/1990", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "BNO",
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

  val lucySprag = StatusCheckResult(
    "Lucy Sprag",
    LocalDate.parse("11/05/1990", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "BNO",
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

  val jimmyBrown = StatusCheckResult(
    "Jimmy Brown",
    LocalDate.parse("11/05/1990", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "BNO",
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

  val eveVassil = StatusCheckResult(
    "Eve Vassil",
    LocalDate.parse("22/05/1976", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/03/2024", formatter)),
        productType = "WORK",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("17/06/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/09/2021", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val peteWolf = StatusCheckResult(
    "Pete Wolf",
    LocalDate.parse("30/06/1969", formatter),
    "NLD",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("21/07/2021", formatter),
        statusEndDate = Some(LocalDate.parse("20/07/2050", formatter)),
        productType = "LEM",
        immigrationStatus = "ING",
        noRecourseToPublicFunds = false
      )
    )
  )

  val nevioSabina = StatusCheckResult(
    "Nevio Sabina",
    LocalDate.parse("9/10/1956", formatter),
    "ESP",
    Nil
  )
  val perfTestEU = StatusCheckResult(
    "Stefano Reese",
    LocalDate.parse("27/02/1974", formatter),
    "ESP",
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

  val perfTestNonEU = StatusCheckResult(
    "Sarah Smith",
    LocalDate.parse("11/05/1990", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2022", formatter)),
        productType = "BNO",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = true
      )
    )
  )
  val SuzyWolf = StatusCheckResult(
    "Suzy Wolf",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        productType = "EUS_TCNBRC_JFM",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val SuzyWolf1 = StatusCheckResult(
    "Suzy Wolf",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        productType = "EUS_JFM",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val accessibility = StatusCheckResult(
    "Suzy Wolf",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        productType = "EUS_JFM",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val SuzyWolf2 = StatusCheckResult(
    "Suzy Wolf",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        productType = "EUS_JFM",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )
  val SuzyWolf3 = StatusCheckResult(
    "Suzy Wolf",
    LocalDate.parse("25/07/1978", formatter),
    "AFG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/03/2024", formatter)),
        productType = "EUS",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("26/06/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/09/2021", formatter)),
        productType = "EUS_EUN_JFM",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2021", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2021", formatter)),
        productType = "EUS_EUN_JFM",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2020", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2020", formatter)),
        productType = "EUS_EUN_JFM",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2019", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2019", formatter)),
        productType = "EUS_TCN_JFM",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2018", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2018", formatter)),
        productType = "EUS_TCN_JFM",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2017", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2017", formatter)),
        productType = "EUS_TCN_JFM",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2016", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2016", formatter)),
        productType = "EUS_TCNBRC_JFM",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2015", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2015", formatter)),
        productType = "EUS_TCNBRC_JFM",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2014", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2014", formatter)),
        productType = "EUS_TCNBRC_JFM",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2013", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2013", formatter)),
        productType = "EUS_JFM",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2012", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2012", formatter)),
        productType = "EUS_JFM",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2011", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2011", formatter)),
        productType = "EUS_JFM",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2010", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2010", formatter)),
        productType = "EUS_FMFW",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2009", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2009", formatter)),
        productType = "EUS_FMFW",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2008", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2008", formatter)),
        productType = "EUS_FMFW",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )
  val accessibility1 = StatusCheckResult(
    "Alinafe Temitope",
    LocalDate.parse("18/07/1974", formatter),
    "CRI",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("15/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("14/11/2023", formatter)),
        productType = "GRADUATE",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      )
    )
  )

  val PROTECTION1 = StatusCheckResult(
    "Suzy Wolf",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        productType = "PROTECTION",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val PROTECTION2 = StatusCheckResult(
    "Suzy Wolf",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("15/11/2021", formatter),
        statusEndDate = Some(LocalDate.parse("15/12/2021", formatter)),
        productType = "PROTECTION",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      )
    )
  )
  val PROTECTION3 = StatusCheckResult(
    "Suzy Wolf",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2022", formatter),
        productType = "PROTECTION_ROUTE",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      )
    )
  )
  val PROTECTION4 = StatusCheckResult(
    "Suzy Wolf",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("15/11/2021", formatter),
        statusEndDate = Some(LocalDate.parse("15/12/2021", formatter)),
        productType = "PROTECTION_ROUTE",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      )
    )
  )

  val frankieHolliwood = StatusCheckResult(
    "Frank Hollywood",
    LocalDate.parse("11/05/1990", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("04/09/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2023", formatter)),
        productType = "SETTLEMENT",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("01/09/2020", formatter),
        statusEndDate = Some(LocalDate.parse("03/09/2020", formatter)),
        productType = "PROTECTION",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2019", formatter),
        statusEndDate = Some(LocalDate.parse("03/09/2019", formatter)),
        productType = "DEPENDANT",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val emmaBunton = StatusCheckResult(
    "Emma Bunton",
    LocalDate.parse("11/05/1990", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("06/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2023", formatter)),
        productType = "SETTLEMENT",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("04/09/2020", formatter),
        statusEndDate = Some(LocalDate.parse("05/09/2020", formatter)),
        productType = "PROTECTION_ROUTE",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2020", formatter),
        statusEndDate = Some(LocalDate.parse("03/09/2020", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("01/09/2019", formatter),
        statusEndDate = Some(LocalDate.parse("01/09/2020", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val DEPENDANT1 = StatusCheckResult(
    "Suzy Wolf",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2022", formatter),
        productType = "DEPENDANT",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = true
      )
    )
  )
  val DEPENDANT2 = StatusCheckResult(
    "Suzy Wolf",
    LocalDate.parse("15/10/1971", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("15/11/2021", formatter),
        statusEndDate = Some(LocalDate.parse("15/12/2021", formatter)),
        productType = "DEPENDANT",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = true
      )
    )
  )

  val sabShah = StatusCheckResult(
    "Sab Shah",
    LocalDate.parse("06/05/1980", formatter),
    "AFG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("17/06/2021", formatter),
        statusEndDate = Some(LocalDate.parse("16/06/2022", formatter)),
        productType = "FRONTIER_WORKER",
        immigrationStatus = "PERMIT",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("27/02/2021", formatter),
        statusEndDate = Some(LocalDate.parse("16/06/2021", formatter)),
        productType = "DEPENDANT_ACRS_PARTNER_LOTR",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("27/02/2020", formatter),
        statusEndDate = Some(LocalDate.parse("16/06/2020", formatter)),
        productType = "DEPENDANT_AOP_CHILD_LOTR",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )
  val coaIndate = StatusCheckResult(
    "Kerry Kane",
    LocalDate.parse("24/09/1983", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        statusEndDate = Some(LocalDate.parse("25/02/2022", formatter)),
        productType = "EUS_JFM",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val coaNoEnd = StatusCheckResult(
    "Kerry Kane",
    LocalDate.parse("24/09/1983", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        productType = "EUS_JFM",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val coaexp = StatusCheckResult(
    "Kerry Kane",
    LocalDate.parse("24/09/1983", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        statusEndDate = Some(LocalDate.parse("23/01/2022", formatter)),
        productType = "EUS_JFM",
        immigrationStatus = "COA_IN_TIME_GRANT",
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
  val amnaBoulos1 = StatusCheckResult(
    "Amna Boulos",
    LocalDate.parse("27/03/1981", formatter),
    "BHR",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("01/01/2022", formatter)),
        productType = "DEPENDANT",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = true
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

  override val records: Seq[Record] = Seq(
    (ignacSarlota, "MZ006526D", "NAT", "MZ006526"),
    (robinTens, "AB116565A", "NAT", "AB116565"),
    (lawrenceSmith, "HT423288B", "NAT", "HT423288"),
    (stefanieReason, "KA339728D", "NAT", "KA339728"),
    (sabeenMuhammad, "HN191408A", "NAT", "HN191408"),
    (joeBloggs, "CS601937B", "NAT", "CS601937"),
    (joshBloggs, "XC858842B", "NAT", "XC858842"),
    (benBloggs, "CS601937C", "NAT", "CS601937"),
    (wolfgangTraube, "YT750325A", "NAT", "YT750325"),
    (samSmith, "JZ899721D", "NAT", "JZ899721"),
    (jenBright, "TX721235B", "NAT", "TX721235"),
    (alisonWright, "EP640312A", "NAT", "EP640312"),
    (perfTestEU, "LA199424C", "NAT", "11111111"),
    (perfTestEU, "EK993922B", "BRP", "11111111"),
    (perfTestEU, "MS742656C", "BRC", "11111111"),
    (perfTestEU, "PC398873D", "PASSPORT", "11111111"),
    (perfTestNonEU, "MN828773C", "NAT", "11111117"),
    (perfTestNonEU, "EJ836244D", "BRP", "11111117"),
    (perfTestNonEU, "RP568106D", "BRC", "11111117"),
    (perfTestNonEU, "PB321979B", "PASSPORT", "11111117"),
    (peteWolf, "RR741365B", "NAT", "RR741365"),
    (SuzyWolf3, "NL989651A", "BRP", "11111112"),
    (sabShah, "RE742652B", "BRP", "ABC1888B"),
    (coaIndate, "TP923351D", "BRP", "UTD1888B"),
    (coaexp, "RH758871B", "BRP", "UTD4488B"),
    (coaNoEnd, "JP547629C", "BRP", "UTD4499B"),
    (eveVassil, "JE612281A", "NAT", "JE612281"),
    (nevioSabina, "ZL341566D", "NAT", "ZL341566"),
    (swiss13, "HX655935B", "PASSPORT", "11111312"),
    (swiss6, "MZ999673A", "PASSPORT", "11111212"),
    (amnaBoulos1, "WH094524D", "BRC", "ZU1234568"),
    (swiss1, "NP806400D", "PASSPORT", "21111112")
    //
    //delete -------------------------------------------
    //
    //    (aliWrightson, "WY706993C", "NAT", "WY706993"),
    //    (DEPENDANT2, "LM020319A", "BRP", "ABC8888B"),
    //    (DEPENDANT1, "OR198031C", "BRP", "ABC8888A"),
    //    (emmaBunton, "HS193209B", "BRC", "ABC88888"),
    //    (frankieHolliwood, "CM878654C", "BRC", "ABC8D888"),
    //    (PROTECTION4, "MJ738984A", "BRP", "ABC88888"),
    //    (PROTECTION3, "RJ485028C", "BRP", "ABCDEF888"),
    //    (PROTECTION2, "RN207514D", "BRP", "ABCDE8888"),
    //    (PROTECTION1, "EC930911B", "BRP", "ABCD88888"),
    //    (accessibility1, "NL989659S", "BRP", "888888888"),
    //    (SuzyWolf2, "GX467424A", "BRP", "11111112"),
    //    (accessibility, "TM200512R", "BRC", "9999999999"),
    //    (SuzyWolf1, "TM200512A", "NAT", "11111112"),
    //    (SuzyWolf, "YB987611D", "PASSPORT", "11111112"),
    //    (lucySprag, "NJ288804C", "NAT", "NJ288804"),
    //    (jimmyBrown, "ZL048657A", "NAT", "ZL048657"),
    //    (sarahSmith, "RR741495B", "NAT", "RR741495"),
  ).map((Record.apply _).tupled)

}
