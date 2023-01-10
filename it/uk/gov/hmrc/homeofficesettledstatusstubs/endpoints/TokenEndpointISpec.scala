/*
 * Copyright 2023 HM Revenue & Customs
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

package uk.gov.hmrc.homeofficesettledstatusstubs.endpoints

import org.scalatest.Suite
import org.scalatestplus.play.ServerProvider
import play.api.http.Status._
import play.api.libs.json.JsObject
import play.api.libs.ws.{WSClient, WSResponse}
import uk.gov.hmrc.homeofficesettledstatusstubs.support.{JsonMatchers, ServerBaseISpec}

import java.net.URLEncoder

class TokenEndpointISpec extends ServerBaseISpec with JsonMatchers {
  this: Suite with ServerProvider =>

  val url = s"http://localhost:$port"

  lazy val wsClient: WSClient = app.injector.instanceOf[WSClient]

  def ping: WSResponse = wsClient.url(s"$url/ping/ping").get().futureValue

  def token(grantType: String, clientId: String, clientSecret: String): WSResponse = {
    val body =
      Seq("grant_type" -> grantType, "client_id" -> clientId, "client_secret" -> clientSecret)
        .map { case (k, v) => s"$k=${URLEncoder.encode(v, "utf-8")}" }
        .mkString("&")
    wsClient
      .url(s"$url/v1/status/public-funds/token")
      .addHttpHeaders("Content-Type" -> "application/x-www-form-urlencoded")
      .post[String](body)
      .futureValue
  }

  "POST /v1/status/public-funds/token" should {

    "respond with 200 and return a token when valid request" in {
      ping.status.shouldBe(OK)

      val result = token("client_credentials", "hmrc", "TBC")

      result.status          shouldBe OK
      result.json.as[JsObject] should (haveProperty[String]("access_token")
        and haveProperty[String]("refresh_token")
        and haveProperty[String]("token_type", be("Bearer")))
    }

    "respond with 400 when invalid request" in {
      ping.status.shouldBe(OK)

      val result = token("client_credentials", "invalid", "TBC")

      result.status shouldBe BAD_REQUEST
    }
  }

}
