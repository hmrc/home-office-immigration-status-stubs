import play.core.PlayVersion
import sbt._

object AppDependencies {

  private val bootstrapPlayVersion = "7.21.0"

  private val compile = Seq(
    play.sbt.PlayImport.ws,
    "uk.gov.hmrc" %% "bootstrap-backend-play-28" % bootstrapPlayVersion,
    "uk.gov.hmrc" %% "domain"                    % "8.3.0-play-28"
  )

  private val test: Seq[ModuleID] = Seq(
    "org.scalatest"                %% "scalatest"              % "3.2.16",
    "org.scalatestplus.play"       %% "scalatestplus-play"     % "5.1.0",
    "com.vladsch.flexmark"          % "flexmark-all"           % "0.64.8",
    "com.typesafe.play"            %% "play-test"              % PlayVersion.current,
    "com.fasterxml.jackson.module" %% "jackson-module-scala"   % "2.15.2",
    "uk.gov.hmrc"                  %% "bootstrap-test-play-28" % bootstrapPlayVersion
  ).map(_ % "it")

  def apply(): Seq[ModuleID]      = compile ++ test
}
