/*
 * Copyright 2021 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.homeofficesettledstatusstubs.wiring

import com.google.inject.ImplementedBy
import javax.inject.Inject
import uk.gov.hmrc.play.bootstrap.config.ServicesConfig

@ImplementedBy(classOf[AppConfigImpl])
trait AppConfig {
  // define your configurable properties here
}

class AppConfigImpl @Inject()(config: ServicesConfig) extends AppConfig {
  // read your configurable properties here
}
