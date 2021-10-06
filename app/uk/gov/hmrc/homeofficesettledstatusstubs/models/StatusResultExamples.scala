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

package uk.gov.hmrc.homeofficesettledstatusstubs.models

trait StatusResultExamples {

  val NINO_VALID = "RJ301829A"
  val NINO_VALID_BUT_UNKNOWN = "MG199709D"

  def resultFor(correlationId: String, nino: String): Option[String] = nino match {
    case "RJ301829A" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "2001-01-31",
              |    "nationality": "IRL",
              |    "fullName": "Jane Doe",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "ILR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2018-01-31",
              |        "statusEndDate": "2018-12-12"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "HT423277B" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1954-10-04",
              |    "nationality": "CHE",
              |    "fullName": "Lawrence Velazquez",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "LTR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2015-02-26",
              |        "statusEndDate": "2020-03-19"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "AB888330D" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1969-06-30",
              |    "nationality": "NLD",
              |    "fullName": "Roos Tewes",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "ILR",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2015-09-18"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "KA339738D" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1974-02-27",
              |    "nationality": "EST",
              |    "fullName": "Stefano Reese",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "LTR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2016-02-08",
              |        "statusEndDate": "2023-03-27"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "AB576139C" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1983-08-10",
              |    "nationality": "BEL",
              |    "fullName": "Marni Dunkley",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "LTR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2016-11-08",
              |        "statusEndDate": "2030-06-17"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "AB807993C" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1983-08-26",
              |    "nationality": "D",
              |    "fullName": "Wolfgang Traübe",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "ILR",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2016-06-20"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "AB445870B" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1987-04-08",
              |    "nationality": "ESP",
              |    "fullName": "Rosalie Gallegos",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "LTR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2016-11-08",
              |        "statusEndDate": "2030-06-17"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "GT948987A" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1987-09-23",
              |    "nationality": "ARM",
              |    "fullName": "Aleksandrov Cherganski",
              |    "statuses": [
              |      {
              |        "productType": "FOO",
              |        "immigrationStatus": "FOO",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2019-12-01",
              |        "statusEndDate": "2021-11-30"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "BS088353B" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "2000-10-06",
              |    "nationality": "POL",
              |    "fullName": "Maja Głowa",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "LTR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2019-06-28",
              |        "statusEndDate": "2020-01-28"
              |      },
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "ILR",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2020-01-28"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "OX749001C" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1976-05-22",
              |    "nationality": "GRC",
              |    "fullName": "Eva Vassilis",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "ILR",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2014-10-12",
              |        "statusEndDate": "2019-10-11"
              |      },
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "LTR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2020-04-01",
              |        "statusEndDate": "2022-03-31"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "LE183343C" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1947-04-06",
              |    "nationality": "FRA",
              |    "fullName": "Yvonne Albin",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "ILR",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2015-01-19",
              |        "statusEndDate": "2020-01-20"
              |      },
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "LTR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2020-03-20",
              |        "statusEndDate": "2020-03-31"
              |      },
              |      {
              |      "productType": "EUS",
              |        "immigrationStatus": "LTR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2020-04-01",
              |        "statusEndDate": "2025-04-11"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "OT575524B" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "2000-10-06",
              |    "nationality": "SWE",
              |    "fullName": "Elsa Viggo",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "LTR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2017-12-17",
              |        "statusEndDate": "2019-12-18"
              |      },
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "LTR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2020-02-15",
              |        "statusEndDate": "2025-12-18"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "AB188148D" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1935-04-20",
              |    "nationality": "ITA",
              |    "fullName": "Luigi Pisani",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "ILR",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2020-02-15",
              |        "statusEndDate": "2020-02-15"
              |      },
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "ILR",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2020-02-16",
              |        "statusEndDate": "2030-12-25"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "CB986300D" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1954-10-02",
              |    "nationality": "CHE",
              |    "fullName": "John Millar",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "LTR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2014-11-03",
              |        "statusEndDate": "2019-11-02"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "SJ372380A" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1956-10-09",
              |    "nationality": "ITA",
              |    "fullName": "Nevio Sabina",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "ILR",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2014-11-21",
              |        "statusEndDate": "2019-11-20"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "MZ006526D" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1956-10-20",
              |    "nationality": "CHE",
              |    "fullName": "Ignác Šarlota",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "ILR",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2015-04-30",
              |        "statusEndDate": "2020-05-29"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "AB807993D" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1983-08-26",
              |    "nationality": "D",
              |    "fullName": "Wolfgang Does",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "COA_IN_TIME_GRANT",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2016-06-20"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "AB107993D" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1976-01-10",
              |    "nationality": "D",
              |    "fullName": "Margaret Alex",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "COA_IN_TIME_GRANT",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2016-06-20",
              |        "statusEndDate": "2019-06-17"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "BS078353C" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "2000-10-06",
              |    "nationality": "POL",
              |    "fullName": "Robert Paul",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "ILR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2021-01-01",
              |        "statusEndDate": "2030-01-28"
              |      },
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "COA_IN_TIME_GRANT",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2018-01-28",
              |        "statusEndDate": "2020-12-31"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "BS088353D" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1957-10-17",
              |    "nationality": "IND",
              |    "fullName": "Anne Sus",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "ILR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2020-01-01",
              |        "statusEndDate": "2021-01-28"
              |      },
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "COA_IN_TIME_GRANT",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2018-01-28",
              |        "statusEndDate": "2020-12-31"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "OX749001A" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1976-05-22",
              |    "nationality": "GRC",
              |    "fullName": "Eva Vassilis",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "LTR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2018-01-21",
              |        "statusEndDate": "2020-12-31"
              |      },
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "COA_IN_TIME_GRANT",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2021-01-01",
              |        "statusEndDate": "2030-10-11"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "AB877993D" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1983-08-26",
              |    "nationality": "D",
              |    "fullName": "Jackson Great",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "POST_GRACE_PERIOD_COA_GRANT",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2016-06-20"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "AB445870C" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1987-04-08",
              |    "nationality": "ESP",
              |    "fullName": "Rosalie Morrison",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "POST_GRACE_PERIOD_COA_GRANT",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2016-11-08",
              |        "statusEndDate": "2030-06-17"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "OX749001B" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1966-05-21",
              |    "nationality": "GRC",
              |    "fullName": "Martin Odersky",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "POST_GRACE_PERIOD_COA_GRANT",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2021-01-01",
              |        "statusEndDate": "2030-10-11"
              |      },
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "ILR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2018-01-21",
              |        "statusEndDate": "2020-12-31"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "AX749001D" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1977-03-22",
              |    "nationality": "AUS",
              |    "fullName": "Ricky Ponting",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "POST_GRACE_PERIOD_COA_GRANT",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2019-01-01",
              |        "statusEndDate": "2020-10-11"
              |      },
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "LTR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2018-01-21",
              |        "statusEndDate": "2020-12-31"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case "BS088353A" =>
      Some(s"""{
              |  "correlationId": "$correlationId",
              |  "result": {
              |    "dateOfBirth": "1986-08-19",
              |    "nationality": "FRA",
              |    "fullName": "Samuel Amos",
              |    "statuses": [
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "ILR",
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2020-01-01",
              |        "statusEndDate": "2030-01-28"
              |      },
              |      {
              |        "productType": "EUS",
              |        "immigrationStatus": "POST_GRACE_PERIOD_COA_GRANT",
              |        "noRecourseToPublicFunds": true,
              |        "statusStartDate": "2018-01-28",
              |        "statusEndDate": "2020-12-31"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    // EMPTY RESPONSE WITH 200 STATUS
    case "ZL198221D" =>
      Some(s"""{
              |  "correlationId": "$correlationId"
              |}""".stripMargin)

    // TOO MANY REQUESTS ERROR WITH 429 STATUS
    case "TP469941B" =>
      Some(s"""{
              |  "status": 429,
              |  "correlationId": "$correlationId",
              |  "error": {
              |     "errCode": "[NOT_USED]"
              |  }
              |}""".stripMargin)

    // INTERNAL SERVICE ERROR WITH STATUS 500
    case "BY880209B" =>
      Some(s"""{
              |  "status": 500,
              |  "correlationId": "$correlationId",
              |  "error": {
              |     "errCode": "[NOT_USED]"
              |  }
              |}""".stripMargin)

    case _ => None
  }

}
