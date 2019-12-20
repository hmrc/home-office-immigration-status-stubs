package gov.uk.hmrc.homeofficesettledstatusstubs.services

import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers._
import org.mockito.Mockito._
import org.scalatest.concurrent.Eventually
import org.scalatest.mockito.MockitoSugar
import org.scalatest.time.{Millis, Span}
import play.api.test.FakeRequest
import uk.gov.hmrc.agentmtdidentifiers.model.Arn
import gov.uk.hmrc.homeofficesettledstatusstubs.models.HomeOfficeSettledStatusStubsModel
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.http.logging.{Authorization, RequestId, SessionId}
import uk.gov.hmrc.play.audit.http.connector.AuditConnector
import uk.gov.hmrc.play.audit.model.DataEvent
import uk.gov.hmrc.play.test.UnitSpec

import scala.concurrent.ExecutionContext

class AuditServiceSpec extends UnitSpec with MockitoSugar with Eventually {

  override implicit val patienceConfig =
    PatienceConfig(timeout = scaled(Span(500, Millis)), interval = scaled(Span(200, Millis)))

  "auditService" should {

    "send an HomeOfficeSettledStatusStubsSomethingHappened event with the correct fields" in {
      val mockConnector = mock[AuditConnector]
      val service = new AuditService(mockConnector)

      val hc = HeaderCarrier(
        authorization = Some(Authorization("dummy bearer token")),
        sessionId = Some(SessionId("dummy session id")),
        requestId = Some(RequestId("dummy request id")))

      val model = HomeOfficeSettledStatusStubsModel(
        parameter1 = "John Smith",
        parameter2 = None,
        telephoneNumber = Some("12313"),
        emailAddress = Some("john.smith@email.com"))

      await(
        service.sendHomeOfficeSettledStatusStubsSomethingHappened(model, Arn("ARN0001"))(
          hc,
          FakeRequest("GET", "/path"),
          ExecutionContext.Implicits.global))

      eventually {
        val captor = ArgumentCaptor.forClass(classOf[DataEvent])
        verify(mockConnector).sendEvent(captor.capture())(any[HeaderCarrier], any[ExecutionContext])
        val sentEvent = captor.getValue.asInstanceOf[DataEvent]

        sentEvent.auditType shouldBe "HomeOfficeSettledStatusStubsSomethingHappened"
        sentEvent.auditSource shouldBe "home-office-settled-status-stubs"
        sentEvent.detail("agentReference") shouldBe "ARN0001"
        sentEvent.detail("parameter1") shouldBe "John Smith"
        sentEvent.detail("telephoneNumber") shouldBe "12313"
        sentEvent.detail("emailAddress") shouldBe "john.smith@email.com"

        sentEvent.tags("transactionName") shouldBe "home-office-settled-status-stubs-something-happened"
        sentEvent.tags("path") shouldBe "/path"
        sentEvent.tags("X-Session-ID") shouldBe "dummy session id"
        sentEvent.tags("X-Request-ID") shouldBe "dummy request id"
      }
    }
  }
}
