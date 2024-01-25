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

class MrzSearchEndpointISpec extends ServerBaseISpec with JsonMatchers {
  this: Suite with ServerProvider =>

  val url = s"http://localhost:$port"

  lazy val wsClient: WSClient = app.injector.instanceOf[WSClient]

  def ping: WSResponse = wsClient.url(s"$url/ping/ping").get().futureValue

  def publicFundsByMRZ(payload: String): WSResponse =
    wsClient
      .url(s"$url/v1/status/public-funds/mrz")
      .addHttpHeaders("Content-Type" -> "application/json")
      .post(payload)
      .futureValue

  val statusRange = """"statusCheckRange" : {"startDate": "2009-01-01", "endDate": "2009-01-02"}"""

  "POST /v1/status/public-funds/mrz" should {

    "respond with 200 if request is valid" in {
      ping.status.shouldBe(OK)

      val result = publicFundsByMRZ(
        s"""{"documentType":"PASSPORT", "documentNumber" : "123456789", "nationality": "CHE", "dateOfBirth":"1954-10-04", $statusRange}"""
      )

      (result.json.as[JsObject] \ "result").get shouldBe Json.toJson(DemoStubData.lawrenceVelazquez)

    }

    "respond with 404 if the service failed to find an identity because of incorrect number" in {
      ping.status.shouldBe(OK)

      val result = publicFundsByMRZ(
        s"""{"documentType":"PASSPORT", "documentNumber" : "NOT VALID", "nationality": "CHE","dateOfBirth":"1954-10-04", $statusRange}"""
      )

      result.status          shouldBe NOT_FOUND
      result.json.as[JsObject] should (haveProperty[String]("correlationId")
        and haveProperty[JsObject](
          "error",
          haveProperty[String]("errCode", be("ERR_NOT_FOUND"))
        ))
    }

    "respond with 404 if the service failed to find an identity because of a nationality" in {
      ping.status.shouldBe(OK)

      val result = publicFundsByMRZ(
        s"""{"documentType":"PASSPORT", "documentNumber" : "NOT VALID", "nationality": "INVALID","dateOfBirth":"1954-10-04", $statusRange}"""
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

      val result = publicFundsByMRZ(
        s"""{"documentNumber" : "NOT VALID", "nationality": "INVALID","dateOfBirth":"1954-10-04", $statusRange}"""
      )

      result.status          shouldBe BAD_REQUEST
      result.json.as[JsObject] should (haveProperty[String]("correlationId")
        and haveProperty[JsObject](
          "error",
          haveProperty[String]("errCode", be("ERR_VALIDATION"))
        ))
    }

    "respond with 200 if statuses empty" in {
      val result = publicFundsByMRZ(
        s"""{"documentType":"NAT", "documentNumber" : "ZL341566", "nationality": "ESP", "dateOfBirth":"1956-10-09", $statusRange}"""
      )

      result.status shouldBe OK
    }

    "respond with 409 if status is 409" in {
      val result = publicFundsByMRZ(
        s"""{"documentType":"NAT", "documentNumber" : "E8HDYKTB3", "nationality": "x", "dateOfBirth":"1956-10-09", $statusRange}"""
      )

      result.status shouldBe CONFLICT
    }

    "respond with 429 if status is 429" in {
      val result = publicFundsByMRZ(
        s"""{"documentType":"NAT", "documentNumber" : "E8HDYKTB4", "nationality": "x", "dateOfBirth":"1956-10-09", $statusRange}"""
      )

      result.status shouldBe TOO_MANY_REQUESTS
    }

    "respond with 500 if status is 500" in {
      val result = publicFundsByMRZ(
        s"""{"documentType":"NAT", "documentNumber" : "E8HDYKTB5", "nationality": "x", "dateOfBirth":"1956-10-09", $statusRange}"""
      )

      result.status shouldBe INTERNAL_SERVER_ERROR
    }
  }

}
