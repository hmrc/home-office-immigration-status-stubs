/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers

import forms.NinoSearchForm
import models.StatusResponse
import play.api.mvc.*
import services.StubDataService
import uk.gov.hmrc.play.bootstrap.backend.controller.BackendController

import javax.inject.*
import scala.concurrent.Future

@Singleton
class NinoController @Inject() (
  form: NinoSearchForm,
  stubDataService: StubDataService,
  cc: ControllerComponents
) extends BackendController(cc) {

  def publicFundsByNino: Action[AnyContent] = Action.async { request =>
    given Request[AnyContent] = request

    val correlationId = request.headers.get("X-Correlation-Id").getOrElse("00000000")
    val result        = form(correlationId)
      .bindFromRequest()
      .fold(
        errorForm =>
          BadRequest(
            StatusResponse
              .errorResponseBody(correlationId, "ERR_VALIDATION", BAD_REQUEST, errorForm.errors)
              .asJson
          ),
        search => stubDataService.ninoSearch(search)
      )

    Future.successful(result)
  }
}
