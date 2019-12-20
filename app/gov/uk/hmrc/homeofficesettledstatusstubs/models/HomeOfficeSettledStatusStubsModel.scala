package gov.uk.hmrc.homeofficesettledstatusstubs.models

import play.api.libs.json.Json

case class HomeOfficeSettledStatusStubsModel(
  parameter1: String,
  parameter2: Option[String],
  telephoneNumber: Option[String],
  emailAddress: Option[String])

object HomeOfficeSettledStatusStubsModel {
  implicit val modelFormat = Json.format[HomeOfficeSettledStatusStubsModel]
}
