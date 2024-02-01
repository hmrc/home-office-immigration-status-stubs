# Home Office Immigration Status Stubs

Stub data for the Check Immigration Status service.

## Running the tests
```shell
./run_all_tests.sh
```

## Running the app locally
```shell
sm2 --start HOME_OFFICE_IMMIGRATION_STATUS_ALL
```
OR
```shell
    sm2 --start HOME_OFFICE_IMMIGRATION_STATUS_ALL
    sm2 --stop HOME_OFFICE_IMMIGRATION_STATUS_STUBS
    sbt run
```

It should then be listening on port 10212

    browse http://localhost:10212/

## Dynamic Stubbing
This stub has dynamic stubbing functionality which allows the user to test certain product types and immigration statuses 
without having to add new data to the stub. The product type and immigration status entered will be returned as both the 
current status and the previous status to allow testing of all content for this combination.

#### Dynamic stub identifier
The dynamic identifier should be constructed using the following pattern:
`MAKE-[Product type]-[Immigration status](-EX)`

Underscores in either the product type or immigration status should be replaced by two dashes `--`

The `-EX` parameter is optional and defines if the most recent status is expired

So for example:
- if you want to return data where the individual's statuses have the product type `EUS` and immigration status `LTR` 
and were not expired, the dynamic identifier would be `MAKE-EUS-LTR`
- for product type `WORK` and immigration status `LTE` with an expired status, the dynamic identifier would be `MAKE-WORK-LTE-EX`
- and for product type `EUS_JFM` and immigration status `ILR`, the dynamic identifier would be `MAKE-EUS--JFM-ILR`


#### Endpoints

The use of this functionality differs slightly between the Nino search and the document search endpoints.

For nino searches, the nino should be a nino not defined in the stub such as `AA123456A`, the givenName should be the dynamic identifier, 
the familyName should be `Make` and the dob should be `01/01/2000`.

For MRZ searches, the document type can be any type, the documentNumber should be the dynamic identifier, the nationality should 
be `Afghanistan`, and the dob should be `01/01/2000`.

The documentNumber field is shorter than the name field of the Nino search so may not allow a string as long as the example to be used.



### License


This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html")


