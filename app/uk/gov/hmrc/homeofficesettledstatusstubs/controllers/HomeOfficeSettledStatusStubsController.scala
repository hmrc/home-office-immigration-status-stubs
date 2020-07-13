/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.homeofficesettledstatusstubs.controllers

import java.util.UUID

import javax.inject.{Inject, Singleton}
import play.api.libs.json.{Format, JsObject, JsValue, Json}
import play.api.mvc._
import play.api.{Configuration, Environment}
import uk.gov.hmrc.domain.Nino
import uk.gov.hmrc.homeofficesettledstatusstubs.models.StatusResultExamples
import uk.gov.hmrc.play.bootstrap.controller.BackendController

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class HomeOfficeSettledStatusStubsController @Inject()(
  val env: Environment,
  cc: ControllerComponents)(implicit val configuration: Configuration, ec: ExecutionContext)
    extends BackendController(cc) with StatusResultExamples {

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

    val ninoOpt = (request.body \ "nino").asOpt[String]
    val givenNameOpt = (request.body \ "givenName").asOpt[String]
    val familyNameOpt = (request.body \ "familyName").asOpt[String]
    val dateOfBirthOpt = (request.body \ "dateOfBirth").asOpt[String]

    val query = (ninoOpt, givenNameOpt, familyNameOpt, dateOfBirthOpt)

    val response = query match {
      case (Some(nino), Some(givenName), Some(familyName), Some(dateOfBirth)) =>
        val normalizedNino = nino.replaceAll(" ", "").toUpperCase
        if (Nino.isValid(normalizedNino)) {
          normalizedNino match {

            case "HK089820A" =>
              Conflict(errorResponseBody(correlationId, "ERR_CONFLICT"))

            case _ =>
              resultFor(correlationId, nino) match {
                case Some(content) =>
                  val entity = Json.parse(content)

                  val hasResult = entity.asOpt[JsObject].exists(_.keys.contains("result"))
                  val hasError = entity.asOpt[JsObject].exists(_.keys.contains("error"))

                  val givenNameMatches = (entity \ "result" \ "fullName")
                    .asOpt[String]
                    .exists(_.split(" ").headOption
                      .exists(_.toUpperCase.startsWith(givenName.take(1).toUpperCase)))

                  val familyNameMatches = (entity \ "result" \ "fullName")
                    .asOpt[String]
                    .exists(_.split(" ").reverse.headOption
                      .exists(_.toUpperCase.startsWith(familyName.take(3).toUpperCase)))

                  val dateOfBirthMatches =
                    (entity \ "result" \ "dateOfBirth")
                      .asOpt[String]
                      .exists(_.matches(dateToPattern(dateOfBirth)))

                  if (givenNameMatches && familyNameMatches && dateOfBirthMatches) {
                    Ok(entity)
                  } else if (!hasResult && !hasError) {
                    Ok("")
                  } else if (hasError) {
                    val status = (entity \ "status").asOpt[Int].getOrElse(400)
                    new Status(status)(entity)
                  } else {
                    NotFound(errorResponseBody(correlationId, "ERR_NOT_FOUND"))
                  }

                case None =>
                  NotFound(errorResponseBody(correlationId, "ERR_NOT_FOUND"))
              }
          }
        } else {
          BadRequest(
            errorResponseBody(
              correlationId,
              "ERR_VALIDATION",
              fields = Some(Seq("nino" -> "ERR_INVALID_NINO"))))
        }

      case _ =>
        val fields = Seq(
          errorField(ninoOpt.isEmpty, "nino", "ERR_MISSING_NINO"),
          errorField(dateOfBirthOpt.isEmpty, "dateOfBirth", "ERR_MISSING_DOB"),
          errorField(familyNameOpt.isEmpty, "familyName", "ERR_MISSING_FAMILY_NAME"),
          errorField(givenNameOpt.isEmpty, "giveName", "ERR_MISSING_GIVEN_NAME")
        ).collect { case Some(x) => x }

        BadRequest(errorResponseBody(correlationId, "ERR_VALIDATION", Some(fields)))
    }
    Future.successful(response.withHeaders(HTTP_HEADER_CONTENT_TYPE_JSON))
  }

  def dateToPattern(dateOfBirth: String): String =
    dateOfBirth
      .map {
        case ch if ch == 'X' => "\\d"
        case ch              => ch
      }
      .mkString("^", "", "$")

  def errorField(hasError: Boolean, name: String, code: String): Option[(String, String)] =
    if (hasError) Some((name, code)) else None

  def errorResponseBody(
    correlationId: String,
    errCode: String,
    fields: Option[Seq[(String, String)]] = None): String =
    s"""{
       |  "correlationId": "$correlationId",
       |  "error": {
       |    "errCode": "$errCode"${fields
         .map(f =>
           s""",
              |    "fields": [ ${f
                .map {
                  case (code, name) =>
                    s"""|     {
                        |       "code": "$code",
                        |       "name": "$name"
                        |     }""".stripMargin
                }
                .mkString(",\n")}
              |     ]""".stripMargin)
         .getOrElse("")}
       |  }
       |}""".stripMargin

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
