package uk.gov.hmrc.homeofficesettledstatusstubs.controllers

import java.net.URLEncoder

import org.scalatest.Suite
import org.scalatestplus.play.ServerProvider
import play.api.libs.json.JsObject
import play.api.libs.ws.{WSClient, WSResponse}
import uk.gov.hmrc.homeofficesettledstatusstubs.models.StatusResultExamples
import uk.gov.hmrc.homeofficesettledstatusstubs.support.{JsonMatchers, ServerBaseISpec}

class HomeOfficeSettledStatusStubsControllerISpec
    extends ServerBaseISpec with JsonMatchers with StatusResultExamples {
  this: Suite with ServerProvider =>

  val url = s"http://localhost:$port"

  lazy val wsClient: WSClient = app.injector.instanceOf[WSClient]

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

  def publicFundsByNino(payload: String): WSResponse =
    wsClient
      .url(s"$url/v1/status/public-funds/nino")
      .addHttpHeaders("Content-Type" -> "application/json")
      .post(payload)
      .futureValue

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
          s"""{"nino":"$NINO_VALID","givenName":"John","familyName":"Does","dateOfBirth":"2001-01-31"}""")

        result.status shouldBe 200
        result.json.as[JsObject] should (haveProperty[String]("correlationId")
          and haveProperty[JsObject](
            "result",
            haveProperty[String]("dateOfBirth", be("2001-01-31"))
              and haveProperty[String]("nationality", be("IRL"))
              and haveProperty[String]("fullName", be("Jane Doe"))
              and havePropertyArrayOf[JsObject](
                "statuses",
                haveProperty[String]("immigrationStatus", be("ILR"))
                  and haveProperty[Boolean]("noRecourseToPublicFunds", be(true))
                  and haveProperty[String]("statusStartDate", be("2018-01-31"))
                  and haveProperty[String]("statusEndDate", be("2018-12-12"))
                  and haveProperty[String]("productType", be("EUS"))
              )
          ))
      }

      "respond with 200 if request is valid and has only first letter of the name, and date contains a pattern" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino(
          s"""{"nino":"$NINO_VALID","givenName":"J","familyName":"Does","dateOfBirth":"2001-XX-31"}""")

        result.status shouldBe 200
        result.json.as[JsObject] should (haveProperty[String]("correlationId")
          and haveProperty[JsObject](
            "result",
            haveProperty[String]("dateOfBirth", be("2001-01-31"))
              and haveProperty[String]("nationality", be("IRL"))
              and haveProperty[String]("fullName", be("Jane Doe"))
              and havePropertyArrayOf[JsObject](
                "statuses",
                haveProperty[String]("immigrationStatus", be("ILR"))
                  and haveProperty[Boolean]("noRecourseToPublicFunds", be(true))
                  and haveProperty[String]("statusStartDate", be("2018-01-31"))
                  and haveProperty[String]("statusEndDate", be("2018-12-12"))
                  and haveProperty[String]("productType", be("EUS"))
              )
          ))
      }

      "respond with 404 if the service failed to find an identity because of nino" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino(
          s"""{"nino":"$NINO_VALID_BUT_UNKNOWN","givenName":"Jane","familyName":"Doe","dateOfBirth":"2001-01-31"}""")

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
          s"""{"nino":"$NINO_VALID","givenName":"Dane","familyName":"Doe","dateOfBirth":"2001-01-31"}""")

        result.status shouldBe 404
        result.json.as[JsObject] should (haveProperty[String]("correlationId")
          and haveProperty[JsObject](
            "error",
            haveProperty[String]("errCode", be("ERR_NOT_FOUND"))
          ))
      }

      "respond with 400 if one of the required input parameters is missing from the request" in {
        ping.status.shouldBe(200)

        val result =
          publicFundsByNino(s"""{"nino":"$NINO_VALID","givenName":"Dane","familyName":"Doe"}""")

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
          """{"nino":"invalid","givenName":"Jane","familyName":"Doe","dateOfBirth":"2001-01-31"}""")

        result.status shouldBe 400
        result.json.as[JsObject] should (haveProperty[String]("correlationId")
          and haveProperty[JsObject](
            "error",
            haveProperty[String]("errCode", be("ERR_VALIDATION"))
              and havePropertyArrayOf[JsObject](
                "fields",
                haveProperty[String]("code", be("nino"))
                  and haveProperty[String]("name", be("ERR_INVALID_NINO"))
              )
          ))
      }
    }
  }
}
