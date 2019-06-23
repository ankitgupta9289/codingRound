package com.testvagrant.codingRound.utils;

import com.testvagrant.codingRound.extentreports.ExtentManager;
import com.testvagrant.codingRound.global.GlobalData;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

public class GenericFunction {

    public static synchronized void initDrivers() {
        DriverManager.startDriver();
    }

    public static synchronized void initExtentReports() {
        ExtentManager.createInstance();
    }

    public synchronized static void initDirectories() {
        try {
            File reportDirectory = new File(GlobalData.OUTPUT_FOLDER_REPORT);
            FileUtils.forceMkdir(reportDirectory);
            FileUtils.cleanDirectory(reportDirectory);
            File screenshotsDirectory = new File(GlobalData.OUTPUT_FOLDER_REPORT + GlobalData.OUTPUT_FOLDER_SCREENSHOTS);
            FileUtils.forceMkdir(screenshotsDirectory);
            FileUtils.cleanDirectory(screenshotsDirectory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void addExecutionDetailsExtentReport() {
        ExtentManager.addSystemInfo("Environment", StringUtils.capitalize(GlobalData.ENVIRONMENT));
        ExtentManager.addSystemInfo("DriverType", StringUtils.capitalize(GlobalData.DRIVERTYPE));
    }

    public static synchronized void quitDrivers() {
        DriverManager.getDriver().quit();
    }
}
