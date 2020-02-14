/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.homeofficesettledstatusstubs.models

trait StatusResultExamples {

  val NINO_VALID = "RJ301829A"
  val NINO_VALID_BUT_UNKNOWN = "MG199709D"

  val examples: Map[String, String] =
    Map(
      NINO_VALID  -> s"""{
                       |  "correlationId": "{correlationId}",
                       |  "result": {
                       |    "dateOfBirth": "2001-01-31",
                       |    "nationality": "IRL",
                       |    "fullName": "Jane Doe",
                       |    "statuses": [
                       |      {
                       |        "productType": "EUS",
                       |        "immigrationStatus": "ILR",
                       |        "noRecourseToPublicFunds": true,
                       |        "statusStartDate": "2018-01-31",
                       |        "statusEndDate": "2018-12-12"
                       |      }
                       |    ]
                       |  }
                       |}""".stripMargin,
      "HT423277B" -> s"""{
                        |  "correlationId": "{correlationId}",
                        |  "result": {
                        |    "dateOfBirth": "1954-10-04",
                        |    "nationality": "CHE",
                        |    "fullName": "Lawrence Velazquez",
                        |    "statuses": [
                        |      {
                        |        "productType": "EUS",
                        |        "immigrationStatus": "LTR",
                        |        "noRecourseToPublicFunds": true,
                        |        "statusStartDate": "2015-02-26",
                        |        "statusEndDate": "2020-03-19"
                        |      }
                        |    ]
                        |  }
                        |}""".stripMargin,
      "AB888330D" -> s"""{
                        |  "correlationId": "{correlationId}",
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
                        |}""".stripMargin,
      "KA339738D" -> s"""{
                        |  "correlationId": "{correlationId}",
                        |  "result": {
                        |    "dateOfBirth": "1974-02-27",
                        |    "nationality": "EST",
                        |    "fullName": "Stefano Reese",
                        |    "statuses": [
                        |      {
                        |        "productType": "EUS",
                        |        "immigrationStatus": "LTR",
                        |        "noRecourseToPublicFunds": true,
                        |        "statusStartDate": "2016-02-08",
                        |        "statusEndDate": "2023-03-27"
                        |      }
                        |    ]
                        |  }
                        |}""".stripMargin,
      "AB576139C" -> s"""{
                        |  "correlationId": "{correlationId}",
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
                        |}""".stripMargin,
      "AB807993C" -> s"""{
                        |  "correlationId": "{correlationId}",
                        |  "result": {
                        |    "dateOfBirth": "1983-08-26",
                        |    "nationality": "D",
                        |    "fullName": "Wolfgang Traübe",
                        |    "statuses": [
                        |      {
                        |        "productType": "EUS",
                        |        "immigrationStatus": "LTR",
                        |        "noRecourseToPublicFunds": true,
                        |        "statusStartDate": "2016-06-20",
                        |        "statusEndDate": "2027-06-24"
                        |      }
                        |    ]
                        |  }
                        |}""".stripMargin,
      "AB445870B" -> s"""{
                        |  "correlationId": "{correlationId}",
                        |  "result": {
                        |    "dateOfBirth": "1987-04-08",
                        |    "nationality": "ESP",
                        |    "fullName": "Rosalie Gallegos",
                        |    "statuses": [
                        |      {
                        |        "productType": "EUS",
                        |        "immigrationStatus": "LTR",
                        |        "noRecourseToPublicFunds": true,
                        |        "statusStartDate": "2016-11-08",
                        |        "statusEndDate": "2030-06-17"
                        |      }
                        |    ]
                        |  }
                        |}""".stripMargin,
      "GT948987A" -> s"""{
                        |  "correlationId": "{correlationId}",
                        |  "result": {
                        |    "dateOfBirth": "1987-09-23",
                        |    "nationality": "BGR",
                        |    "fullName": "Aleksandrov Cherganski",
                        |    "statuses": [
                        |      {
                        |        "productType": "EUS",
                        |        "immigrationStatus": "LTR",
                        |        "noRecourseToPublicFunds": false,
                        |        "statusStartDate": "2019-12-01",
                        |        "statusEndDate": "2019-12-31"
                        |      }
                        |    ]
                        |  }
                        |}""".stripMargin,
      "BS088353B" -> s"""{
                        |  "correlationId": "{correlationId}",
                        |  "result": {
                        |    "dateOfBirth": "2000-10-06",
                        |    "nationality": "POL",
                        |    "fullName": "Maja Głowa",
                        |    "statuses": [
                        |      {
                        |        "productType": "EUS",
                        |        "immigrationStatus": "LTR",
                        |        "noRecourseToPublicFunds": true,
                        |        "statusStartDate": "2019-06-28",
                        |        "statusEndDate": "2024-06-28"
                        |      },
                        |      {
                        |        "productType": "EUS",
                        |        "immigrationStatus": "ILR",
                        |        "noRecourseToPublicFunds": true,
                        |        "statusStartDate": "2024-06-28"
                        |      }
                        |    ]
                        |  }
                        |}""".stripMargin
    )

}
