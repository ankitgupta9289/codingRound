package com.testvagrant.codingRound.pageobject.common;

import com.testvagrant.codingRound.utils.ActionHelper;
import org.openqa.selenium.By;

public class ClearTripHomePage {

    private static ClearTripHomePage _instance = null;
    private By hotelsLink_Lnk = By.linkText("Hotels");

    private ClearTripHomePage() {
    }

    public static ClearTripHomePage getInstance() {
        if (_instance == null)
            _instance = new ClearTripHomePage();
        return _instance;
    }

    public void click_HotelsLink_Lnk() {
        ActionHelper.click(hotelsLink_Lnk);
    }


}
