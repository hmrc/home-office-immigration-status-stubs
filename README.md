# Home Office Settled Status Stubs

## Running the tests

    sbt test it:test

## Running the tests with coverage

    sbt clean coverageOn test it:test coverageReport

## Running the app locally

    sm --start HOSS

or

    sm --start HOSS
    sm --stop HOME_OFFICE_SETTLED_STATUS_STUBS
    sbt run

It should then be listening on port 10212

    browse http://localhost:10212/

## Dynamic Stubbing
By calling the stub with a specific type of parameter you can define how the stub responds. \
eg: `MAKE-BNO--LOTR-LTR-EX` \
eg: `MAKE-EUS-ITR` \
where `MAKE-PRODUCTTYPE-IMMIGRATIONSTATUS-EX` \
the parameter must be prefixed with `MAKE`, with the fields separated by dashes `-`, if you require an underscore in the 
string `_` instead use 2 dashes `--`; this is because the form's validation will stop underscores. \
the `-EX` parameter is optional and defines if the most recent status is expired \
For nino searches, the nino doesnt matter, the givenName should be the coded parameter, the familyName should be `Make`
and the dob should be `01/01/2000`.

For MRZ searches, the document type doesn't matter, the documentNumber should be the coded parameter, the nationality should 
be `Afghanistan`, and the dob should be `01/01/2000`.



### License


This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html")
