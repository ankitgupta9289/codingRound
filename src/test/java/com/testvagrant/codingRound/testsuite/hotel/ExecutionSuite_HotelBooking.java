package com.testvagrant.codingRound.testsuite.hotel;

import com.testvagrant.codingRound.global.GlobalData;
import com.testvagrant.codingRound.pageobject.common.ClearTripHomePage;
import com.testvagrant.codingRound.pageobject.hotel.HotelsPage;
import com.testvagrant.codingRound.testsuite.base.BaseTestClass;
import com.testvagrant.codingRound.utils.ActionHelper;
import org.testng.annotations.Test;

public class ExecutionSuite_HotelBooking extends BaseTestClass {

    @Test(groups = {"sanity,login"}, description = "To verify that hotel results are shown on SRP page in hotel booking flow")
    public void tc_Hotel_001_VerifyVisibility_SearchResults_SearchHotelsFlow() {
        String locality = "Indiranagar, Bangalore";
        String occupancyDetails = "1 room, 2 adults";
        ActionHelper.openURL(GlobalData.URL_CLEARTRIP);
        ClearTripHomePage clearTripHomePage = ClearTripHomePage.getInstance();
        clearTripHomePage.click_HotelsLink_Lnk();
        HotelsPage hotelsPage = HotelsPage.getInstance();
        hotelsPage.fill_Locality_Txt(locality);
        hotelsPage.click_AuoSuggestTuple_We(locality);
        hotelsPage.select_Travellers_Dd(occupancyDetails);
        hotelsPage.click_SearchHotels_Btn();
    }
}
