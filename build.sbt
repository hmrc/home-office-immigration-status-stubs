import uk.gov.hmrc.DefaultBuildSettings.*
import uk.gov.hmrc.sbtdistributables.SbtDistributablesPlugin.*
import sbt.Keys.*

lazy val scoverageSettings = {
  import scoverage.ScoverageKeys
  Seq(
    ScoverageKeys.coverageExcludedPackages := """.*\.Routes;.*\.RoutesPrefix;.*\.Reverse[^.]*""",
    ScoverageKeys.coverageMinimumStmtTotal := 98,
    ScoverageKeys.coverageFailOnMinimum := true,
    ScoverageKeys.coverageHighlighting := true
  )
}

lazy val root = (project in file("."))
  .settings(
    name := "home-office-immigration-status-stubs",
    organization := "uk.gov.hmrc",
    scalaVersion := "2.13.10",
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
  .enablePlugins(PlayScala, SbtDistributablesPlugin)

scalacOptions ++= Seq(
  "-feature",
  "-Wconf:src=routes/.*:s"
)

addCommandAlias("scalafmtAll", "all scalafmtSbt scalafmt IntegrationTest/scalafmt")
addCommandAlias("scalastyleAll", "all scalastyle IntegrationTest/scalastyle")
