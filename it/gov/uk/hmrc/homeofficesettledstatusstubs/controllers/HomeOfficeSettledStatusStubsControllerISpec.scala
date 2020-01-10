package gov.uk.hmrc.homeofficesettledstatusstubs.controllers

import java.net.URLEncoder

import gov.uk.hmrc.homeofficesettledstatusstubs.models.StatusResultExamples
import gov.uk.hmrc.homeofficesettledstatusstubs.support.{JsonMatchers, ServerBaseISpec}
import org.scalatest.Suite
import org.scalatestplus.play.ServerProvider
import play.api.libs.json.JsObject
import play.api.libs.ws.{WSClient, WSResponse}

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

      "respond with 200 and return a token" in {
        ping.status.shouldBe(200)

        val result = token("client_credentials", "hmrc", "TBC")

        result.status shouldBe 200
        result.json.as[JsObject] should (haveProperty[String]("access_token")
          and haveProperty[String]("refresh_token")
          and haveProperty[String]("id_token")
          and haveProperty[String]("token_type", be("Bearer")))
      }
    }

    "POST /v1/status/public-funds/nino" should {

      "respond with 200 if request is valid" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino(s"""{"nino":"$NINO_VALID_1"}""")

        result.status shouldBe 200
        result.json.as[JsObject] should (haveProperty[String]("correlationId")
          and haveProperty[JsObject](
            "result",
            haveProperty[String]("dateOfBirth", be("2001-01-31"))
              and haveProperty[String]("facialImage", be("string"))
              and haveProperty[String]("fullName", be("Jane Doe"))
              and havePropertyArrayOf[JsObject](
                "statuses",
                haveProperty[String]("immigrationStatus", be("ILR"))
                  and haveProperty[Boolean]("rightToPublicFunds", be(true))
                  and haveProperty[String]("statusEndDate", be("2018-01-31"))
                  and haveProperty[String]("statusStartDate", be("2018-12-12"))
              )
          ))
      }

      "respond with 404 if the service failed to find an identity based on the values provided" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino(s"""{"nino":"$NINO_VALID_BUT_UNKNOWN"}""")

        result.status shouldBe 404
        result.json.as[JsObject] should (haveProperty[String]("correlationId")
          and haveProperty[JsObject](
            "error",
            haveProperty[String]("errCode", be("ERR_NOT_FOUND"))
          ))
      }

      "respond with 400 if one of the required input parameters is missing from the request" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino("{}")

        result.status shouldBe 400
        result.json.as[JsObject] should (haveProperty[String]("correlationId")
          and haveProperty[JsObject](
            "error",
            haveProperty[String]("errCode", be("ERR_REQUEST_INVALID"))
          ))
      }

      "respond with 422 if one of the input parameters passed in has failed validation" in {
        ping.status.shouldBe(200)

        val result = publicFundsByNino("""{"nino":"invalid"}""")

        result.status shouldBe 422
        result.json.as[JsObject] should (haveProperty[String]("correlationId")
          and haveProperty[JsObject](
            "error",
            haveProperty[String]("errCode", be("ERR_VALIDATION"))
              and havePropertyArrayOf[JsObject](
                "fields",
                haveProperty[String]("code", be("NINO"))
                  and haveProperty[String]("name")
              )
          ))
      }
    }
  }
}
