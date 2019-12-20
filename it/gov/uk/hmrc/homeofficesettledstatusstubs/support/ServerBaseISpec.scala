package gov.uk.hmrc.homeofficesettledstatusstubs.support

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Seconds, Span}
import org.scalatestplus.play.OneServerPerSuite
import play.api.Application
import play.api.inject.guice.GuiceApplicationBuilder

abstract class ServerBaseISpec extends BaseISpec with OneServerPerSuite with ScalaFutures {

  override implicit lazy val app: Application = appBuilder.build()

  implicit override val patienceConfig: PatienceConfig = PatienceConfig(timeout = Span(4, Seconds), interval = Span(1, Seconds))

  protected override def appBuilder: GuiceApplicationBuilder = {
    new GuiceApplicationBuilder()
      .configure(
        "microservice.services.auth.port" -> wireMockPort,
        "metrics.enabled" -> true,
        "auditing.enabled" -> true,
        "auditing.consumer.baseUri.host" -> wireMockHost,
        "auditing.consumer.baseUri.port" -> wireMockPort)
  }

}
