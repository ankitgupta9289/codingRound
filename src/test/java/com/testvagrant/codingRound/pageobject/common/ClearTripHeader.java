package com.testvagrant.codingRound.pageobject.common;

import com.testvagrant.codingRound.utils.ActionHelper;
import org.openqa.selenium.By;

public class ClearTripHeader {

    private static ClearTripHeader _instance = null;
    private By yourTrips_We = By.linkText("Your trips");
    private By logIn_Btn = By.id("SignIn");

    private ClearTripHeader() {

    }

    public static ClearTripHeader getInstance() {
        if (_instance == null)
            _instance = new ClearTripHeader();
        return _instance;
    }

    public void click_YourTrips_We() {
        ActionHelper.click(yourTrips_We);
    }

    public void click_LogIn_Btn() {
        ActionHelper.click(logIn_Btn);
    }
}
