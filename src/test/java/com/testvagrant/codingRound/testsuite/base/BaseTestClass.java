package com.testvagrant.codingRound.testsuite.base;

import com.testvagrant.codingRound.utils.DriverManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestClass {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("--------------------- INSIDE BEFORE SUITE ---------------------");
        DriverManager.startDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("--------------------- INSIDE AFTER SUITE ---------------------");
        DriverManager.quitDriver();
    }

}
