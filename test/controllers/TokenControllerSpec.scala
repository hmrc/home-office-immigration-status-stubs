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

import forms.TokenForm
import play.api.libs.json._
import play.api.mvc._
import play.api.test.FakeRequest
import play.api.test.Helpers._
import support.BaseSpec

import java.util.UUID
import scala.concurrent.Future

class TokenControllerSpec extends BaseSpec {

  private val form: TokenForm = new TokenForm()

  private val controller: TokenController = new TokenController(
    form = form,
    cc = stubControllerComponents()
  )

  private val validRequestJson: JsValue = Json.parse(
    """
      |{
      |    "grant_type": "client_credentials",
      |    "client_id": "hmrc",
      |    "client_secret": "TBC"
      |}
    """.stripMargin
  )

  private val invalidInputRequestJson: JsValue = Json.parse(
    """
      |{
      |    "grant_type": "grant",
      |    "client_id": "id",
      |    "client_secret": "TBC"
      |}
    """.stripMargin
  )

  val invalidInputErrorResponseJson: JsValue = Json.parse(
    """
      |{
      |    "grant_type": "Wrong grant type.",
      |    "client_id": "Unknown client_id."
      |}
    """.stripMargin
  )

  val emptyBodyErrorResponseJson: JsValue = Json.parse(
    """
      |{
      |    "grant_type": "error.required",
      |    "client_id": "error.required",
      |    "client_secret": "error.required"
      |}
    """.stripMargin
  )

  private def request(body: JsValue): FakeRequest[AnyContent] = FakeRequest().withJsonBody(body)

  "TokenController" when {
    "the request body is valid" should {
      "return 200 with a successful response" in {
        val result: Future[Result] = controller.token(request(validRequestJson))

        status(result)                                           shouldBe OK
        (contentAsJson(result) \ "access_token").validate[UUID]  shouldBe Symbol("success")
        (contentAsJson(result) \ "refresh_token").validate[UUID] shouldBe Symbol("success")
        (contentAsJson(result) \ "token_type").as[String]        shouldBe "Bearer"
      }
    }

    "the request body is invalid" should {
      def test(requestBody: JsValue, responseBody: JsValue, scenario: String): Unit =
        s"return 400 with an error response i.e. an $scenario" in {
          val result: Future[Result] = controller.token(request(requestBody))

          status(result)        shouldBe BAD_REQUEST
          contentAsJson(result) shouldBe responseBody
        }

      val input: Seq[(JsValue, JsValue, String)] = Seq(
        (JsObject.empty, emptyBodyErrorResponseJson, "empty body scenario"),
        (invalidInputRequestJson, invalidInputErrorResponseJson, "invalid input scenario")
      )

      input.foreach(args => (test _).tupled(args))
    }
  }
}
