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

object DemoStubData extends DataSet {

  val lawrenceVelazquez: StatusCheckResult = StatusCheckResult(
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

  val wolfgangTraube: StatusCheckResult = StatusCheckResult(
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

  private val rosalieGallegos: StatusCheckResult = StatusCheckResult(
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

  private val nevioSabina: StatusCheckResult = StatusCheckResult(
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

  private val johnMillar: StatusCheckResult = StatusCheckResult(
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

  private val majaGlowa: StatusCheckResult = StatusCheckResult(
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

  private val ammarNaaji: StatusCheckResult = StatusCheckResult(
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

  private val amnaBoulos: StatusCheckResult = StatusCheckResult(
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

  val nabilSultan: StatusCheckResult = StatusCheckResult(
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

  private val alinafeTemitope: StatusCheckResult = StatusCheckResult(
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

  private val chidiebubeBabatunde: StatusCheckResult = StatusCheckResult(
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
    (chidiebubeBabatunde, "TK885367D", "BRP", "PY1234567")
  ).map((Record.apply _).tupled)
}
