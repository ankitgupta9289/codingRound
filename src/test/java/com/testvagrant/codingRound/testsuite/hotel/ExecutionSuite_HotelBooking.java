package com.testvagrant.codingRound.testsuite.hotel;

import com.testvagrant.codingRound.assertion.CustomAssert;
import com.testvagrant.codingRound.global.GlobalData;
import com.testvagrant.codingRound.pageobject.common.ClearTripHomePage;
import com.testvagrant.codingRound.pageobject.common.SRPPage;
import com.testvagrant.codingRound.pageobject.hotel.HotelsPage;
import com.testvagrant.codingRound.pageobject.hotel.HotelsSRPPage;
import com.testvagrant.codingRound.testsuite.base.BaseTestClass;
import org.testng.annotations.Test;

public class ExecutionSuite_HotelBooking extends BaseTestClass {

    @Test(groups = {"sanity,hotel"}, description = "To verify that hotel results are shown on SRP page in hotel booking flow")
    public void tc_Hotel_001_VerifyVisibility_SearchResults_SearchHotelsFlow() {
        ClearTripHomePage clearTripHomePage = ClearTripHomePage.getInstance();
        clearTripHomePage.click_HotelsLink_Lnk();
        HotelsPage hotelsPage = HotelsPage.getInstance();
        hotelsPage.fill_Locality_Txt(GlobalData.TESTDATA.HOTEL_LOCALITY());
        hotelsPage.click_AuoSuggestTuple_We(GlobalData.TESTDATA.HOTEL_LOCALITY());
        hotelsPage.click_SearchForHotels_Lbl();
        hotelsPage.select_Travellers_Dd(GlobalData.TESTDATA.HOTEL_OCCUPANCYDETAILS());
        hotelsPage.click_SearchHotels_Btn();
        SRPPage srpPage = HotelsSRPPage.getInstance();
        CustomAssert.assertTrue(srpPage.isPresent_SearchSummary_Lbl(), "Check visibility of search summary label on SRP");
        CustomAssert.assertTrue(srpPage.isPresent_SearchResultsTuples_We(), "Check results are displayed on SRP hotels flow");
    }
}
