package com.testvagrant.codingRound.assertion;

import com.testvagrant.codingRound.logger.Logger;
import org.testng.Assert;

import java.util.List;

public class CustomAssert {
    private List<Throwable> m_errors;

    private CustomAssert() {
    }

    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
        Logger.logInfo(message + " = <b>Pass</b>");
    }

    public static void assertEquals(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
        String str = message + "<br><b>Actual : </b>" + actual + "<br><b>Expected : </b>" + expected;
        Logger.logInfo(str);
    }

    public static void assertContains(String completeString, String subString, String message) {
        String str = message + "<br><b>Complete String : </b>" + completeString + "<br><b>Substring : </b>" + subString;
        String errorMessage = message + " -- \nComplete String : " + completeString + "\nSubstring : " + subString + "\n\n";
        Assert.assertTrue(completeString.contains(subString), errorMessage);
        Logger.logInfo(str);
    }


}
