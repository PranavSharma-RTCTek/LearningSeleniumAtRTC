package com.example.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader configReader = new ConfigReader();

    @BeforeClass
    public void setUp() throws Exception {
        driver = BrowserFactory.initDriver();
        driver.get(configReader.getBaseURL());
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitDriver();
    }
}