/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.homeofficesettledstatusstubs.models

trait StatusResultExamples {

  val NINO_VALID_1 = "RJ301829A"
  val NINO_VALID_BUT_UNKNOWN = "MG199709D"

  val examples: Map[String, String] =
    Map(
      NINO_VALID_1 -> s"""{
                         |  "correlationId": "{correlationId}",
                         |  "result": {
                         |    "dateOfBirth": "2001-01-31",
                         |    "facialImage": "string",
                         |    "fullName": "Jane Doe",
                         |    "statuses": [
                         |      {
                         |        "immigrationStatus": "ILR",
                         |        "rightToPublicFunds": true,
                         |        "statusEndDate": "2018-01-31",
                         |        "statusStartDate": "2018-12-12"
                         |      }
                         |    ]
                         |  }
                         |}""".stripMargin,
      "HT423277B"  -> s"""{
                        |  "correlationId": "{correlationId}",
                        |  "result": {
                        |    "dateOfBirth": "1954-10-04",
                        |    "facialImage": "string",
                        |    "fullName": "Lawrence Velazquez",
                        |    "statuses": [
                        |      {
                        |        "immigrationStatus": "LTR",
                        |        "rightToPublicFunds": true,
                        |        "statusEndDate": "2015-02-26",
                        |        "statusStartDate": "2020-03-19"
                        |      }
                        |    ]
                        |  }
                        |}""".stripMargin,
      "AB888330D"  -> s"""{
                        |  "correlationId": "{correlationId}",
                        |  "result": {
                        |    "dateOfBirth": "1969-06-30",
                        |    "facialImage": "string",
                        |    "fullName": "Roos Tewes",
                        |    "statuses": [
                        |      {
                        |        "immigrationStatus": "ILR",
                        |        "rightToPublicFunds": true,
                        |        "statusStartDate": "2015-09-18"
                        |      }
                        |    ]
                        |  }
                        |}""".stripMargin,
      "KA339738D"  -> s"""{
                        |  "correlationId": "{correlationId}",
                        |  "result": {
                        |    "dateOfBirth": "1974-02-27",
                        |    "facialImage": "string",
                        |    "fullName": "Stefano Reese",
                        |    "statuses": [
                        |      {
                        |        "immigrationStatus": "ETLR",
                        |        "rightToPublicFunds": true,
                        |        "statusEndDate": "2016-02-08",
                        |        "statusStartDate": "2023-03-27"
                        |      }
                        |    ]
                        |  }
                        |}""".stripMargin,
      "AB576139C"  -> s"""{
                        |  "correlationId": "{correlationId}",
                        |  "result": {
                        |    "dateOfBirth": "1983-08-10",
                        |    "facialImage": "string",
                        |    "fullName": "Marni Dunkley",
                        |    "statuses": [
                        |      {
                        |        "immigrationStatus": "NONE",
                        |        "rightToPublicFunds": false
                        |      }
                        |    ]
                        |  }
                        |}""".stripMargin,
      "AB807993C"  -> s"""{
                        |  "correlationId": "{correlationId}",
                        |  "result": {
                        |    "dateOfBirth": "1983-08-26",
                        |    "facialImage": "string",
                        |    "fullName": "Wolfgang Traube",
                        |    "statuses": [
                        |      {
                        |        "immigrationStatus": "LTR",
                        |        "rightToPublicFunds": true,
                        |        "statusEndDate": "2016-06-20",
                        |        "statusStartDate": "2027-06-24"
                        |      }
                        |    ]
                        |  }
                        |}""".stripMargin,
      "AB445870B"  -> s"""{
                        |  "correlationId": "{correlationId}",
                        |  "result": {
                        |    "dateOfBirth": "1987-04-08",
                        |    "facialImage": "string",
                        |    "fullName": "Rosalie Gallegos",
                        |    "statuses": [
                        |      {
                        |        "immigrationStatus": "ETLR",
                        |        "rightToPublicFunds": true,
                        |        "statusEndDate": "2016-11-08",
                        |        "statusStartDate": "2030-06-17"
                        |      }
                        |    ]
                        |  }
                        |}""".stripMargin,
      "GT948987A"  -> s"""{
                        |  "correlationId": "{correlationId}",
                        |  "result": {
                        |    "dateOfBirth": "1987-09-23",
                        |    "facialImage": "string",
                        |    "fullName": "Aleksandrov Cherganski",
                        |    "statuses": [
                        |      {
                        |        "immigrationStatus": "NONE",
                        |        "rightToPublicFunds": true
                        |      }
                        |    ]
                        |  }
                        |}""".stripMargin,
      "BS088353B"  -> s"""{
                        |  "correlationId": "{correlationId}",
                        |  "result": {
                        |    "dateOfBirth": "2000-10-06",
                        |    "facialImage": "string",
                        |    "fullName": "Maja Glowa",
                        |    "statuses": [
                        |      {
                        |        "immigrationStatus": "ILR",
                        |        "rightToPublicFunds": true,
                        |        "statusStartDate": "2018-06-28"
                        |      }
                        |    ]
                        |  }
                        |}""".stripMargin
    )

}
