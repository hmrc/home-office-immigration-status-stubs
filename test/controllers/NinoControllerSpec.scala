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

package controllers

import forms.NinoSearchForm
import play.api.libs.json._
import play.api.mvc.Result
import play.api.test.FakeRequest
import play.api.test.Helpers._
import support.BaseSpec

import scala.concurrent.Future

class NinoControllerSpec extends BaseSpec {

  private val form: NinoSearchForm = new NinoSearchForm()

  private val controller: NinoController = new NinoController(
    form = form,
    stubDataService = stubDataService,
    jsonHeaders = jsonHeadersAction,
    cc = stubControllerComponents()
  )

  private def validRequestJson(nino: String = "AB445870B"): JsValue = Json.parse(
    s"""
       |{
       |    "nino": "$nino",
       |    "dateOfBirth": "1987-04-08",
       |    "familyName": "Gallegos",
       |    "givenName": "Rosalie",
       |    "statusCheckRange": {
       |        "startDate": "2021-08-20",
       |        "endDate": "2023-04-27"
       |    }
       |}
    """.stripMargin
  )

  private val invalidRequestJson: JsValue = Json.parse(
    """
      |{
      |    "nino": "NINO",
      |    "dateOfBirth": "1987-04-08",
      |    "statusCheckRange": {
      |        "startDate": "2021-08-20",
      |        "endDate": "2023-04-27"
      |    }
      |}
    """.stripMargin
  )

  private val successResponseJson: JsValue = Json.parse(
    """
      |{
      |    "correlationId": "00000000",
      |    "result": {
      |        "fullName": "Rosalie Gallegos",
      |        "dateOfBirth": "1987-04-08",
      |        "nationality": "ESP",
      |        "statuses": [
      |            {
      |                "statusStartDate": "2021-08-01",
      |                "productType": "EUS",
      |                "immigrationStatus": "POST_GRACE_PERIOD_COA_GRANT",
      |                "noRecourseToPublicFunds": true
      |            },
      |            {
      |                "statusStartDate": "2021-03-26",
      |                "statusEndDate": "2021-07-31",
      |                "productType": "EUS",
      |                "immigrationStatus": "LTR",
      |                "noRecourseToPublicFunds": false
      |            }
      |        ]
      |    }
      |}
    """.stripMargin
  )

  private def errorResponseJson(status: Int, errCode: String): JsValue = Json.parse(
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

  private def request(body: JsValue): FakeRequest[JsValue] =
    FakeRequest().withBody(body).withHeaders(("Content-Type", "application/json"))

  "NinoController" when {
    "the request body is valid" should {
      "return 200 with a successful response when the service returns no errors" in {
        val result: Future[Result] = controller.publicFundsByNino(request(validRequestJson()))

        status(result)        shouldBe OK
        contentAsJson(result) shouldBe successResponseJson
      }

      def test(nino: String, errorStatus: Int, errCode: String): Unit =
        s"return $errorStatus with an error response when the service returns $errorStatus" in {
          val result: Future[Result] = controller.publicFundsByNino(request(validRequestJson(nino)))

          status(result)        shouldBe errorStatus
          contentAsJson(result) shouldBe errorResponseJson(errorStatus, errCode)
        }

      val input: Seq[(String, Int, String)] = Seq(
        ("AB445870C", NOT_FOUND, "ERR_NOT_FOUND"),
        ("HK089820A", CONFLICT, "ERR_CONFLICT"),
        ("TP991941C", TOO_MANY_REQUESTS, "[NOT_USED]"),
        ("BY880209A", INTERNAL_SERVER_ERROR, "[NOT_USED]")
      )

      input.foreach(args => (test _).tupled(args))
    }

    "the request body is invalid" should {
      "return 400 with an error response" in {
        val errorResponseJson: JsValue = Json.parse(
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
            |            },
            |            {
            |                "code": "ERR_MISSING_FAMILY_NAME",
            |                "name": "familyName"
            |            },
            |            {
            |                "code": "ERR_MISSING_GIVEN_NAME",
            |                "name": "givenName"
            |            }
            |        ]
            |    }
            |}
          """.stripMargin
        )

        val result: Future[Result] = controller.publicFundsByNino(request(invalidRequestJson))

        status(result)        shouldBe BAD_REQUEST
        contentAsJson(result) shouldBe errorResponseJson
      }
    }
  }
}
