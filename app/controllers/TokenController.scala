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

import forms.TokenForm
import models.token.Token
import play.api.libs.json._
import play.api.mvc._
import uk.gov.hmrc.play.bootstrap.backend.controller.BackendController

import javax.inject._
import scala.concurrent.Future

@Singleton
class TokenController @Inject() (form: TokenForm, cc: ControllerComponents) extends BackendController(cc) {

  def token: Action[AnyContent] = Action.async { implicit request =>
    val result = form()
      .bindFromRequest()
      .fold(
        errors => BadRequest(Json.toJson(errors.errors.map(e => (e.key, e.message)).toMap)),
        _ => Ok(Json.toJson(Token()))
      )

    Future.successful(result)
  }
}
