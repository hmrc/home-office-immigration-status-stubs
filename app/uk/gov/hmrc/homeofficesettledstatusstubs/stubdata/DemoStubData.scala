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

object DemoStubData extends DataSet {

  val lawrenceVelazquez = StatusCheckResult(
    "Lawrence Velazquez",
    LocalDate.parse("04/10/1954", formatter),
    "CHE",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/07/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/01/2028", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("26/01/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/07/2021", formatter)),
        productType = "EUS",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val roosTewes = StatusCheckResult(
    "Roos Tewes",
    LocalDate.parse("30/06/1969", formatter),
    "NLD",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("21/07/2021", formatter),
        statusEndDate = Some(LocalDate.parse("20/01/2028", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("18/01/2021", formatter),
        statusEndDate = Some(LocalDate.parse("20/07/2021", formatter)),
        productType = "EUS",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = true
      )
    )
  )

  val stefanoReese = StatusCheckResult(
    "Stefano Reese",
    LocalDate.parse("27/02/1974", formatter),
    "EST",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/01/2021", formatter),
        statusEndDate = None,
        productType = "EUS",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("26/11/2020", formatter),
        statusEndDate = Some(LocalDate.parse("19/01/2021", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val marniDunkley = StatusCheckResult(
    "Marni Dunkley",
    LocalDate.parse("10/08/1983", formatter),
    "BEL",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("21/03/2021", formatter),
        statusEndDate = None,
        productType = "EUS",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("27/11/2020", formatter),
        statusEndDate = Some(LocalDate.parse("20/03/2021", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
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
        statusEndDate = Some(LocalDate.parse("28/01/2022", formatter)),
        productType = "EUS",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = true
      )
    )
  )

  val ignacSarlota = StatusCheckResult(
    "Ignac Sarlota",
    LocalDate.parse("20/10/1956", formatter),
    "CHE",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("30/04/2021", formatter),
        statusEndDate = None,
        productType = "EUS",
        immigrationStatus = "COA_IN_TIME_GRANT",
        noRecourseToPublicFunds = false
      )
    )
  )

  val rosalieGallegos = StatusCheckResult(
    "Rosalie Gallegos",
    LocalDate.parse("08/04/1987", formatter),
    "ESP",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("01/08/2021", formatter),
        statusEndDate = None,
        productType = "EUS",
        immigrationStatus = "POST_GRACE_PERIOD_COA_GRANT",
        noRecourseToPublicFunds = true
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("26/03/2021", formatter),
        statusEndDate = Some(LocalDate.parse("31/07/2021", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val nevioSabina = StatusCheckResult(
    "Nevio Sabina",
    LocalDate.parse("09/10/1956", formatter),
    "ITA",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("16/07/2021", formatter),
        statusEndDate = None,
        productType = "EUS",
        immigrationStatus = "POST_GRACE_PERIOD_COA_GRANT",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("27/01/2021", formatter),
        statusEndDate = Some(LocalDate.parse("15/07/2021", formatter)),
        productType = "DEPENDANT",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = true
      )
    )
  )

  val johnMillar = StatusCheckResult(
    "John Millar",
    LocalDate.parse("02/10/1954", formatter),
    "CHE",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("17/02/2021", formatter),
        statusEndDate = Some(LocalDate.parse("16/02/2028", formatter)),
        productType = "WORK",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val aleksandrovCherganski = StatusCheckResult(
    "Aleksandrov Cherganski",
    LocalDate.parse("23/09/1987", formatter),
    "ARM",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("01/06/2021", formatter),
        statusEndDate = Some(LocalDate.parse("30/11/2021", formatter)),
        productType = "WORK",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("04/01/2021", formatter),
        statusEndDate = Some(LocalDate.parse("31/05/2021", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val evaVassilis = StatusCheckResult(
    "Eva Vassilis",
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
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/03/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/09/2021", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val yvonneAlbin = StatusCheckResult(
    "Yvonne Albin",
    LocalDate.parse("06/04/1947", formatter),
    "FRA",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("18/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("17/11/2028", formatter)),
        productType = "WORK",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/01/2021", formatter),
        statusEndDate = Some(LocalDate.parse("17/05/2021", formatter)),
        productType = "DEPENDANT",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val elsaViggo = StatusCheckResult(
    "Elsa Viggo",
    LocalDate.parse("06/10/2000", formatter),
    "SWE",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/02/2021", formatter),
        statusEndDate = Some(LocalDate.parse("28/12/2021", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val majaGlowa = StatusCheckResult(
    "Maja Glowa",
    LocalDate.parse("06/10/2000", formatter),
    "POL",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("28/06/2021", formatter),
        statusEndDate = Some(LocalDate.parse("13/08/2021", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val jirinaJirankova = StatusCheckResult(
    "Jirina Jirankova",
    LocalDate.parse("24/09/1983", formatter),
    "CZE",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/02/2021", formatter),
        statusEndDate = Some(LocalDate.parse("18/08/2028", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      )
    )
  )

  val ammarNaaji = StatusCheckResult(
    "Ammar Naaji",
    LocalDate.parse("25/07/1978", formatter),
    "AFG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("20/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/03/2028", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("26/06/2021", formatter),
        statusEndDate = Some(LocalDate.parse("19/09/2021", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("19/04/2021", formatter),
        statusEndDate = Some(LocalDate.parse("25/06/2021", formatter)),
        productType = "DEPENDANT",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val amnaBoulos = StatusCheckResult(
    "Amna Boulos",
    LocalDate.parse("27/03/1981", formatter),
    "BHR",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("02/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("01/09/2028", formatter)),
        productType = "DEPENDANT",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = true
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("27/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("26/09/2021", formatter)),
        productType = "WORK",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val harunaAbiodun = StatusCheckResult(
    "Haruna Abiodun",
    LocalDate.parse("22/02/1991", formatter),
    "BWA",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("03/08/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/08/2028", formatter)),
        productType = "DEPENDANT",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("28/03/2021", formatter),
        statusEndDate = Some(LocalDate.parse("02/08/2021", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val luigiPisani = StatusCheckResult(
    "Luigi Pisani",
    LocalDate.parse("20/04/1935", formatter),
    "ITA",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("04/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("03/11/2028", formatter)),
        productType = "DEPENDANT",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      )
    )
  )

  val boseMwangi = StatusCheckResult(
    "Bose Mwangi",
    LocalDate.parse("09/09/1997", formatter),
    "EGY",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/08/2021", formatter),
        statusEndDate = Some(LocalDate.parse("04/12/2028", formatter)),
        productType = "DEPENDANT",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("09/02/2021", formatter),
        statusEndDate = Some(LocalDate.parse("04/08/2021", formatter)),
        productType = "DEPENDANT",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val sampsonPeel = StatusCheckResult(
    "Sampson Peel",
    LocalDate.parse("05/03/1996", formatter),
    "HKG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("06/02/2021", formatter),
        statusEndDate = Some(LocalDate.parse("05/12/2021", formatter)),
        productType = "BNO",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = true
      )
    )
  )

  val njeriSamara = StatusCheckResult(
    "Njeri Samara",
    LocalDate.parse("16/01/1973", formatter),
    "HKG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("07/06/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/06/2028", formatter)),
        productType = "BNO",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("26/02/2021", formatter),
        statusEndDate = Some(LocalDate.parse("06/06/2021", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val srinivasVemulakonda = StatusCheckResult(
    "Srinivas Vemulakonda",
    LocalDate.parse("17/01/1987", formatter),
    "HKG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("08/04/2021", formatter),
        statusEndDate = Some(LocalDate.parse("07/12/2028", formatter)),
        productType = "BNO",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      )
    )
  )

  val mohammedNajm = StatusCheckResult(
    "Mohammed Najm",
    LocalDate.parse("27/08/1987", formatter),
    "HKG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("15/07/2021", formatter),
        statusEndDate = Some(LocalDate.parse("14/12/2028", formatter)),
        productType = "BNO",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("26/02/2021", formatter),
        statusEndDate = Some(LocalDate.parse("14/07/2021", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val nabilSultan = StatusCheckResult(
    "Nabil Sultan",
    LocalDate.parse("01/04/1988", formatter),
    "HKG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("10/03/2021", formatter),
        statusEndDate = Some(LocalDate.parse("09/03/2028", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val ylliShehu = StatusCheckResult(
    "Ylli Shehu",
    LocalDate.parse("18/08/1996", formatter),
    "HKG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("11/08/2021", formatter),
        statusEndDate = Some(LocalDate.parse("10/08/2028", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("26/02/2021", formatter),
        statusEndDate = Some(LocalDate.parse("10/08/2021", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val chukwumaOkorie = StatusCheckResult(
    "Chukwuma Okorie",
    LocalDate.parse("15/06/1977", formatter),
    "HKG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("12/06/2020", formatter),
        statusEndDate = Some(LocalDate.parse("11/12/2028", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      )
    )
  )

  val kefilweOkonkwo = StatusCheckResult(
    "Kefilwe Okonkwo",
    LocalDate.parse("09/08/1974", formatter),
    "HKG",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("13/09/2021", formatter),
        statusEndDate = Some(LocalDate.parse("12/03/2028", formatter)),
        productType = "BNO_LOTR",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("26/02/2021", formatter),
        statusEndDate = Some(LocalDate.parse("12/09/2021", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val sibusisiweKamau = StatusCheckResult(
    "Sibusisiwe Kamau",
    LocalDate.parse("04/11/1976", formatter),
    "REU",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("14/02/2021", formatter),
        statusEndDate = Some(LocalDate.parse("13/08/2028", formatter)),
        productType = "GRADUATE",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      )
    )
  )

  val alinafeTemitope = StatusCheckResult(
    "Alinafe Temitope",
    LocalDate.parse("18/07/1974", formatter),
    "CRI",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("15/05/2021", formatter),
        statusEndDate = Some(LocalDate.parse("14/11/2028", formatter)),
        productType = "GRADUATE",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val chidiebubeBabatunde = StatusCheckResult(
    "Chidiebube Babatunde",
    LocalDate.parse("23/06/1996", formatter),
    "LCA",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("16/08/2021", formatter),
        statusEndDate = Some(LocalDate.parse("15/08/2028", formatter)),
        productType = "FRONTIER_WORKER",
        immigrationStatus = "PERMIT",
        noRecourseToPublicFunds = true
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("26/02/2021", formatter),
        statusEndDate = Some(LocalDate.parse("15/08/2021", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTE",
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
        statusStartDate = LocalDate.parse("17/06/2021", formatter),
        statusEndDate = Some(LocalDate.parse("16/06/2028", formatter)),
        productType = "FRONTIER_WORKER",
        immigrationStatus = "PERMIT",
        noRecourseToPublicFunds = false
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("27/02/2021", formatter),
        statusEndDate = Some(LocalDate.parse("16/06/2021", formatter)),
        productType = "WORK",
        immigrationStatus = "LTE",
        noRecourseToPublicFunds = false
      )
    )
  )

  val joeBloggs = StatusCheckResult(
    "Joe Bloggs",
    LocalDate.parse("01/01/1970", formatter),
    "FRA",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("01/06/2021", formatter),
        statusEndDate = None,
        productType = "EUS",
        immigrationStatus = "ILR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val anneBond = StatusCheckResult(
    "Anne Bond",
    LocalDate.parse("01/12/1975", formatter),
    "JAM",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("15/03/2021", formatter),
        statusEndDate = Some(LocalDate.parse("14/03/2028", formatter)),
        productType = "EUS",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = false
      )
    )
  )

  val johnSmith = StatusCheckResult(
    "John Smith",
    LocalDate.parse("01/06/1999", formatter),
    "AUS",
    List(
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("10/01/2022", formatter),
        statusEndDate = Some(LocalDate.parse("09/01/2028", formatter)),
        productType = "WORK",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      ),
      ImmigrationStatus(
        statusStartDate = LocalDate.parse("05/09/2020", formatter),
        statusEndDate = Some(LocalDate.parse("09/01/2022", formatter)),
        productType = "STUDY",
        immigrationStatus = "LTR",
        noRecourseToPublicFunds = true
      )
    )
  )

  override val records: Seq[Record] = Seq(
    (lawrenceVelazquez, "HT423277B", "PASSPORT", "123456789"),
    (wolfgangTraube, "AB807993C", "PASSPORT", "567891234"),
    (rosalieGallegos, "AB445870B", "PASSPORT", "789123456"),
    (johnMillar, "CB986300D", "NAT", "K5LTGREQ3"),
    (majaGlowa, "BS088353B", "NAT", "P9DGTHAX7"),
    (ammarNaaji, "ZL198221D", "NAT", "U2ETHGPL5"),
    (amnaBoulos, "TP469941B", "BRC", "ZU1234567"),
    (alinafeTemitope, "TZ650906D", "BRP", "DS1234567"),
    (chidiebubeBabatunde, "TK885367D", "BRP", "PY1234567"),
    (nevioSabina, "SJ372380A", "PASSPORT", "891234567"),
    (nabilSultan, "CP822334A", "BRP", "PR1234567"),
    (joeBloggs, "AB123456A", "PASSPORT", "XY1234567"),
    (anneBond, "AC123456B", "PASSPORT", "HJ1234567"),
    (johnSmith, "AE123456C", "PASSPORT", "RS1234567"),
    (roosTewes, "AB888330D", "PASSPORT", "234567891"),
    (stefanoReese, "KA339738D", "PASSPORT", "345678912"),
    (marniDunkley, "AB576139C", "PASSPORT", "456789123"),
    (ignacSarlota, "MZ006526C", "PASSPORT", "678912345"),
    (aleksandrovCherganski, "GT948987A", "NAT", "P6NGWATE1"),
    (evaVassilis, "OX749001C", "NAT", "N9LFUTWR4"),
    (yvonneAlbin, "LE183343C", "NAT", "L8FYTEHE2"),
    (elsaViggo, "OT575524B", "NAT", "M7FHRTEL6"),
    (jirinaJirankova, "JJ123456A", "NAT", "O9DAZHYX2"),
    (harunaAbiodun, "BY880209B", "BRC", "BR1234567"),
    (luigiPisani, "AB188148D", "BRC", "MY1234567"),
    (boseMwangi, "RK334595D", "BRC", "TR1234567"),
    (sampsonPeel, "KL254611D", "BRC", "DS1234567"),
    (njeriSamara, "BR253184", "BRC", "PO1234567"),
    (srinivasVemulakonda, "MA337091B", "BRC", "DC1234567"),
    (mohammedNajm, "AX906006B", "BRC", "SE1234567"),
    (ylliShehu, "EB119538A", "BRP", "GH1234567"),
    (chukwumaOkorie, "HT813285C", "BRP", "NB1234567"),
    (kefilweOkonkwo, "AH231261A", "BRP", "GH1234567"),
    (sibusisiweKamau, "HY950281B", "BRP", "FJ1234567"),
    (chidiebubeBabatunde, "TK885367D", "BRP", "PY1234567"),
    (sabeenMuhammad, "HN191408D", "BRP", "BG1234567")
  ).map((Record.apply _).tupled)

}
