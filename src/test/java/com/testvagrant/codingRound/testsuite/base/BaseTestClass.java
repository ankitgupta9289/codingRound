package com.testvagrant.codingRound.testsuite.base;

import com.testvagrant.codingRound.listeners.TestNGReportListener;
import com.testvagrant.codingRound.utils.DriverManager;
import com.testvagrant.codingRound.utils.GenericFunction;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(TestNGReportListener.class)
public class BaseTestClass {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("--------------------- INSIDE BEFORE SUITE ---------------------");
        GenericFunction.initDirectories();
        GenericFunction.initExtentReports();
        GenericFunction.initDrivers();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("--------------------- INSIDE AFTER SUITE ---------------------");
        DriverManager.quitDriver();
    }

}
