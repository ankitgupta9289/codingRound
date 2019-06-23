package com.testvagrant.codingRound.pageobject.hotel;

import com.testvagrant.codingRound.pageobject.common.SRPPage;
import com.testvagrant.codingRound.utils.ActionHelper;
import org.openqa.selenium.By;

public class HotelsSRPPage extends SRPPage {

    private static HotelsSRPPage _instance = null;
    private By searchResultsTuples_We = By.xpath("//nav[@class='hotelsList']/ul/li");

    private HotelsSRPPage() {

    }

    public static HotelsSRPPage getInstance() {
        if (_instance == null)
            _instance = new HotelsSRPPage();
        return _instance;
    }

    public boolean isPresent_SearchResultsTuples_We() {
        return ActionHelper.isPresentWithWait(searchResultsTuples_We);
    }

}
