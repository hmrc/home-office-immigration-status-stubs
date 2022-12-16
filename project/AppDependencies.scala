import play.core.PlayVersion
import sbt._

object AppDependencies {

  private val compile = Seq(
    play.sbt.PlayImport.ws,
    "uk.gov.hmrc" %% "bootstrap-backend-play-28" % "7.12.0",
    "uk.gov.hmrc" %% "domain"                    % "8.1.0-play-28"
  )

  private val test: Seq[ModuleID] = Seq(
    "org.scalatest"                %% "scalatest"            % "3.2.14",
    "org.scalatestplus.play"       %% "scalatestplus-play"   % "5.1.0",
    "com.vladsch.flexmark"          % "flexmark-all"         % "0.62.2",
    "com.typesafe.play"            %% "play-test"            % PlayVersion.current,
    "com.github.tomakehurst"        % "wiremock-jre8"        % "2.35.0",
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.14.1"
  ).map(_ % "it")

  def apply(): Seq[ModuleID]      = compile ++ test
}
