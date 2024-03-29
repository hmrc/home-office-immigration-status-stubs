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
import play.api.data.Form
import play.api.libs.json.JsValue
import play.api.mvc._
import services.StubDataService
import uk.gov.hmrc.play.bootstrap.backend.controller.BackendController

import javax.inject._

@Singleton
class NinoController @Inject() (
  form: NinoSearchForm,
  stubDataService: StubDataService,
  jsonHeaders: JsonHeadersAction,
  cc: ControllerComponents
) extends BackendController(cc) {

  def publicFundsByNino: Action[JsValue] = jsonHeaders(parse.tolerantJson) { implicit request =>
    val correlationId = request.headers.get("X-Correlation-Id").getOrElse("00000000")
    form(correlationId)
      .bind(request.body, Form.FromJsonMaxChars)
      .fold(
        errors =>
          BadRequest(
            StatusResponse
              .errorResponseBody(correlationId, "ERR_VALIDATION", fields = errors.errors)
          ),
        search => stubDataService.ninoSearch(search)
      )
  }
}
