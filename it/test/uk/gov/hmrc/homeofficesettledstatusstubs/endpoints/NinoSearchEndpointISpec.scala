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

package uk.gov.hmrc.homeofficesettledstatusstubs.endpoints

import org.scalatest.Suite
import org.scalatestplus.play.ServerProvider
import play.api.http.Status._
import play.api.libs.json.{JsObject, Json}
import play.api.libs.ws.{WSClient, WSResponse}
import uk.gov.hmrc.homeofficesettledstatusstubs.stubdata.DemoStubData
import uk.gov.hmrc.homeofficesettledstatusstubs.support.{JsonMatchers, ServerBaseISpec}

class NinoSearchEndpointISpec extends ServerBaseISpec with JsonMatchers {
  this: Suite with ServerProvider =>

  val url = s"http://localhost:$port"

  lazy val wsClient: WSClient = app.injector.instanceOf[WSClient]

  val NINO_VALID             = "HT423277B"
  val NINO_VALID_BUT_UNKNOWN = "AB123123B"

  def ping: WSResponse = wsClient.url(s"$url/ping/ping").get().futureValue

  def callEndpoint(payload: String): WSResponse =
    wsClient
      .url(s"$url/v1/status/public-funds/nino")
      .addHttpHeaders("Content-Type" -> "application/json")
      .post(payload)
      .futureValue

  val statusRange = """"statusCheckRange" : {"startDate": "2009-01-01", "endDate": "2009-01-02"}"""

  "POST /v1/status/public-funds/nino" should {

    "respond with 200 if request is valid" in {
      ping.status.shouldBe(OK)

      val result = callEndpoint(
        s"""{"nino":"$NINO_VALID","givenName":"Lawrence","familyName":"Velazques","dateOfBirth":"1954-10-04", $statusRange}"""
      )

      result.status                                  shouldBe OK
      (result.json.as[JsObject] \ "result").toOption shouldBe Some(Json.toJson(DemoStubData.lawrenceVelazquez))
    }

    "respond with 200 if request is valid, and date contains a pattern, and nino has no suffix" in {
      ping.status.shouldBe(OK)

      val result = callEndpoint(
        s"""{"nino":"BR253184", "givenName":"Njeri", "familyName":"Samara", "dateOfBirth":"1973-XX-16", $statusRange}"""
      )

      result.status                             shouldBe OK
      (result.json.as[JsObject] \ "result").get shouldBe Json.toJson(DemoStubData.njeriSamara)
    }

    "respond with 404 if the service failed to find an identity because of nino" in {
      ping.status.shouldBe(OK)

      val result = callEndpoint(
        s"""{"nino":"$NINO_VALID_BUT_UNKNOWN","givenName":"Lawrence","familyName":"Velazques","dateOfBirth":"1954-10-04", $statusRange}"""
      )

      result.status          shouldBe NOT_FOUND
      result.json.as[JsObject] should (haveProperty[String]("correlationId")
        and haveProperty[JsObject](
          "error",
          haveProperty[String]("errCode", be("ERR_NOT_FOUND"))
        ))
    }

    "respond with 404 if the service failed to find an identity because of a given name" in {
      ping.status.shouldBe(OK)

      val result = callEndpoint(
        s"""{"nino":"$NINO_VALID","givenName":"Bawrence","familyName":"Velazques","dateOfBirth":"1954-10-04", $statusRange}"""
      )

      result.status          shouldBe NOT_FOUND
      result.json.as[JsObject] should (haveProperty[String]("correlationId")
        and haveProperty[JsObject](
          "error",
          haveProperty[String]("errCode", be("ERR_NOT_FOUND"))
        ))
    }

    "respond with 400 if one of the required input parameters is missing from the request" in {
      ping.status.shouldBe(OK)

      val result =
        callEndpoint(s"""{"nino":"$NINO_VALID","givenName":"Lawrence","familyName":"Velazques", $statusRange}""")

      result.status          shouldBe BAD_REQUEST
      result.json.as[JsObject] should (haveProperty[String]("correlationId")
        and haveProperty[JsObject](
          "error",
          haveProperty[String]("errCode", be("ERR_VALIDATION"))
        ))
    }

    "respond with 400 if one of the input parameters passed in has failed validation" in {
      ping.status.shouldBe(OK)

      val result = callEndpoint(
        s"""{"nino":"invalid","givenName":"Lawrence","familyName":"Velazques","dateOfBirth":"1954-10-04", $statusRange}"""
      )

      result.status          shouldBe BAD_REQUEST
      result.json.as[JsObject] should (haveProperty[String]("correlationId")
        and haveProperty[JsObject](
          "error",
          haveProperty[String]("errCode", be("ERR_VALIDATION"))
            and havePropertyArrayOf[JsObject](
              "fields",
              haveProperty[String]("name", be("nino"))
                and haveProperty[String]("code", be("ERR_INVALID_NINO"))
            )
        ))
    }

    "respond with 200 if statuses empty" in {
      ping.status.shouldBe(OK)

      val result = callEndpoint(
        s"""{"nino":"ZL341566D","givenName":"N","familyName":"Sabina","dateOfBirth":"1956-10-09", $statusRange}"""
      )

      result.status shouldBe OK
    }

    "respond with 429 if status is 429" in {
      ping.status.shouldBe(OK)

      val result = callEndpoint(
        s"""{"nino":"TP991941C","givenName":"J","familyName":"Does","dateOfBirth":"2001-XX-31", $statusRange}"""
      )

      result.status shouldBe TOO_MANY_REQUESTS
    }

    "respond with 409 if status is 409" in {
      ping.status.shouldBe(OK)

      val result = callEndpoint(
        s"""{"nino":"HK089820A","givenName":"J","familyName":"Does","dateOfBirth":"2001-XX-31", $statusRange}"""
      )

      result.status shouldBe CONFLICT
    }

    "respond with 500 if status is 500" in {
      ping.status.shouldBe(OK)

      val result = callEndpoint(
        s"""{"nino":"BY880209A","givenName":"J","familyName":"Does","dateOfBirth":"2001-XX-31", $statusRange}"""
      )

      result.status shouldBe INTERNAL_SERVER_ERROR
    }
  }

}
