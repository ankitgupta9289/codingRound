package com.testvagrant.codingRound.testsuite.base;

import com.testvagrant.codingRound.utils.GenericFunctions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestClass {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("--------------------- INSIDE BEFORE SUITE ---------------------");
        GenericFunctions.startDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("--------------------- INSIDE AFTER SUITE ---------------------");
        GenericFunctions.quitDriver();
    }

}
