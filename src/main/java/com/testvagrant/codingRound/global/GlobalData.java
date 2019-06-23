package com.testvagrant.codingRound.global;

import com.testvagrant.codingRound.testdata.TestData;
import org.aeonbits.owner.ConfigFactory;

public class GlobalData {

    public static final int ELEMENT_TIMEOUT = 20;
    public static final int DEFAULT_IMPLICITWAIT = 20;
    public static final TestData TESTDATA;
    public static final String EXTENTREPORT_DOCUMENT_TITLE = "Automation Reports";
    public static final String EXTENTREPORT_REPORT_NAME = "ClearTrip";
    public static final String OUTPUT_FOLDER_REPORT = "extentreport/";
    public static final String OUTPUT_FOLDER_SCREENSHOTS = "screenshots/";
    public static final String REPORT_ENCODING = "utf-8";
    public static final String FILE_NAME_REPORT = "/extentreport.html";
    public static final String DRIVERTYPE = System.getProperty("drivertype", "chrome");
    public static final String ENVIRONMENT = System.getProperty("environment", "production");

    static {
        ConfigFactory.setProperty("env", GlobalData.ENVIRONMENT);
        TESTDATA = ConfigFactory.create(TestData.class);
    }
}
