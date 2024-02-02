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

class MrzSearchEndpointISpec extends IntegrationBaseSpec {

  def request(): WSRequest                                                                =
    buildRequest("/v1/status/public-funds/mrz")
      .withHttpHeaders("Content-Type" -> "application/json")

  def payload(documentType: String, documentNumber: String, nationality: String): JsValue = Json.parse(
    s"""
       |{
       |    "documentType": "$documentType",
       |    "documentNumber": "$documentNumber",
       |    "dateOfBirth": "1954-10-04",
       |    "nationality": "$nationality",
       |    "statusCheckRange": {
       |        "startDate": "2009-01-01",
       |        "endDate": "2009-01-02"
       |    }
       |}
    """.stripMargin
  )

  "POST /v1/status/public-funds/mrz" should {
    "return 200 when a valid request is supplied" in {
      val requestBody: JsValue = payload("PASSPORT", "123456789", "CHE")

      val response: WSResponse = request().post(requestBody).futureValue

      response.status                shouldBe OK
      (response.json \ "result").get shouldBe Json.toJson(DemoStubData.lawrenceVelazquez)
    }

    "return 400 with an error response when an invalid request with missing required fields is supplied" in {
      val responseJson: JsValue = Json.parse(
        """
          |{
          |    "correlationId": "00000000",
          |    "status": 400,
          |    "error": {
          |        "errCode": "ERR_VALIDATION",
          |        "fields": [
          |            {
          |                "code": "ERR_MISSING_DOCUMENT_TYPE",
          |                "name": "documentType"
          |            },
          |            {
          |                "code": "ERR_MISSING_DOCUMENT_NUMBER",
          |                "name": "documentNumber"
          |            },
          |            {
          |                "code": "ERR_MISSING_DOB",
          |                "name": "dateOfBirth"
          |            },
          |            {
          |                "code": "ERR_MISSING_NATIONALITY",
          |                "name": "nationality"
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

    def test(
      documentType: String,
      documentNumber: String,
      nationality: String,
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

        val requestBody: JsValue = payload(documentType, documentNumber, nationality)

        val response: WSResponse = request().post(requestBody).futureValue

        response.status shouldBe errorStatus
        response.json   shouldBe errorResponseJson(errorStatus, errCode)
      }

    val input: Seq[(String, String, String, Int, String, Option[String])] = Seq(
      (
        "PASSPORT",
        "NOT VALID",
        "CHE",
        NOT_FOUND,
        "ERR_NOT_FOUND",
        Some("i.e. no match found for the supplied document number")
      ),
      (
        "PASSPORT",
        "123456789",
        "NOT VALID",
        NOT_FOUND,
        "ERR_NOT_FOUND",
        Some("i.e. no match found for the supplied nationality")
      ),
      ("NAT", "E8HDYKTB3", "CHE", CONFLICT, "ERR_CONFLICT", None),
      ("NAT", "E8HDYKTB4", "CHE", TOO_MANY_REQUESTS, "[NOT_USED]", None),
      ("NAT", "E8HDYKTB5", "CHE", INTERNAL_SERVER_ERROR, "[NOT_USED]", None)
    )

    input.foreach(args => (test _).tupled(args))
  }
}
