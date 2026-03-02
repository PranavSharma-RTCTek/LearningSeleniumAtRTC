package com.example.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = BrowserFactory.getDriver();
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitDriver();
    }
}