/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.homeofficesettledstatusstubs.models

trait StatusResultExamples {

  val NINO_VALID = "RJ301829A"
  val NINO_VALID_BUT_UNKNOWN = "MG199709D"

  def resultFor(correlationId: String, nino: String): Option[String] = nino match {
    case "RJ301829A" =>
      Some(
        s"""{
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
      Some(
        s"""{
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
      Some(
        s"""{
           |  "correlationId": "$correlationId",
           |  "result": {
           |    "dateOfBirth": "1969-06-30",
           |    "nationality": "NLD",
           |    "fullName": "Roos Tewes",
           |    "statuses": [
           |      {
           |        "productType": "EUS",
           |        "immigrationStatus": "ILR",
           |        "noRecourseToPublicFunds": false,
           |        "statusStartDate": "2015-09-18"
           |      }
           |    ]
           |  }
           |}""".stripMargin)

    case "KA339738D" =>
      Some(
        s"""{
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
      Some(
        s"""{
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
      Some(
        s"""{
           |  "correlationId": "$correlationId",
           |  "result": {
           |    "dateOfBirth": "1983-08-26",
           |    "nationality": "D",
           |    "fullName": "Wolfgang Traübe",
           |    "statuses": [
           |      {
           |        "productType": "EUS",
           |        "immigrationStatus": "ILR",
           |        "noRecourseToPublicFunds": false,
           |        "statusStartDate": "2016-06-20"
           |      }
           |    ]
           |  }
           |}""".stripMargin)

    case "AB445870B" =>
      Some(
        s"""{
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
      Some(
        s"""{
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
      Some(
        s"""{
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
      Some(
        s"""{
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
      Some(
        s"""{
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
      Some(
        s"""{
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
      Some(
        s"""{
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
           |        "statusEndDate": "2025-12-25"
           |      }
           |    ]
           |  }
           |}""".stripMargin)
    case "CB986300D" =>
      Some(
        s"""{
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

    case _ => None
  }

}
