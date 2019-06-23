package com.testvagrant.codingRound.logger;

import com.aventstack.extentreports.Status;
import com.testvagrant.codingRound.extentreports.ExtentManager;

public class Logger {

    public static void logInfo(String log) {
        if (ExtentManager.getTest().get() != null)
            ExtentManager.getTest().get().log(Status.INFO, log);
    }

    public synchronized static void logDebug(String log) {
        if (ExtentManager.getTest().get() != null)
            ExtentManager.getTest().get().log(Status.DEBUG, log);
    }

    public synchronized static void logPass(String log) {
        if (ExtentManager.getTest().get() != null)
            ExtentManager.getTest().get().log(Status.PASS, log);
    }
}
