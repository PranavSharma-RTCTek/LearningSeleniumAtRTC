package com.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;

@Listeners({ TestListener.class, AllureTestNg.class })
public class BaseTest {

    protected WebDriver driver;
    protected ConfigReader configReader = new ConfigReader();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        driver = BrowserFactory.initDriver();
        driver.get(configReader.getBaseURL());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus() && driver != null
                && driver instanceof TakesScreenshot) {
            attachScreenshot("Test Failed - Screenshot");
            String path = ScreenshotUtils.captureScreenshot(driver,
                    result.getMethod().getMethodName());
            if (path != null) {
                FailureScreenshotHolder.setLastFailureScreenshot(path);
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @Attachment(value = "{screenshotName}", type = "image/png")
    public byte[] attachScreenshot(String screenshotName) {
        if (driver != null) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }
}