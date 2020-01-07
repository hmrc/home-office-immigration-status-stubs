package gov.uk.hmrc.homeofficesettledstatusstubs.controllers

import org.scalatest.Suite
import org.scalatestplus.play.ServerProvider
import play.api.libs.json.Json
import play.api.libs.ws.{ WSClient, WSResponse }
import gov.uk.hmrc.homeofficesettledstatusstubs.support.ServerBaseISpec

class HomeOfficeSettledStatusStubsControllerISpec extends ServerBaseISpec {

  this: Suite with ServerProvider =>

  val url = s"http://localhost:$port/status"

  val wsClient: WSClient = app.injector.instanceOf[WSClient]

  def publicFundsByNino(payload: String): WSResponse = {
    wsClient.url(s"$url/public-funds/nino")
      .post(payload)
      .futureValue
  }

  "HomeOfficeSettledStatusStubsController" when {

    "POST /status/public-funds/nino" should {
      "respond with some data" in {
        val result = publicFundsByNino("")
        result.status shouldBe 200
        result.json shouldBe Json.obj()
      }
    }
  }
}
