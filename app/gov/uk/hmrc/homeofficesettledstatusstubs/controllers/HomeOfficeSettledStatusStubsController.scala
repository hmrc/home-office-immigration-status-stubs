package gov.uk.hmrc.homeofficesettledstatusstubs.controllers

import java.util.UUID

import gov.uk.hmrc.homeofficesettledstatusstubs.models.StatusResultExamples
import javax.inject.{Inject, Singleton}
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import play.api.{Configuration, Environment}
import uk.gov.hmrc.domain.Nino
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
          errors => BadRequest(errors.toString),
          _ => Ok(Json.parse(s"""{
                                |   "access_token": "${UUID.randomUUID().toString}",
                                |   "refresh_token": "${UUID.randomUUID().toString}",
                                |   "id_token": "${UUID.randomUUID().toString}",
                                |   "token_type": "Bearer"
                                |}""".stripMargin))
        ))
  }

  def publicFundsByNino: Action[JsValue] = Action.async(parse.tolerantJson) { implicit request =>
    val correlationId = request.headers.get("x-correlation-id").getOrElse("00000000")

    val response = (request.body \ "nino").asOpt[String] match {
      case Some(nino) =>
        val normalizedNino = nino.replaceAll(" ", "").toUpperCase
        if (Nino.isValid(normalizedNino)) {
          examples.get(normalizedNino) match {
            case Some(content) =>
              val enhancedContent = content.replaceAllLiterally("{correlationId}", correlationId)
              Ok(enhancedContent)

            case None =>
              NotFound(errorResponseBody(correlationId, "ERR_NOT_FOUND"))
          }
        } else {
          UnprocessableEntity(
            errorResponseBody(
              correlationId,
              "ERR_VALIDATION",
              fields = Some(Seq("NINO" -> "Invalid NINO"))))
        }

      case None =>
        BadRequest(errorResponseBody(correlationId, "ERR_REQUEST_INVALID"))
    }
    Future.successful(response.withHeaders(HTTP_HEADER_CONTENT_TYPE_JSON))
  }

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
    implicit val formats = Json.format[TokenRequest]
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
