import uk.gov.hmrc.DefaultBuildSettings.*

ThisBuild / majorVersion := 0
ThisBuild / scalaVersion := "2.13.14"

lazy val microservice = Project("home-office-immigration-status-stubs", file("."))
  .enablePlugins(PlayScala, SbtDistributablesPlugin)
  .disablePlugins(JUnitXmlReportPlugin)
  .settings(
    PlayKeys.playDefaultPort := 10212,
    libraryDependencies ++= AppDependencies(),
    CodeCoverageSettings.settings
  )
  .settings(
    scalacOptions ++= Seq(
      "-feature",
      "-Wconf:src=routes/.*:s"
    )
  )

lazy val it = project
  .enablePlugins(PlayScala)
  .dependsOn(microservice % "test->test") // the "test->test" allows reusing test code and test dependencies
  .settings(itSettings())

addCommandAlias("scalafmtAll", "all scalafmtSbt scalafmt Test/scalafmt it/Test/scalafmt")
