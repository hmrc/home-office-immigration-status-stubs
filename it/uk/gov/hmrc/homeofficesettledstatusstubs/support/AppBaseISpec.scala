package uk.gov.hmrc.homeofficesettledstatusstubs.support

import org.scalatestplus.play.OneAppPerSuite
import play.api.Application
import play.api.inject.guice.GuiceApplicationBuilder

abstract class AppBaseISpec extends BaseISpec with OneAppPerSuite with TestApplication {

  override implicit lazy val app: Application = appBuilder.build()

}
