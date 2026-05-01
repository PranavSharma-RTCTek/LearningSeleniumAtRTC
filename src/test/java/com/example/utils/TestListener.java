package com.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    ExtentReports extent = ReportConfig.getReportInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        FailureScreenshotHolder.clear();
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, result.getThrowable());

        // Screenshot is taken in BaseTest.tearDown before driver.quit(); path is stored here for Extent.
        String screenshotPath = FailureScreenshotHolder.takeLastFailureScreenshot();
        if (screenshotPath != null) {
            try {
                test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
            } catch (Exception e) {
                test.log(Status.WARNING, "Could not attach screenshot: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ReportConfig.flushReport();
    }
}
