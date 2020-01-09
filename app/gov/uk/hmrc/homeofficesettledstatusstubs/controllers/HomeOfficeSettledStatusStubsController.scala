package gov.uk.hmrc.homeofficesettledstatusstubs.controllers

import gov.uk.hmrc.homeofficesettledstatusstubs.models.StatusResultExamples
import javax.inject.{Inject, Singleton}
import play.api.libs.json.JsValue
import play.api.mvc._
import play.api.{Configuration, Environment}
import uk.gov.hmrc.domain.Nino
import uk.gov.hmrc.play.bootstrap.controller.BackendController

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class HomeOfficeSettledStatusStubsController @Inject()(val env: Environment, cc: ControllerComponents)(
  implicit val configuration: Configuration,
  ec: ExecutionContext)
    extends BackendController(cc) with StatusResultExamples {

  final val HTTP_HEADER_CONTENT_TYPE_JSON = "Content-Type" -> "application/json"

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
            errorResponseBody(correlationId, "ERR_VALIDATION", fields = Some(Seq("NINO" -> "Invalid NINO"))))
        }

      case None =>
        BadRequest(errorResponseBody(correlationId, "ERR_REQUEST_INVALID"))
    }
    Future.successful(response.withHeaders(HTTP_HEADER_CONTENT_TYPE_JSON))
  }

  def errorResponseBody(correlationId: String, errCode: String, fields: Option[Seq[(String, String)]] = None): String =
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
