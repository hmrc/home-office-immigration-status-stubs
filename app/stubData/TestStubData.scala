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

package stubData

import models._

import java.time.LocalDate

object TestStubData extends DataSet {

  private val ignacSarlota: StatusCheckResult = StatusCheckResult(
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

  private val robinTens: StatusCheckResult = StatusCheckResult(
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

  private val lawrenceSmith: StatusCheckResult = StatusCheckResult(
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

  private val stefanieReason: StatusCheckResult = StatusCheckResult(
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

  private val sabeenMuhammad1: StatusCheckResult = StatusCheckResult(
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

  private val joeBloggs: StatusCheckResult = StatusCheckResult(
    "Joe Bloggs",
    LocalDate.parse("06/05/1980", formatter),
    "SGS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("16/08/2021", formatter),
        statusEndDate = Some(LocalDate.parse("15/08/2028", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  private val joshBloggs: StatusCheckResult = StatusCheckResult(
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

  private val wolfgangTraube: StatusCheckResult = StatusCheckResult(
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

  private val benBloggs: StatusCheckResult = StatusCheckResult(
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

  private val samSmith: StatusCheckResult = StatusCheckResult(
    "Sam Smith",
    LocalDate.parse("11/05/1990", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2028", formatter)),
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

  private val jenBright: StatusCheckResult = StatusCheckResult(
    "Jen Bright",
    LocalDate.parse("11/05/1990", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2028", formatter)),
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

  private val alisonWright1: StatusCheckResult = StatusCheckResult(
    "Alison Wright",
    LocalDate.parse("11/05/1990", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/08/2028", formatter)),
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

  private val alisonWright2: StatusCheckResult = StatusCheckResult(
    "Alison Wright",
    LocalDate.parse("11/05/1990", formatter),
    "AFG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        productType = "SETTLEMENT_ALES",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2020", formatter)),
        productType = "DEPENDANT_ALES_PARTNER",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/10/2020", formatter),
        statusEndDate = Some(LocalDate.parse("06/10/2019", formatter)),
        productType = "DEPENDANT_AOP_OTHER",
        immigrationStatus = "ILE",
        noRecourseToPublicFunds = false
      )
    )
  )

  private val eveVassil: StatusCheckResult = StatusCheckResult(
    "Eve Vassil",
    LocalDate.parse("22/05/1976", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/03/2028", formatter)),
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

  private val peteWolf: StatusCheckResult = StatusCheckResult(
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

  private val nevioSabina: StatusCheckResult = StatusCheckResult(
    "Nevio Sabina",
    LocalDate.parse("9/10/1956", formatter),
    "ESP",
    Nil
  )

  private val perfTestEU: StatusCheckResult = StatusCheckResult(
    "Stefano Reese",
    LocalDate.parse("27/02/1974", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2028", formatter)),
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

  private val perfTestNonEU: StatusCheckResult = StatusCheckResult(
    "Sarah Smith",
    LocalDate.parse("11/05/1990", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2028", formatter)),
        productType = "BNO",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = true
      )
    )
  )

  private val suzyWolf: StatusCheckResult = StatusCheckResult(
    "Suzy Wolf",
    LocalDate.parse("25/07/1978", formatter),
    "AFG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/03/2028", formatter)),
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

  private val suzyWolfSmith: StatusCheckResult = StatusCheckResult(
    "Suzy Wolf-Smith",
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

  private val sabShah: StatusCheckResult = StatusCheckResult(
    "Sab Shah",
    LocalDate.parse("06/05/1980", formatter),
    "AFG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("17/06/2021", formatter),
        statusEndDate = Some(LocalDate.parse("16/06/2028", formatter)),
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

  private val kerryKaneCoaInDate: StatusCheckResult = StatusCheckResult(
    "Kerry Kane",
    LocalDate.parse("24/09/1983", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/10/2021", formatter),
        statusEndDate = Some(LocalDate.parse("25/02/2028", formatter)),
        productType = "EUS_JFM",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  private val kerryKaneCoaExp: StatusCheckResult = StatusCheckResult(
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

  private val sabeenMuhammad2: StatusCheckResult = StatusCheckResult(
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

  private val amnaBoulos: StatusCheckResult = StatusCheckResult(
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

  private val alisonWright3: StatusCheckResult = StatusCheckResult(
    "Alison Wright",
    LocalDate.parse("11/05/1990", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/02/2028", formatter)),
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

  private val sarahSmith: StatusCheckResult = StatusCheckResult(
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
    (sabeenMuhammad1, "HN191408A", "NAT", "HN191408"),
    (joeBloggs, "CS601937B", "NAT", "CS601937"),
    (joshBloggs, "XC858842B", "NAT", "XC858842"),
    (benBloggs, "CS601937C", "NAT", "CS601937"),
    (wolfgangTraube, "YT750325A", "NAT", "YT750325"),
    (samSmith, "JZ899721D", "NAT", "JZ899721"),
    (jenBright, "TX721235B", "NAT", "TX721235"),
    (alisonWright1, "EP640312A", "NAT", "EP640312"),
    (perfTestEU, "LA199424C", "NAT", "11111111"),
    (perfTestEU, "EK993922B", "BRP", "11111111"),
    (perfTestEU, "MS742656C", "BRC", "11111111"),
    (perfTestEU, "PC398873D", "PASSPORT", "11111111"),
    (perfTestNonEU, "MN828773C", "NAT", "11111117"),
    (perfTestNonEU, "EJ836244D", "BRP", "11111117"),
    (perfTestNonEU, "RP568106D", "BRC", "11111117"),
    (perfTestNonEU, "PB321979B", "PASSPORT", "11111117"),
    (peteWolf, "RR741365B", "NAT", "RR741365"),
    (suzyWolf, "NL989651A", "BRP", "11111112"),
    (sabShah, "RE742652B", "BRP", "ABC1888B"),
    (kerryKaneCoaInDate, "TP923351D", "BRP", "UTD1888B"),
    (kerryKaneCoaExp, "RH758871B", "BRP", "UTD4488B"),
    (eveVassil, "JE612281A", "NAT", "JE612281"),
    (nevioSabina, "ZL341566D", "NAT", "ZL341566"),
    (alisonWright3, "HX655935B", "PASSPORT", "11111312"),
    (sabeenMuhammad2, "MZ999673A", "PASSPORT", "11111212"),
    (amnaBoulos, "WH094524D", "BRC", "ZU1234568"),
    (suzyWolfSmith, "EC930911B", "BRP", "ABCD88888"),
    (sarahSmith, "NP806400D", "PASSPORT", "21111112"),
    (alisonWright2, "WY706993C", "NAT", "WY706993")
  ).map((Record.apply _).tupled)
}
