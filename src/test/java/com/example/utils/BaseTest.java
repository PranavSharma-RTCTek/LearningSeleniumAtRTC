package com.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.qameta.allure.Attachment;

public class BaseTest {

    protected WebDriver driver;
    protected ConfigReader configReader = new ConfigReader();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        driver = BrowserFactory.initDriver();
        driver.get(configReader.getBaseURL());

        // Optional: screenshot after successful launch
        attachScreenshot("Base URL Loaded Successfully");
    }

    @Attachment(value = "{stepName}", type = "image/png")
    public byte[] attachScreenshot(String stepName) {
        if (driver != null) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        // Capture screenshot ONLY if failed
        if (ITestResult.FAILURE == result.getStatus()) {
            saveFailureScreenshot();
        }

        // Quit after screenshot
        if (driver != null) {
            driver.quit();
        }
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveFailureScreenshot() {
        if (driver != null) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }
}