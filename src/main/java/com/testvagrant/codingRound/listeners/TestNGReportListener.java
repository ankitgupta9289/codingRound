package com.testvagrant.codingRound.listeners;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.testvagrant.codingRound.extentreports.ExtentManager;
import com.testvagrant.codingRound.global.GlobalData;
import com.testvagrant.codingRound.utils.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNGReportListener implements ITestListener {

    @Override
    public synchronized void onStart(ITestContext context) {
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        addConsoleLogsToReport();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        ExtentManager.createTest(getSimpleMethodName(result), getTestDescription(result));
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        logStatusToConsole(result);
        assignCategoryToTest(result);
        addExtentLabelToTest(result);
        ExtentManager.flush();
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        logStatusToConsole(result);
        assignCategoryToTest(result);
        assignExceptionToTest(result);
        addScreenShotToReport(result);
        addExtentLabelToTest(result);
        ExtentManager.flush();
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        logStatusToConsole(result);
        assignCategoryToTest(result);
        assignExceptionToTest(result);
        addScreenShotToReport(result);
        addExtentLabelToTest(result);
        ExtentManager.flush();
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    private synchronized String takeScreenshot(WebDriver driver, String methodName) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("MMM_dd_yyyy_HH_mm_ss_SSS");
        Date date = new Date();
        String dateName = dateFormat.format(date);
        String filePathExtent = GlobalData.OUTPUT_FOLDER_SCREENSHOTS + methodName + "_" + dateName + ".png";
        String filePath = "./" + GlobalData.OUTPUT_FOLDER_REPORT + filePathExtent;
        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f, new File(filePath));
        return filePathExtent;
    }

    private synchronized void addScreenShotToReport(ITestResult result) {
        try {
            ExtentManager.getTest().get().addScreenCaptureFromPath(takeScreenshot(DriverManager.getDriver(), getSimpleMethodName(result)));
        } catch (Exception e) {
            System.out.println("XXXXX Unable to Capture Screenshot XXXXX");
            e.printStackTrace();
        }

    }

    private synchronized void logStatusToConsole(ITestResult result) {
        String status = "";

        if (result.getStatus() == ITestResult.SUCCESS)
            status = "Pass";

        else if (result.getStatus() == ITestResult.FAILURE)
            status = "Fail";

        else if (result.getStatus() == ITestResult.SKIP)
            status = "Skip";

        System.out.println(getSimpleMethodName(result) + " = [" + status + "]" + System.lineSeparator());
        Reporter.log(getSimpleMethodName(result) + " = [" + status + "]<br>");
    }

    private synchronized String getSimpleClassName(ITestResult result) {
        return result.getMethod().getRealClass().getSimpleName();
    }

    private synchronized String getSimpleMethodName(ITestResult result) {
        return result.getName();
    }

    private synchronized String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription();
    }

    private synchronized void assignCategoryToTest(ITestResult result) {
        ExtentManager.getTest().get().assignCategory(getSimpleClassName(result));
    }

    private synchronized void assignExceptionToTest(ITestResult result) {
        ExtentManager.getTest().get().debug(result.getThrowable());
    }

    private synchronized void addExtentLabelToTest(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS)
            ExtentManager.getTest().get().pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));

        else if (result.getStatus() == ITestResult.FAILURE)
            ExtentManager.getTest().get().fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));

        else
            ExtentManager.getTest().get().skip(MarkupHelper.createLabel("Test Skipped", ExtentColor.ORANGE));

    }

    private synchronized void addConsoleLogsToReport() {
        for (String s : Reporter.getOutput()) {
            ExtentManager.setTestRunnerOutput(s + System.lineSeparator());
        }
    }

}
