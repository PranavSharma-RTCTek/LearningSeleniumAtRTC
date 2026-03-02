package com.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // default to Chrome; can be extended to read from properties
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-gpu");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}