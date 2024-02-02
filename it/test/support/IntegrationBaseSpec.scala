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

package support

import org.scalatest.TestSuite
import org.scalatest.concurrent._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatestplus.play.guice.GuiceOneServerPerSuite
import play.api.libs.ws._

trait IntegrationBaseSpec
    extends AnyWordSpecLike
    with Matchers
    with GuiceOneServerPerSuite
    with ScalaFutures
    with IntegrationPatience {
  self: TestSuite =>

  private lazy val wsClient: WSClient = app.injector.instanceOf[WSClient]

  def buildRequest(path: String): WSRequest = wsClient.url(s"http://localhost:$port$path").withFollowRedirects(false)
}
