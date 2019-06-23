package com.testvagrant.codingRound.utils;

import com.testvagrant.codingRound.global.GlobalData;
import com.testvagrant.codingRound.logger.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionHelper {

    public static void openURL(String url) {
        DriverManager.getDriver().get(url);
        Logger.logPass("Opening Url : " + url);
        gotoSleep(3000);
    }

    public static void quitDriver() {
        DriverManager.getDriver().quit();
        Logger.logPass("Closing Browser !!");
        gotoSleep(1000);
    }

    public static void gotoSleep(int miliSeconds) {
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void click(By by) {
        try {
            findElement(by).click();
            Logger.logPass("Click with Selenium on = " + getCallingMethodName());
        } catch (Exception e) {
            clickJS(by);
            Logger.logPass("Click with Javascript on = " + getCallingMethodName());
        }
    }

    public static void clickJS(By by) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", findElement(by));
    }


    public static void setImplicitWait(int seconds) {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void waitUntilElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), GlobalData.ELEMENT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement findElement(By by) {
        waitUntilElementVisible(by);
        return DriverManager.getDriver().findElement(by);
    }

    public static List<WebElement> findElements(By by) {
        waitUntilElementVisible(by);
        return DriverManager.getDriver().findElements(by);
    }

    public static void fill(By by, String input) {
        if (input.length() < 1)
            return;
        findElement(by).click();
        findElement(by).sendKeys(input);
        Logger.logPass("Fill Text Box = " + getCallingMethodName() + ", with value = " + input);
    }

    public static void selectValueFromDropDown(By by, String value) {
        Select select = new Select(findElement(by));
        select.selectByVisibleText(value);
    }

    public static boolean isPresent(By by) {
        boolean flag = false;
        WebDriver driver = DriverManager.getDriver();
        ActionHelper.setImplicitWait(0);
        if (driver.findElements(by).size() > 0) {
            if (driver.findElement(by).isDisplayed()) {
                flag = true;
            }
        }
        ActionHelper.setImplicitWait(GlobalData.DEFAULT_IMPLICITWAIT);
        return flag;
    }

    public static boolean isPresentWithWait(By by) {
        WebDriver driver = DriverManager.getDriver();
        try {
            waitUntilElementVisible(by);
        } catch (Exception e) {

        }
        setImplicitWait(0);
        if (driver.findElements(by).size() > 0 && driver.findElement(by).isDisplayed()) {
            return true;
        } else {
            setImplicitWait(GlobalData.DEFAULT_IMPLICITWAIT);
            return false;
        }
    }

    public static String getText(By by) {
        String text = findElement(by).getText();
        Logger.logPass("Fetching value of " + getCallingMethodName() + " [ " + text + " ]");
        return text;
    }

    public static void swtichToFrame(String frameId) {
        DriverManager.getDriver().switchTo().frame(frameId);
    }

    public static void pressKey(By by, Keys key) {
        findElement(by).sendKeys(key);
    }

    public static String getCallingMethodName() {
        String methodName;
        try {
            String str[] = Thread.currentThread().getStackTrace()[3].getMethodName().split("_");
            String newStr = "";
            for (int i = 0; i < str.length; i++) {
                if (i == 0 || i == str.length - 1)
                    continue;
                else
                    newStr = newStr + str[i] + "_";
            }

            methodName = newStr.substring(0, newStr.length() - 1);
        } catch (Exception e) {
            methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        }
        return methodName;
    }
}
