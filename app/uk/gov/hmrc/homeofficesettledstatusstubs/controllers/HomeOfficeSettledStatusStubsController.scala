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

import play.api.libs.json.{Format, JsValue, Json}
import play.api.mvc._
import play.api.{Configuration, Environment}
import uk.gov.hmrc.domain.Nino
import uk.gov.hmrc.play.bootstrap.backend.controller.BackendController
import uk.gov.hmrc.homeofficesettledstatusstubs.models._
import uk.gov.hmrc.homeofficesettledstatusstubs.services.StubDataService

import java.util.UUID
import javax.inject.{Inject, Singleton}
import scala.concurrent.Future

@Singleton
class HomeOfficeSettledStatusStubsController @Inject()(
  val env: Environment,
  cc: ControllerComponents,
  stubDataService: StubDataService)(implicit val configuration: Configuration)
    extends BackendController(cc) {

  final val HTTP_HEADER_CONTENT_TYPE_JSON = "Content-Type" -> "application/json"

  def token: Action[AnyContent] = Action.async { implicit request =>
    Future.successful(
      HomeOfficeSettledStatusStubsController.tokenForm
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

  def publicFundsByNino: Action[JsValue] = Action.async(parse.tolerantJson) { implicit request =>
    val correlationId = request.headers.get("X-Correlation-Id").getOrElse("00000000")

    val response = withValidParameters(correlationId, request.body) {
      (nino, givenName, familyName, dateOfBirth) =>
        stubDataService.ninoSearch(correlationId, nino, givenName, familyName, dateOfBirth)
    }

    Future.successful(response.withHeaders(HTTP_HEADER_CONTENT_TYPE_JSON))
  }

  private def withValidParameters(correlationId: String, body: JsValue)(
    successFunc: (String, String, String, String) => Result): Result = {

    val ninoOpt = (body \ "nino").asOpt[String].map(_.replaceAll(" ", "").toUpperCase)
    val givenNameOpt = (body \ "givenName").asOpt[String]
    val familyNameOpt = (body \ "familyName").asOpt[String]
    val dateOfBirthOpt = (body \ "dateOfBirth").asOpt[String]

    val query = (ninoOpt, givenNameOpt, familyNameOpt, dateOfBirthOpt)

    query match {
      case (Some(nino), Some(givenName), Some(familyName), Some(dateOfBirth)) =>
        if (Nino.isValid(nino)) {
          successFunc(nino, givenName, familyName, dateOfBirth)
        } else {
          ninoValidationError(correlationId)
        }
      case _ =>
        generateValidationFailure(
          correlationId,
          ninoOpt,
          givenNameOpt,
          familyNameOpt,
          dateOfBirthOpt)
    }
  }

  private def generateValidationFailure(
    correlationId: String,
    ninoOpt: Option[String],
    dateOfBirthOpt: Option[String],
    familyNameOpt: Option[String],
    givenNameOpt: Option[String]): Result = {
    val fields = Seq(
      errorField(ninoOpt.isEmpty, "nino", "ERR_MISSING_NINO"),
      errorField(dateOfBirthOpt.isEmpty, "dateOfBirth", "ERR_MISSING_DOB"),
      errorField(familyNameOpt.isEmpty, "familyName", "ERR_MISSING_FAMILY_NAME"),
      errorField(givenNameOpt.isEmpty, "giveName", "ERR_MISSING_GIVEN_NAME")
    ).collect { case Some(x) => x }

    BadRequest(StatusResponse.errorResponseBody(correlationId, "ERR_VALIDATION", fields))
  }

  private def errorField(hasError: Boolean, name: String, code: String): Option[(String, String)] =
    if (hasError) Some((name, code)) else None

  private def ninoValidationError(correlationId: String) =
    BadRequest(
      StatusResponse.errorResponseBody(
        correlationId,
        "ERR_VALIDATION",
        fields = Seq("nino" -> "ERR_INVALID_NINO"))
    )

}

object HomeOfficeSettledStatusStubsController {

  import play.api.data.Form
  import play.api.data.Forms._

  case class TokenRequest(grant_type: String, client_id: String, client_secret: String)

  object TokenRequest {
    implicit val formats: Format[TokenRequest] = Json.format[TokenRequest]
  }

  val tokenForm: Form[TokenRequest] = Form(
    mapping(
      "grant_type" -> nonEmptyText
        .verifying("Wrong grant type.", _ == "client_credentials"),
      "client_id" -> nonEmptyText
        .verifying("Unknown client_id.", _ == "hmrc"),
      "client_secret" -> nonEmptyText,
    )(TokenRequest.apply)(TokenRequest.unapply)
  )

}
