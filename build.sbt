import uk.gov.hmrc.SbtAutoBuildPlugin
import uk.gov.hmrc.DefaultBuildSettings._
import uk.gov.hmrc.sbtdistributables.SbtDistributablesPlugin._
import sbt.Keys._

lazy val scoverageSettings = {
  import scoverage.ScoverageKeys
  Seq(
    ScoverageKeys.coverageExcludedPackages := """uk\.gov\.hmrc\.BuildInfo;.*\.Routes;.*\.RoutesPrefix;.*Filters?;MicroserviceAuditConnector;Module;GraphiteStartUp;.*\.Reverse[^.]*""",
    ScoverageKeys.coverageMinimumStmtTotal := 98,
    ScoverageKeys.coverageFailOnMinimum := true,
    ScoverageKeys.coverageHighlighting := true
  )
}

lazy val root = (project in file("."))
  .settings(
    name := "home-office-immigration-status-stubs",
    organization := "uk.gov.hmrc",
    scalaVersion := "2.13.11",
    // To resolve a bug with version 2.x.x of the scoverage plugin - https://github.com/sbt/sbt/issues/6997
    libraryDependencySchemes ++= Seq("org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always),
    PlayKeys.playDefaultPort := 10212,
    majorVersion := 0,
    libraryDependencies ++= AppDependencies(),
    publishingSettings,
    scoverageSettings,
    Compile / unmanagedResourceDirectories += baseDirectory.value / "resources"
  )
  .configs(IntegrationTest)
  .settings(integrationTestSettings())
  .settings(
    IntegrationTest / fork := false,
    IntegrationTest / unmanagedSourceDirectories += baseDirectory(_ / "it").value,
    IntegrationTest / parallelExecution := false,
    IntegrationTest / testGrouping := oneForkedJvmPerTest((IntegrationTest / definedTests).value)
  )
  .enablePlugins(PlayScala, SbtAutoBuildPlugin, SbtDistributablesPlugin)

scalacOptions ++= Seq(
  "-feature",
  "-Wconf:src=routes/.*:s",
  "-Wconf:cat=unused-imports&src=html/.*:s"
)

addCommandAlias("scalafmtAll", "all scalafmtSbt scalafmt IntegrationTest/scalafmt")
addCommandAlias("scalastyleAll", "all scalastyle IntegrationTest/scalastyle")
