package com.testvagrant.codingRound.testdata;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:src/main/resources/testdata/${env}/Testdata.properties"
})
public interface TestData extends Config {

    String FLIGHT_FROMCITY();

    String FLIGHT_TOCITY();

    String FLIGHT_DEPARTUREDATE();

    String FLIGHT_NOOFADULTS();

    String LOGIN_ERRORMSG();

    String HOTEL_LOCALITY();

    String HOTEL_OCCUPANCYDETAILS();
}
