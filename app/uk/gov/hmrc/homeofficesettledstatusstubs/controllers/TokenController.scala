/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.homeofficesettledstatusstubs.controllers

import play.api.{Configuration, Environment}
import play.api.libs.json.{Format, Json}
import play.api.mvc.{Action, AnyContent, ControllerComponents}
import uk.gov.hmrc.homeofficesettledstatusstubs.controllers.TokenController.tokenForm
import uk.gov.hmrc.play.bootstrap.backend.controller.BackendController

import java.util.UUID
import javax.inject.Inject
import scala.concurrent.Future
import play.api.data.Form
import play.api.data.Forms._

class TokenController @Inject()(
  val env: Environment,
  cc: ControllerComponents
)(implicit val configuration: Configuration)
    extends BackendController(cc) {

  def token: Action[AnyContent] = Action.async { implicit request =>
    Future.successful(
      tokenForm
        .bindFromRequest()
        .fold(
          errors => BadRequest(Json.toJson(errors.errors.map(e => (e.key, e.message)).toMap)),
          _ => Ok(Json.parse(s"""{
                                |   "access_token": "${UUID.randomUUID().toString}",
                                |   "refresh_token": "${UUID.randomUUID().toString}",
                                |   "token_type": "Bearer"
                                |}""".stripMargin))
        ))
  }
}

object TokenController {

  private case class TokenRequest(grant_type: String, client_id: String, client_secret: String)

  private object TokenRequest {
    implicit val formats: Format[TokenRequest] = Json.format[TokenRequest]
  }

  private val tokenForm: Form[TokenRequest] = Form(
    mapping(
      "grant_type" -> nonEmptyText
        .verifying("Wrong grant type.", _ == "client_credentials"),
      "client_id" -> nonEmptyText
        .verifying("Unknown client_id.", _ == "hmrc"),
      "client_secret" -> nonEmptyText,
    )(TokenRequest.apply)(TokenRequest.unapply)
  )

}
