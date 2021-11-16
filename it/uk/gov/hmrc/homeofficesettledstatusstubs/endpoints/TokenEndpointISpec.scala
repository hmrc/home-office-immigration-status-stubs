package uk.gov.hmrc.homeofficesettledstatusstubs.endpoints

import org.scalatest.Suite
import org.scalatestplus.play.ServerProvider
import play.api.libs.json.JsObject
import play.api.libs.ws.{WSClient, WSResponse}
import uk.gov.hmrc.homeofficesettledstatusstubs.support.{JsonMatchers, ServerBaseISpec}

import java.net.URLEncoder

class TokenEndpointISpec extends ServerBaseISpec with JsonMatchers {
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

}
