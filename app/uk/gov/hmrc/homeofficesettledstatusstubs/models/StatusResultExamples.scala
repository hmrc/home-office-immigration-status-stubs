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
              |        "noRecourseToPublicFunds": false,
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
              |        "noRecourseToPublicFunds": false,
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
              |        "statusStartDate": "2019-12-01"
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
              |        "noRecourseToPublicFunds": false,
              |        "statusStartDate": "2020-01-28"
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
              |        "statusStartDate": "2019-01-01",
              |        "statusEndDate": "2020-02-15"
              |      }
              |    ]
              |  }
              |}""".stripMargin)

    case _ => None
  }

}
