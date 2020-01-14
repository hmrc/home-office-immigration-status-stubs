/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package gov.uk.hmrc.homeofficesettledstatusstubs.wiring

import javax.inject.{Inject, Singleton}

import com.kenshoo.play.metrics.MetricsFilter
import play.api.http.DefaultHttpFilters
import uk.gov.hmrc.play.bootstrap.filters.{AuditFilter, CacheControlFilter, LoggingFilter}

@Singleton
class MicroserviceFilters @Inject()(
  metricsFilter: MetricsFilter,
  loggingFilter: LoggingFilter,
  cacheFilter: CacheControlFilter,
  monitoringFilter: MicroserviceMonitoringFilter)
    extends DefaultHttpFilters(metricsFilter, monitoringFilter, loggingFilter, cacheFilter)
