package com.example.stepdefinitions;

import com.example.utils.BrowserFactory;
import com.example.utils.ScreenshotUtils;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

/**
 * Cucumber Hooks for setup and teardown
 * Handles scenario setup, teardown, and screenshot capture on failure
 */
public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario) throws Exception {
        System.out.println("========================================");
        System.out.println("Starting scenario: " + scenario.getName());
        System.out.println("========================================");
        
        // Initialize WebDriver
        driver = BrowserFactory.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("SCENARIO FAILED: " + scenario.getName());
            
            // Capture screenshot on failure
            String screenshotPath = ScreenshotUtils.captureScreenshot(
                    driver,
                    scenario.getName()
            );
            if (screenshotPath != null) {
                System.out.println("Screenshot captured at: " + screenshotPath);
            }
        } else {
            System.out.println("SCENARIO PASSED: " + scenario.getName());
        }
        
        // Quit WebDriver
        BrowserFactory.quitDriver();
        
        System.out.println("========================================\n");
    }
}
