import play.core.PlayVersion
import sbt._

object AppDependencies {

  private val compile = Seq(
    play.sbt.PlayImport.ws,
    "uk.gov.hmrc" %% "bootstrap-backend-play-28" % "5.10.0",
    "uk.gov.hmrc" %% "domain"                    % "6.2.0-play-28",
    "uk.gov.hmrc" %% "hmrc-stubs-core"           % "6.2.0-play-26"
  )

  private val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"            %% "service-integration-test" % "1.1.0-play-28",
    "org.scalatest"          %% "scalatest"                % "3.0.9",
    "org.scalatestplus.play" %% "scalatestplus-play"       % "5.1.0",
    "org.scalatestplus"      %% "mockito-3-4"              % "3.2.9.0",
    "com.vladsch.flexmark"   % "flexmark-all"              % "0.35.10",
    "org.mockito"            % "mockito-core"              % "2.28.2",
    "org.pegdown"            % "pegdown"                   % "1.6.0",
    "com.typesafe.play"      %% "play-test"                % PlayVersion.current,
    "com.github.tomakehurst" % "wiremock"                  % "2.27.2"
  ).map(_ % "test, it")

  private val silencerDependencies: Seq[ModuleID] = Seq(
    compilerPlugin("com.github.ghik" % "silencer-plugin" % "1.7.0" cross CrossVersion.full),
    "com.github.ghik" % "silencer-lib" % "1.7.0" % Provided cross CrossVersion.full
  )

  private val jettyVersion = "9.2.24.v20180105"

  val jettyOverrides = Seq(
    "org.eclipse.jetty" % "jetty-server" % jettyVersion % IntegrationTest,
    "org.eclipse.jetty" % "jetty-servlet" % jettyVersion % IntegrationTest,
    "org.eclipse.jetty" % "jetty-security" % jettyVersion % IntegrationTest,
    "org.eclipse.jetty" % "jetty-servlets" % jettyVersion % IntegrationTest,
    "org.eclipse.jetty" % "jetty-continuation" % jettyVersion % IntegrationTest,
    "org.eclipse.jetty" % "jetty-webapp" % jettyVersion % IntegrationTest,
    "org.eclipse.jetty" % "jetty-xml" % jettyVersion % IntegrationTest,
    "org.eclipse.jetty" % "jetty-client" % jettyVersion % IntegrationTest,
    "org.eclipse.jetty" % "jetty-http" % jettyVersion % IntegrationTest,
    "org.eclipse.jetty" % "jetty-io" % jettyVersion % IntegrationTest,
    "org.eclipse.jetty" % "jetty-util" % jettyVersion % IntegrationTest,
    "org.eclipse.jetty.websocket" % "websocket-api" % jettyVersion % IntegrationTest,
    "org.eclipse.jetty.websocket" % "websocket-common" % jettyVersion % IntegrationTest,
    "org.eclipse.jetty.websocket" % "websocket-client" % jettyVersion % IntegrationTest
  )

  def apply(): Seq[ModuleID] = compile ++ test ++ silencerDependencies
}
