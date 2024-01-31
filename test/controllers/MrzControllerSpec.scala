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

import forms.MrzSearchForm
import play.api.libs.json._
import play.api.mvc.Result
import play.api.test.FakeRequest
import play.api.test.Helpers._
import support.BaseSpec

import scala.concurrent.Future

class MrzControllerSpec extends BaseSpec {

  private val form: MrzSearchForm = new MrzSearchForm()

  private val controller: MrzController = new MrzController(
    form = form,
    stubDataService = stubDataService,
    jsonHeaders = jsonHeadersAction,
    cc = stubControllerComponents()
  )

  private def validRequestJson(documentNumber: String): JsValue = Json.parse(
    s"""
      |{
      |    "documentType": "NAT",
      |    "documentNumber": "$documentNumber",
      |    "dateOfBirth": "2000-01-01",
      |    "nationality": "AFG",
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
      |    "documentType": "PASSPORT",
      |    "dateOfBirth": "2000-01-01",
      |    "statusCheckRange": {
      |        "startDate": "2021-08-20",
      |        "endDate": "2023-04-27"
      |    }
      |}
    """.stripMargin
  )

  private def successResponseJson(statusEndDate: String): JsValue = Json.parse(
    s"""
      |{
      |    "correlationId": "00000000",
      |    "result": {
      |        "fullName": "Michael Makson",
      |        "dateOfBirth": "2000-01-01",
      |        "nationality": "AFG",
      |        "statuses": [
      |            {
      |                "statusStartDate": "$twoDaysAgo",
      |                "statusEndDate": "$statusEndDate",
      |                "productType": "ARMED_FORCES",
      |                "immigrationStatus": "ILR",
      |                "noRecourseToPublicFunds": false
      |            },
      |            {
      |                "statusStartDate": "$tenDaysAgo",
      |                "statusEndDate": "$nineDaysAgo",
      |                "productType": "ARMED_FORCES",
      |                "immigrationStatus": "ILR",
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

  "MrzController" when {
    "the request body is valid" should {
      def successTest(documentNumber: String, statusEndDate: String): Unit =
        s"return 200 with a successful response when documentNumber is $documentNumber and the service returns no errors" in {
          val result: Future[Result] = controller.getImmigrationStatus(request(validRequestJson(documentNumber)))

          status(result)        shouldBe OK
          contentAsJson(result) shouldBe successResponseJson(statusEndDate)
        }

      val successTestInput: Seq[(String, String)] = Seq(
        ("MAKE-ARMED--FORCES-ILR", tomorrow),
        ("MAKE-ARMED--FORCES-ILR-EX", yesterday)
      )

      successTestInput.foreach(args => (successTest _).tupled(args))

      def errorTest(documentNumber: String, errorStatus: Int, errCode: String): Unit =
        s"return $errorStatus with an error response when the service returns $errorStatus" in {
          val result: Future[Result] = controller.getImmigrationStatus(request(validRequestJson(documentNumber)))

          status(result)        shouldBe errorStatus
          contentAsJson(result) shouldBe errorResponseJson(errorStatus, errCode)
        }

      val errorTestInput: Seq[(String, Int, String)] = Seq(
        ("DOC_NUMBER", NOT_FOUND, "ERR_NOT_FOUND"),
        ("E8HDYKTB3", CONFLICT, "ERR_CONFLICT"),
        ("E8HDYKTB4", TOO_MANY_REQUESTS, "[NOT_USED]"),
        ("E8HDYKTB5", INTERNAL_SERVER_ERROR, "[NOT_USED]")
      )

      errorTestInput.foreach(args => (errorTest _).tupled(args))
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
            |                "code": "ERR_MISSING_DOCUMENT_NUMBER",
            |                "name": "documentNumber"
            |            },
            |            {
            |                "code": "ERR_MISSING_NATIONALITY",
            |                "name": "nationality"
            |            }
            |        ]
            |    }
            |}
          """.stripMargin
        )

        val result: Future[Result] = controller.getImmigrationStatus(request(invalidRequestJson))

        status(result)        shouldBe BAD_REQUEST
        contentAsJson(result) shouldBe errorResponseJson
      }
    }
  }
}
