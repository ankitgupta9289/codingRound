package com.testvagrant.codingRound.global;

import com.testvagrant.codingRound.testdata.TestData;
import org.aeonbits.owner.ConfigFactory;

public class GlobalData {

    public static final int ELEMENT_TIMEOUT = 20;
    public static final int DEFAULT_IMPLICITWAIT = 20;
    public static final String URL_CLEARTRIP = "https://www.cleartrip.com/";
    public static final TestData TESTDATA = ConfigFactory.create(TestData.class);
    public static String driverType = System.getProperty("drivertype", "Chrome");
}
