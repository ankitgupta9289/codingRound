package com.testvagrant.codingRound.pageobject.hotel;

import com.testvagrant.codingRound.logger.Logger;
import com.testvagrant.codingRound.utils.ActionHelper;
import com.testvagrant.codingRound.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelsPage {

    private static HotelsPage _instance = null;
    String autoSuggestTuples_We = "//ul[@id='ui-id-1']//a[contains(text(),'xyz')]";
    @FindBy(id = "Tags")
    private WebElement locality_Txt;
    @FindBy(id = "SearchHotelsButton")
    private WebElement search_Btn;
    @FindBy(id = "travellersOnhome")
    private WebElement travellers_dd;
    @FindBy(xpath = "//h1[text()='Search for hotels']")
    private WebElement searchForHotels_Lbl;

    public static HotelsPage getInstance() {
        if (_instance == null)
            _instance = PageFactory.initElements(DriverManager.getDriver(), HotelsPage.class);
        Logger.logPass("On Hotel Booking Page");
        return _instance;
    }

    public void fill_Locality_Txt(String locality) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(locality_Txt)).sendKeys(locality);
    }

    public void click_AuoSuggestTuple_We(String locality) {
        By by = By.xpath(autoSuggestTuples_We.replace("xyz", locality));
        ActionHelper.click(by);
    }

    public void click_SearchHotels_Btn() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(search_Btn)).click();
        //search_Btn.click();
    }

    public void click_SearchForHotels_Lbl() {
        searchForHotels_Lbl.click();
    }

    public void select_Travellers_Dd(String travellers) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(travellers_dd));
        new Select(travellers_dd).selectByVisibleText(travellers);
    }
}
