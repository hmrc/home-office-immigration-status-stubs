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

package stubData

import models.StatusCheckResult

final case class Record(result: StatusCheckResult, nino: String, docType: String, docNum: String)

trait DataSet {
  val records: Seq[Record]

  lazy val ninoToResult: Map[String, StatusCheckResult]          = records.map(r => r.nino -> r.result).toMap
  lazy val mrzToResult: Map[(String, String), StatusCheckResult] =
    records.map(r => (r.docType, r.docNum) -> r.result).toMap
}
