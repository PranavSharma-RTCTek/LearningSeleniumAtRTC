package com.example.utils;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
    private static WebDriver driver;
    private static ConfigReader configReader = new ConfigReader();

    public static WebDriver initDriver() throws Exception{
        String execution = configReader.getExecution();
        String browser = configReader.getBrowser();

        if (execution.equalsIgnoreCase("local")) {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-gpu");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
            } else {
                throw new Exception("Unsupported browser: " + browser);
            }
        } else if (execution.equalsIgnoreCase("remote")) {
            ChromeOptions options = new ChromeOptions();

            driver = new RemoteWebDriver(new URL(configReader.getGridUrl()), options);
            driver.manage().window().maximize();
        } else {
            throw new Exception("Unsupported execution type: " + execution);
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