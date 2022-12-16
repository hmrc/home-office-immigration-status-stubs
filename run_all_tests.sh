#!/usr/bin/env bash

sbt clean compile scalafmtAll scalastyleAll coverage it:test coverageOff dependencyUpdates coverageReport
