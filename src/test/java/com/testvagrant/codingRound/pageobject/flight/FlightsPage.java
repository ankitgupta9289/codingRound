package com.testvagrant.codingRound.pageobject.flight;

import com.testvagrant.codingRound.utils.ActionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class FlightsPage {

    private static FlightsPage _instance = null;
    private By oneWay_Rd = By.id("OneWay");
    private By fromCity_Txt = By.id("FromTag");
    private By firstTuple_AutoComplete_FromCity_We = By.xpath("(//ul[@id='ui-id-1']/li)[1]");
    private By toCity_Txt = By.id("ToTag");
    private By firstTuple_AutoComplete_ToCity_We = By.xpath("(//ul[@id='ui-id-2']/li)[1]");
    private By departureDate_WE = By.id("DepartDate");
    private By highlightedDate_Calendar_WE = By.xpath("//a[contains(@class,'ui-state-highlight')]");
    private By adults_Dd = By.id("Adults");
    private By searchFlights_Btn = By.id("SearchBtn");
    //private By month_Calendar_Lbl = By.xpath("//div[@class='monthBlock first']//span[@class='ui-datepicker-month']");
    //private By month_Calendar_Lbl = By.xpath("//div[@class='monthBlock first']//span[@class='ui-datepicker-month']");


    public static FlightsPage getInstance() {
        if (_instance == null)
            _instance = new FlightsPage();
        return _instance;
    }

    public void click_OneWay_Rd() {
        ActionHelper.click(oneWay_Rd);
    }

    public void fill_FromCity_Txt(String fromCity) {
        ActionHelper.fill(fromCity_Txt, fromCity);
    }

    public void click_FirstTuple_AutoComplete_FromCity_We() {
        ActionHelper.click(firstTuple_AutoComplete_FromCity_We);
    }

    public void fill_ToCity_Txt(String toCity) {
        ActionHelper.fill(toCity_Txt, toCity);
    }

    public void click_FirstTuple_AutoComplete_ToCity_We() {
        ActionHelper.click(firstTuple_AutoComplete_ToCity_We);
    }

    public void fill_DepartureDate_WE(String departureDate) {
        ActionHelper.click(departureDate_WE);
        ActionHelper.pressKey(departureDate_WE, Keys.ESCAPE);
        ActionHelper.fill(departureDate_WE, departureDate);
    }

    public void select_Adults_Dd(String adults) {
        ActionHelper.selectValueFromDropDown(adults_Dd, adults);
    }

    public void click_SearchFlights_Btn() {
        ActionHelper.click(searchFlights_Btn);
    }

    public void click_HighlightedDate_Calendar_WE() {
        ActionHelper.click(highlightedDate_Calendar_WE);
    }
}
