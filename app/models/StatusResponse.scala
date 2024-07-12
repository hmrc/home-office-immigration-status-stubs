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

package models

import play.api.data.FormError
import play.api.http.Status.BAD_REQUEST
import play.api.libs.json.{JsValue, Json, OWrites}

sealed trait StatusResponse {
  val correlationId: String

  val asJson: JsValue = this match {
    case e: ErrorResponse   => Json.toJson(e)
    case s: SuccessResponse => Json.toJson(s)
  }
}

case class ErrorResponse(correlationId: String, status: Int = BAD_REQUEST, error: StatusError) extends StatusResponse

object ErrorResponse {
  implicit val writes: OWrites[ErrorResponse] = Json.writes[ErrorResponse]
}
case class SuccessResponse(correlationId: String, result: StatusCheckResult) extends StatusResponse

object SuccessResponse {
  implicit val writes: OWrites[SuccessResponse] = Json.writes[SuccessResponse]
}

object StatusResponse {

  def errorResponseBody(
    correlationId: String,
    errCode: String,
    status: Int,
    fields: Seq[FormError]
  ): ErrorResponse =
    ErrorResponse(
      status = status,
      correlationId = correlationId,
      error = StatusError(
        errCode = errCode,
        fields = fields.map(error => Field(error.message, error.key))
      )
    )

}
