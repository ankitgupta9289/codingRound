package com.testvagrant.codingRound.pageobject.flight;

import com.testvagrant.codingRound.pageobject.common.SRPPage;
import com.testvagrant.codingRound.utils.ActionHelper;
import org.openqa.selenium.By;

public class FlightsSRPPage extends SRPPage {

    private static FlightsSRPPage _instance = null;
    private By searchResultsTuples_We = By.xpath("//ul[@class='listView flights']/li");

    private FlightsSRPPage() {

    }

    public static FlightsSRPPage getInstance() {
        if (_instance == null)
            _instance = new FlightsSRPPage();
        return _instance;
    }

    public boolean isPresent_SearchResultsTuples_We() {
        return ActionHelper.isPresentWithWait(searchResultsTuples_We);
    }
}
