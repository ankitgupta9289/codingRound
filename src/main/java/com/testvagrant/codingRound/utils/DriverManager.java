package com.testvagrant.codingRound.utils;

import com.testvagrant.codingRound.global.GlobalData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void startDriver() {
        WebDriver driver = null;

        if (GlobalData.DRIVERTYPE.equalsIgnoreCase("chrome")) {
            System.out.println("--------Starting Chrome Driver-------");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        if (GlobalData.DRIVERTYPE.equalsIgnoreCase("firefox")) {
            System.out.println("--------Starting Firefox Driver-------");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(GlobalData.DEFAULT_IMPLICITWAIT, TimeUnit.SECONDS);
        setDriver(driver);
    }

    public static void quitDriver() {
        DriverManager.getDriver().quit();
    }

}
