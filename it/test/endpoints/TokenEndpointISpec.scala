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
import support.IntegrationBaseSpec

import java.util.UUID

class TokenEndpointISpec extends IntegrationBaseSpec {

  def payload(grantType: String, clientId: String, clientSecret: String): String =
    s"grant_type=$grantType&client_id=$clientId&client_secret=$clientSecret"

  def request(): WSRequest =
    buildRequest("/v1/status/public-funds/token")
      .withHttpHeaders("Content-Type" -> "application/x-www-form-urlencoded")

  "POST /v1/status/public-funds/token" should {
    "return 200 and a token in response when a valid request is supplied" in {
      val requestBody: String = payload("client_credentials", "hmrc", "TBC")

      val response: WSResponse = request().post(requestBody).futureValue

      response.status                                  shouldBe OK
      (response.json \ "access_token").validate[UUID]  shouldBe Symbol("success")
      (response.json \ "refresh_token").validate[UUID] shouldBe Symbol("success")
      (response.json \ "token_type").as[String]        shouldBe "Bearer"
    }

    "return 400 with an error response when an invalid request" which {
      "has incorrect grant type and client ID is supplied" in {
        val responseJson: JsValue = Json.parse(
          """
            |{
            |    "grant_type": "Wrong grant type.",
            |    "client_id": "Unknown client_id."
            |}
          """.stripMargin
        )

        val requestBody: String = payload("invalid", "invalid", "TBC")

        val response: WSResponse = request().post(requestBody).futureValue

        response.status shouldBe BAD_REQUEST
        response.json   shouldBe responseJson
      }
    }
  }
}
