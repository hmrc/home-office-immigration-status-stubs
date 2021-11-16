package uk.gov.hmrc.homeofficesettledstatusstubs.controllers

import java.net.URLEncoder
import org.scalatest.Suite
import org.scalatestplus.play.ServerProvider
import play.api.libs.json.{JsLookupResult, JsObject, Json}
import play.api.libs.ws.{WSClient, WSResponse}
import uk.gov.hmrc.homeofficesettledstatusstubs.support.{JsonMatchers, ServerBaseISpec}
import uk.gov.hmrc.homeofficesettledstatusstubs.stubdata.DemoStubData
import uk.gov.hmrc.homeofficesettledstatusstubs.stubdata.TestStubData.nevioSabina

class HomeOfficeSettledStatusStubsControllerISpec
    extends ServerBaseISpec with JsonMatchers {
  this: Suite with ServerProvider =>

  val url = s"http://localhost:$port"

  lazy val wsClient: WSClient = app.injector.instanceOf[WSClient]

  val NINO_VALID = "HT423277B"
  val NINO_VALID_BUT_UNKNOWN = "AB123123B"

  def ping: WSResponse = wsClient.url(s"$url/ping/ping").get.futureValue

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

  //todo seperate the endpoints to seperate specs
  def publicFundsByNino(payload: String): WSResponse =
    wsClient
      .url(s"$url/v1/status/public-funds/nino")
      .addHttpHeaders("Content-Type" -> "application/json")
      .post(payload)
      .futureValue

  def publicFundsByMRZ(payload: String): WSResponse =
    wsClient
      .url(s"$url/v1/status/public-funds/mrz")
      .addHttpHeaders("Content-Type" -> "application/json")
      .post(payload)
      .futureValue

  val statusRange = """"statusCheckRange" : {"startDate": "2009-01-01", "endDate": "2009-01-02"}"""

  "HomeOfficeSettledStatusStubsController" when {

    "POST /v1/status/public-funds/token" should {

      "respond with 200 and return a token when valid request" in {
        ping.status.shouldBe(200)

        val result = token("client_credentials", "hmrc", "TBC")

        result.status shouldBe 200
        result.json.as[JsObject] should (haveProperty[String]("access_token")
          and haveProperty[String]("refresh_token")
          and haveProperty[String]("token_type", be("Bearer")))
      }

      "respond with 400 when invalid request" in {
        ping.status.shouldBe(200)

        val result = token("client_credentials", "invalid", "TBC")

        result.status shouldBe 400
      }
    }

    "POST /v1/status/public-funds/nino" should {

      "respond with 200 if request is valid" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino(
          s"""{"nino":"$NINO_VALID","givenName":"Lawrence","familyName":"Velazques","dateOfBirth":"1954-10-04", $statusRange}""")

        result.status shouldBe 200
         (result.json.as[JsObject] \ "result").toOption shouldBe Some(Json.toJson(DemoStubData.lawrenceVelazquez))
      }

      "respond with 200 if request is valid, and date contains a pattern, and nino has no suffix" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino(
          s"""{"nino":"BR253184", "givenName":"Njeri", "familyName":"Samara", "dateOfBirth":"1973-XX-16", $statusRange}""")

        result.status shouldBe 200
        (result.json.as[JsObject] \ "result").get shouldBe Json.toJson(DemoStubData.njeriSamara)
      }

      "respond with 404 if the service failed to find an identity because of nino" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino(
          s"""{"nino":"$NINO_VALID_BUT_UNKNOWN","givenName":"Lawrence","familyName":"Velazques","dateOfBirth":"1954-10-04", $statusRange}""")

        result.status shouldBe 404
        result.json.as[JsObject] should (haveProperty[String]("correlationId")
          and haveProperty[JsObject](
            "error",
            haveProperty[String]("errCode", be("ERR_NOT_FOUND"))
          ))
      }

      "respond with 404 if the service failed to find an identity because of a given name" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino(
          s"""{"nino":"$NINO_VALID","givenName":"Bawrence","familyName":"Velazques","dateOfBirth":"1954-10-04", $statusRange}""")

        result.status shouldBe 404
        result.json.as[JsObject] should (haveProperty[String]("correlationId")
          and haveProperty[JsObject](
            "error",
            haveProperty[String]("errCode", be("ERR_NOT_FOUND"))
          ))
      }

      "respond with 400 if one of the required input parameters is missing from the request" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino(
          s"""{"nino":"$NINO_VALID","givenName":"Lawrence","familyName":"Velazques", $statusRange}""")

        result.status shouldBe 400
        result.json.as[JsObject] should (haveProperty[String]("correlationId")
          and haveProperty[JsObject](
            "error",
            haveProperty[String]("errCode", be("ERR_VALIDATION"))
          ))
      }

      "respond with 400 if one of the input parameters passed in has failed validation" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino(
          s"""{"nino":"invalid","givenName":"Lawrence","familyName":"Velazques","dateOfBirth":"1954-10-04", $statusRange}""")

        result.status shouldBe 400
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
        ping.status.shouldBe(200)

        val result = publicFundsByNino(
          s"""{"nino":"ZL341566D","givenName":"N","familyName":"Sabina","dateOfBirth":"1956-10-09", $statusRange}""")

        result.status shouldBe 200
      }

      "respond with 429 if status is 429" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino(
          s"""{"nino":"TP991941C","givenName":"J","familyName":"Does","dateOfBirth":"2001-XX-31", $statusRange}""")

        result.status shouldBe 429
      }

      "respond with 409 if status is 409" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino(
          s"""{"nino":"HK089820A","givenName":"J","familyName":"Does","dateOfBirth":"2001-XX-31", $statusRange}""")

        result.status shouldBe 409
      }

      "respond with 500 if status is 500" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino(
          s"""{"nino":"BY880209A","givenName":"J","familyName":"Does","dateOfBirth":"2001-XX-31", $statusRange}""")

        result.status shouldBe 500
      }
    }

    "POST /v1/status/public-funds/mrz" should {

      "respond with 200 if request is valid" in {
        ping.status.shouldBe(200)

        val result = publicFundsByMRZ(
          s"""{"documentType":"PASSPORT", "documentNumber" : "123456789", "nationality": "CHE", "dateOfBirth":"1954-10-04", $statusRange}""")

        (result.json.as[JsObject] \ "result").get shouldBe Json.toJson(DemoStubData.lawrenceVelazquez)

      }

      "respond with 404 if the service failed to find an identity because of incorrect number" in {
        ping.status.shouldBe(200)

        val result = publicFundsByMRZ(
          s"""{"documentType":"PASSPORT", "documentNumber" : "NOT VALID", "nationality": "CHE","dateOfBirth":"1954-10-04", $statusRange}""")

        result.status shouldBe 404
        result.json.as[JsObject] should (haveProperty[String]("correlationId")
          and haveProperty[JsObject](
          "error",
          haveProperty[String]("errCode", be("ERR_NOT_FOUND"))
        ))
      }

      "respond with 404 if the service failed to find an identity because of a nationality" in {
        ping.status.shouldBe(200)

        val result = publicFundsByMRZ(
          s"""{"documentType":"PASSPORT", "documentNumber" : "NOT VALID", "nationality": "INVALID","dateOfBirth":"1954-10-04", $statusRange}""")


        result.status shouldBe 404
        result.json.as[JsObject] should (haveProperty[String]("correlationId")
          and haveProperty[JsObject](
          "error",
          haveProperty[String]("errCode", be("ERR_NOT_FOUND"))
        ))
      }

      "respond with 400 if one of the required input parameters is missing from the request" in {
        ping.status.shouldBe(200)

        val result = publicFundsByMRZ(
          s"""{"documentNumber" : "NOT VALID", "nationality": "INVALID","dateOfBirth":"1954-10-04", $statusRange}""")


        result.status shouldBe 400
        result.json.as[JsObject] should (haveProperty[String]("correlationId")
          and haveProperty[JsObject](
          "error",
          haveProperty[String]("errCode", be("ERR_VALIDATION"))
        ))
      }


      "respond with 200 if statuses empty" in {
        val result = publicFundsByMRZ(
          s"""{"documentType":"NAT", "documentNumber" : "ZL341566", "nationality": "ESP", "dateOfBirth":"1956-10-09", $statusRange}""")

        result.status shouldBe 200
      }

      "respond with 409 if status is 409" in {
        val result = publicFundsByMRZ(
          s"""{"documentType":"NAT", "documentNumber" : "E8HDYKTB3", "nationality": "x", "dateOfBirth":"1956-10-09", $statusRange}"""
        )

        result.status shouldBe 409
      }

      "respond with 429 if status is 429" in {
        val result = publicFundsByMRZ(
          s"""{"documentType":"NAT", "documentNumber" : "E8HDYKTB4", "nationality": "x", "dateOfBirth":"1956-10-09", $statusRange}""")

        result.status shouldBe 429
      }

      "respond with 500 if status is 500" in {
        val result = publicFundsByMRZ(
          s"""{"documentType":"NAT", "documentNumber" : "E8HDYKTB5", "nationality": "x", "dateOfBirth":"1956-10-09", $statusRange}""")

        result.status shouldBe 500
      }
    }

  }
}
