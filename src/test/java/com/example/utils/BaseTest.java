package com.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Attachment;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader configReader = new ConfigReader();

    @BeforeMethod
    public void setUp() throws Exception {
        driver = BrowserFactory.initDriver();
        driver.get(configReader.getBaseURL());
		 attachScreenshot("Base URL Loaded Successfully");

    }
    
    @Attachment(value = "{stepName}", type = "image/png")
    public byte[] attachScreenshot(String stepName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /*
    @AfterClass
    public void tearDown() {
        BrowserFactory.quitDriver();
    }
    */
    
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            saveFailureScreenshot();
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveFailureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}