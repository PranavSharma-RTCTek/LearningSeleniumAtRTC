package com.example.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Cucumber Test Runner for BDD Feature Files
 * Runs all feature files and generates reports
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.stepdefinitions",
        plugin = {
                "pretty",
                "html:test-results/cucumber.html",
                "json:test-results/cucumber-report.json",
                "junit:test-results/cucumber.xml"
        },
        monochrome = false,
        dryRun = false,
        tags = ""  // Set tags here if needed like "@smoke and @login"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
    
    /**
     * Run scenarios in parallel
     */
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
