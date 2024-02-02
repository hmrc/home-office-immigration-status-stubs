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

package endpoints

import play.api.http.Status._
import play.api.libs.json._
import play.api.libs.ws._
import stubData.DemoStubData
import support.IntegrationBaseSpec

class NinoSearchEndpointISpec extends IntegrationBaseSpec {

  def request(): WSRequest                                                                       =
    buildRequest("/v1/status/public-funds/nino")
      .withHttpHeaders("Content-Type" -> "application/json")

  def payload(nino: String, dateOfBirth: String, familyName: String, givenName: String): JsValue = Json.parse(
    s"""
       |{
       |    "nino": "$nino",
       |    "dateOfBirth": "$dateOfBirth",
       |    "familyName": "$familyName",
       |    "givenName": "$givenName",
       |    "statusCheckRange": {
       |        "startDate": "2009-01-01",
       |        "endDate": "2009-01-02"
       |    }
       |}
    """.stripMargin
  )

  "POST /v1/status/public-funds/nino" should {
    "return 200 when a valid request" which {
      def test(dob: String, scenario: String): Unit =
        s"has date of birth $scenario is supplied" in {
          val requestBody: JsValue = payload("CP822334A", dob, "Sultan", "Nabil")

          val response: WSResponse = request().post(requestBody).futureValue

          response.status                shouldBe OK
          (response.json \ "result").get shouldBe Json.toJson(DemoStubData.nabilSultan)
        }

      val input: Seq[(String, String)] = Seq(
        ("1988-04-01", "without wildcard"),
        ("1988-04-XX", "with wildcard")
      )

      input.foreach(args => (test _).tupled(args))
    }

    "return 400 with an error response when an invalid request" which {
      "has missing required fields is supplied" in {
        val responseJson: JsValue = Json.parse(
          """
            |{
            |    "correlationId": "00000000",
            |    "status": 400,
            |    "error": {
            |        "errCode": "ERR_VALIDATION",
            |        "fields": [
            |            {
            |                "code": "ERR_MISSING_NINO",
            |                "name": "nino"
            |            },
            |            {
            |                "code": "ERR_MISSING_DOB",
            |                "name": "dateOfBirth"
            |            },
            |            {
            |                "code": "ERR_MISSING_FAMILY_NAME",
            |                "name": "familyName"
            |            },
            |            {
            |                "code": "ERR_MISSING_GIVEN_NAME",
            |                "name": "givenName"
            |            },
            |            {
            |                "code": "ERR_MISSING_CHECK_STATUS_RANGE",
            |                "name": "statusCheckRange"
            |            }
            |        ]
            |    }
            |}
          """.stripMargin
        )

        val response: WSResponse = request().post(JsObject.empty).futureValue

        response.status shouldBe BAD_REQUEST
        response.json   shouldBe responseJson
      }

      "has an invalid nino is supplied" in {
        val responseJson: JsValue = Json.parse(
          """
            |{
            |    "correlationId": "00000000",
            |    "status": 400,
            |    "error": {
            |        "errCode": "ERR_VALIDATION",
            |        "fields": [
            |            {
            |                "code": "ERR_INVALID_NINO",
            |                "name": "nino"
            |            }
            |        ]
            |    }
            |}
          """.stripMargin
        )

        val requestBody: JsValue = payload("invalid", "1954-10-04", "Velazques", "Lawrence")

        val response: WSResponse = request().post(requestBody).futureValue

        response.status shouldBe BAD_REQUEST
        response.json   shouldBe responseJson
      }
    }

    def test(
      nino: String,
      dateOfBirth: String,
      familyName: String,
      givenName: String,
      errorStatus: Int,
      errCode: String,
      scenario: Option[String]
    ): Unit =
      s"return $errorStatus with an error response when the service returns $errorStatus ${scenario.getOrElse("")}" in {
        def errorResponseJson(status: Int, errCode: String): JsValue = Json.parse(
          s"""
             |{
             |    "correlationId": "00000000",
             |    "status": $status,
             |    "error": {
             |        "errCode": "$errCode",
             |        "fields": []
             |    }
             |}
          """.stripMargin
        )

        val requestBody: JsValue = payload(nino, dateOfBirth, familyName, givenName)

        val response: WSResponse = request().post(requestBody).futureValue

        response.status shouldBe errorStatus
        response.json   shouldBe errorResponseJson(errorStatus, errCode)
      }

    val input: Seq[(String, String, String, String, Int, String, Option[String])] = Seq(
      (
        "AB123123B",
        "1954-10-04",
        "Velazques",
        "Lawrence",
        NOT_FOUND,
        "ERR_NOT_FOUND",
        Some("i.e. no match found for the supplied nino")
      ),
      (
        "HT423277B",
        "1954-10-04",
        "Velazques",
        "Bawrence",
        NOT_FOUND,
        "ERR_NOT_FOUND",
        Some("i.e. no match found for the supplied given name")
      ),
      ("HK089820A", "2001-XX-31", "Does", "J", CONFLICT, "ERR_CONFLICT", None),
      ("TP991941C", "2001-XX-31", "Does", "J", TOO_MANY_REQUESTS, "[NOT_USED]", None),
      ("BY880209A", "2001-XX-31", "Does", "J", INTERNAL_SERVER_ERROR, "[NOT_USED]", None)
    )

    input.foreach(args => (test _).tupled(args))
  }
}
