import sbt.Setting
import scoverage.ScoverageKeys.*

object CodeCoverageSettings {

  private val excludedFiles: Seq[String] = Seq(".*Routes.*", ".*\\$anon.*")

  val settings: Seq[Setting[?]] = Seq(
    coverageExcludedFiles := excludedFiles.mkString(","),
    coverageMinimumStmtTotal := 99,
    coverageFailOnMinimum := true,
    coverageHighlighting := true
  )
}
