package com.testvagrant.codingRound.utils;

import com.testvagrant.codingRound.global.GlobalData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class GenericFunctions {

    public static void startDriver() {
        WebDriver driver = null;

        if (GlobalData.driverType.equalsIgnoreCase("Chrome")) {
            System.out.println("--------Starting Chrome Driver-------");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        if (GlobalData.driverType.equalsIgnoreCase("Firefox")) {
            System.out.println("--------Starting Firefox Driver-------");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(GlobalData.DEFAULT_IMPLICITWAIT, TimeUnit.SECONDS);
        DriverManager.setDriver(driver);
    }

    public static void quitDriver() {
        DriverManager.getDriver().quit();
    }
}
