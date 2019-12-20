package gov.uk.hmrc.homeofficesettledstatusstubs.controllers

import org.scalatest.Suite
import org.scalatestplus.play.ServerProvider
import play.api.libs.json.Json
import play.api.libs.ws.{ WSClient, WSResponse }
import gov.uk.hmrc.homeofficesettledstatusstubs.support.ServerBaseISpec

class HomeOfficeSettledStatusStubsControllerISpec extends ServerBaseISpec {

  this: Suite with ServerProvider =>

  val url = s"http://localhost:$port/home-office-settled-status-stubs"

  val wsClient = app.injector.instanceOf[WSClient]

  def entity(): WSResponse = {
    wsClient.url(s"$url/entities")
      .get()
      .futureValue
  }

  "HomeOfficeSettledStatusStubsController" when {

    "GET /entities" should {
      "respond with some data" in {
        val result = entity()
        result.status shouldBe 200
        result.json shouldBe Json.obj("parameter1" -> "hello world")
      }
    }
  }
}
