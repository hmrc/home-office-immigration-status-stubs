#!/usr/bin/env bash

sbt clean compile scalafmtAll scalastyleAll coverage IntegrationTest/test coverageOff dependencyUpdates coverageReport
