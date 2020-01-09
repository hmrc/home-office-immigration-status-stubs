package gov.uk.hmrc.homeofficesettledstatusstubs.models

trait StatusResultExamples {

  val NINO_VALID_1 = "RJ301829A"
  val NINO_VALID_BUT_UNKNOWN = "MG199709D"

  val examples: Map[String, String] =
    Map(NINO_VALID_1 -> s"""{
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
                           |}""".stripMargin)

}
