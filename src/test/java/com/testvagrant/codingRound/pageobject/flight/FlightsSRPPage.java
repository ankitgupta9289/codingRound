package com.testvagrant.codingRound.pageobject.flight;

import com.testvagrant.codingRound.utils.ActionHelper;
import org.openqa.selenium.By;

public class FlightsSRPPage {

    private static FlightsSRPPage _instance = null;
    private By searchResultsTuples_We = By.xpath("//ul[@class='listView flights']/li");

    public static FlightsSRPPage getInstance() {
        if (_instance == null)
            _instance = new FlightsSRPPage();
        return _instance;
    }

    public boolean isPresent_SearchResultsTuples_We() {
        return ActionHelper.isPresentWithWait(searchResultsTuples_We);
    }
}
