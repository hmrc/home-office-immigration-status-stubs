import AppDependencies.jettyOverrides
import sbt.Tests.{Group, SubProcess}
import uk.gov.hmrc.SbtAutoBuildPlugin
import uk.gov.hmrc.sbtdistributables.SbtDistributablesPlugin._

lazy val scoverageSettings = {
  import scoverage.ScoverageKeys
  Seq(
    ScoverageKeys.coverageExcludedPackages := """uk\.gov\.hmrc\.BuildInfo;.*\.Routes;.*\.RoutesPrefix;.*Filters?;MicroserviceAuditConnector;Module;GraphiteStartUp;.*\.Reverse[^.]*""",
    ScoverageKeys.coverageMinimum := 71.00,
    ScoverageKeys.coverageFailOnMinimum := false,
    ScoverageKeys.coverageHighlighting := true,
    parallelExecution in Test := false
  )
}

lazy val root = (project in file("."))
  .settings(
    name := "home-office-settled-status-stubs",
    organization := "uk.gov.hmrc",
    scalaVersion := "2.12.12",
    PlayKeys.playDefaultPort := 10212,
    resolvers += Resolver.jcenterRepo,
    libraryDependencies ++= AppDependencies(),
    dependencyOverrides ++= jettyOverrides,
    publishingSettings,
    scoverageSettings,
    unmanagedResourceDirectories in Compile += baseDirectory.value / "resources",
    routesImport ++= Seq("uk.gov.hmrc.homeofficesettledstatusstubs.binders.UrlBinders._"),
    scalafmtOnCompile in Compile := true,
    scalafmtOnCompile in Test := true
  )
  .configs(IntegrationTest)
  .settings(
    Keys.fork in IntegrationTest := false,
    Defaults.itSettings,
    unmanagedSourceDirectories in IntegrationTest += baseDirectory(_ / "it").value,
    parallelExecution in IntegrationTest := false,
    testGrouping in IntegrationTest := oneForkedJvmPerTest((definedTests in IntegrationTest).value),
    scalafmtOnCompile in IntegrationTest := true,
    majorVersion := 0
  )
  .enablePlugins(PlayScala, SbtAutoBuildPlugin, SbtDistributablesPlugin)

  scalacOptions ++= Seq(
    "-P:silencer:pathFilters=views;routes"
  )

  inConfig(IntegrationTest)(scalafmtCoreSettings)

  def oneForkedJvmPerTest(tests: Seq[TestDefinition]): Seq[Group] = {
    tests.map { test =>
      Group(test.name, Seq(test), SubProcess(ForkOptions().withRunJVMOptions(Vector(s"-Dtest.name=${test.name}"))))
    }
  }
