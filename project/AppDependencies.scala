import sbt.*

object AppDependencies {

  private val bootstrapPlayVersion = "8.4.0"

  private val compile: Seq[ModuleID] = Seq(
    "uk.gov.hmrc" %% "bootstrap-backend-play-30" % bootstrapPlayVersion,
    "uk.gov.hmrc" %% "domain-play-30"            % "9.0.0"
  )

  private val test: Seq[ModuleID]   = Seq(
    "com.fasterxml.jackson.module" %% "jackson-module-scala"   % "2.16.1",
    "uk.gov.hmrc"                  %% "bootstrap-test-play-30" % bootstrapPlayVersion
  ).map(_ % Test)

  // only add additional dependencies here - it test inherit test dependencies above already
  val itDependencies: Seq[ModuleID] = Seq()

  def apply(): Seq[ModuleID] = compile ++ test
}
