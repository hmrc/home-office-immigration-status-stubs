# Home Office Immigration Status Stubs

This is the stub for the Check Immigration Status service.

## Running tests
```bash
./run_all_tests.sh
```

## Running locally
```shell
sm2 --start HOME_OFFICE_IMMIGRATION_STATUS_ALL
```
OR
```shell
    sm2 --start HOME_OFFICE_IMMIGRATION_STATUS_ALL
    sm2 --stop HOME_OFFICE_IMMIGRATION_STATUS_STUBS
    sbt run
```

It should then be listening on port 10212.

## Dynamic Stubbing
This stub has dynamic stubbing functionality which allows the user to test certain product types and immigration statuses 
without having to add new data to the stub. The product type and immigration status entered will be returned as both the 
current status and the previous status to allow testing of all content for this combination.

### Dynamic stub identifier
The dynamic identifier should be constructed using the following pattern:
`MAKE-[Product type]-[Immigration status](-EX)`.

Underscores in either the product type or immigration status should be replaced by two dashes `--`.

The `-EX` parameter is optional and defines if the most recent status is expired.

For example:
- if you want to return data where the individual's statuses have the product type `EUS` and immigration status `LTR` 
and were not expired, the dynamic identifier would be `MAKE-EUS-LTR`
- for product type `WORK` and immigration status `LTE` with an expired status, the dynamic identifier would be `MAKE-WORK-LTE-EX`
- and for product type `EUS_JFM` and immigration status `ILR`, the dynamic identifier would be `MAKE-EUS--JFM-ILR`

## Endpoints
The use of this functionality differs slightly between the NINO search and the document search endpoints.

### NINO Search
`POST /v1/status/public-funds/nino`

This endpoint is used to perform a NINO search on the predefined stub test data and also create dynamic test data for NINO searches.

For NINO searches using the dynamic stubbing feature,
the NINO should be a NINO not defined in the stub such as `SP123456A`,
the given name should be the dynamic identifier,
the family name should be `Make` and the date of birth should be `2000-01-01`.

Make a call to this endpoint to perform a NINO search:
* `POST http://localhost:10212/v1/status/public-funds/nino`
* set `Content-Type` header to `application/json`
* set request body to a valid JSON depending on the test scenario i.e. predefined or dynamic scenario.
  For example [Predefined Request Body Json](conf/jsons/ninoSearch/predefinedRequestBody.json) or [Dynamic Request Body Json](conf/jsons/ninoSearch/dynamicRequestBody.json)

or via a curl request replacing the content `PUT JSON BODY HERE`
with either [Predefined Request Body Json](conf/jsons/ninoSearch/predefinedRequestBody.json)
or [Dynamic Request Body Json](conf/jsons/ninoSearch/dynamicRequestBody.json) depending on the test scenario:
```
curl --location --request POST 'http://localhost:10212/v1/status/public-funds/nino' \
--header 'Content-Type: application/json' \
--data 'PUT JSON BODY HERE'
```

### MRZ or Document Search
`POST /v1/status/public-funds/mrz`

This endpoint is used to perform a MRZ search on the predefined stub test data and also create dynamic test data for MRZ searches.

For MRZ searches using the dynamic stubbing feature,
the document type can be any of the valid types,
the document number should be the dynamic identifier,
the nationality should be `AFG`, and the date of birth should be `2000-01-01`.

Make a call to this endpoint to perform a MRZ search:
* `POST http://localhost:10212/v1/status/public-funds/mrz`
* set `Content-Type` header to `application/json`
* set request body to a valid JSON depending on the test scenario i.e. predefined or dynamic scenario.
  For example [Predefined Request Body Json](conf/jsons/documentSearch/predefinedRequestBody.json) or [Dynamic Request Body Json](conf/jsons/documentSearch/dynamicRequestBody.json)

or via a curl request replacing the content `PUT JSON BODY HERE`
with either [Predefined Request Body Json](conf/jsons/documentSearch/predefinedRequestBody.json)
or [Dynamic Request Body Json](conf/jsons/documentSearch/dynamicRequestBody.json) depending on the test scenario:
```
curl --location --request POST 'http://localhost:10212/v1/status/public-funds/mrz' \
--header 'Content-Type: application/json' \
--data 'PUT JSON BODY HERE'
```

### License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html")
