package com.testvagrant.codingRound.global;

import com.testvagrant.codingRound.testdata.TestData;
import org.aeonbits.owner.ConfigFactory;

public class GlobalData {

    public static final int ELEMENT_TIMEOUT = 20;
    public static final int DEFAULT_IMPLICITWAIT = 20;
    public static final String URL_CLEARTRIP = "https://www.cleartrip.com/";
    public static final TestData TESTDATA = ConfigFactory.create(TestData.class);
    public static final String EXTENTREPORT_DOCUMENTTITLE = "Automation Reports";
    public static final String EXTENTREPORT_REPORTNAME = "ExtentReports";
    public static final String OUTPUT_FOLDER_REPORT = "extentreport/";
    public static final String OUTPUT_FOLDER_SCREENSHOTS = "screenshots/";
    public static final String REPORT_ENCODING = "utf-8";
    public static final String FILE_NAME_REPORT = "/extentreport.html";
    public static String driverType = System.getProperty("drivertype", "Chrome");
}
