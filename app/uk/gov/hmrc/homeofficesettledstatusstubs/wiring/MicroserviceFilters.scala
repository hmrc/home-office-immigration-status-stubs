/*
 * Copyright 2021 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.homeofficesettledstatusstubs.wiring

import com.kenshoo.play.metrics.MetricsFilter
import play.api.http.DefaultHttpFilters
import uk.gov.hmrc.play.bootstrap.filters.{CacheControlFilter, LoggingFilter}

import javax.inject.{Inject, Singleton}

@Singleton
class MicroserviceFilters @Inject()(
  metricsFilter: MetricsFilter,
  loggingFilter: LoggingFilter,
  cacheFilter: CacheControlFilter,
  monitoringFilter: MicroserviceMonitoringFilter)
    extends DefaultHttpFilters(metricsFilter, monitoringFilter, loggingFilter, cacheFilter)
