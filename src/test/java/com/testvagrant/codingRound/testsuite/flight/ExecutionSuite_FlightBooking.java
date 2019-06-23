package com.testvagrant.codingRound.testsuite.flight;

import com.testvagrant.codingRound.assertion.CustomAssert;
import com.testvagrant.codingRound.global.GlobalData;
import com.testvagrant.codingRound.pageobject.common.SRPPage;
import com.testvagrant.codingRound.pageobject.flight.FlightsPage;
import com.testvagrant.codingRound.pageobject.flight.FlightsSRPPage;
import com.testvagrant.codingRound.testsuite.base.BaseTestClass;
import org.testng.annotations.Test;

public class ExecutionSuite_FlightBooking extends BaseTestClass {

    @Test(groups = {"sanity,flight"}, description = "To verify that flights results are shown on SRP page in flight booking one way journey flow")
    public void tc_Flight_001_Verify_ResultsAppearForAOneWayJourney() {
        FlightsPage flightsPage = FlightsPage.getInstance();
        flightsPage.click_OneWay_Rd();
        flightsPage.fill_FromCity_Txt(GlobalData.TESTDATA.FLIGHT_FROMCITY());
        flightsPage.click_FirstTuple_AutoComplete_FromCity_We();
        flightsPage.fill_ToCity_Txt(GlobalData.TESTDATA.FLIGHT_TOCITY());
        flightsPage.click_FirstTuple_AutoComplete_ToCity_We();
        flightsPage.fill_DepartureDate_WE(GlobalData.TESTDATA.FLIGHT_DEPARTUREDATE());
        flightsPage.select_Adults_Dd(GlobalData.TESTDATA.FLIGHT_NOOFADULTS());
        flightsPage.click_SearchFlights_Btn();
        SRPPage srpPage = FlightsSRPPage.getInstance();
        CustomAssert.assertTrue(srpPage.isPresent_SearchSummary_Lbl(), "Check visibility of search summary label on SRP");
        CustomAssert.assertTrue(srpPage.isPresent_SearchResultsTuples_We(), "Check results are displayed on SRP");
    }

}
