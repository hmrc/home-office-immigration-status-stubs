# Home Office Settled Status Stubs

## Running the tests

    sbt test it:test

## Running the tests with coverage

    sbt clean coverageOn test it:test coverageReport

## Running the app locally

    sm --start AGENTS_STUBS HOME_OFFICE_SETTLED_STATUS_STUBS -f
    sm --stop HOME_OFFICE_SETTLED_STATUS_STUBS
    sbt run

It should then be listening on port 9387

    browse http://localhost:9387/home-office-settled-status-stubs

### License


This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html")
