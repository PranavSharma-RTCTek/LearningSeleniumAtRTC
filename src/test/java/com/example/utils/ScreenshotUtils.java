package com.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    
    public static String captureScreenshot(WebDriver driver, String testName) {
        try {
            // Create screenshots directory
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
            String screenshotPath = "test-reports/screenshots/" + testName + "_" + timestamp + ".png";
            
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotPath);
            
            // Create directories if they don't exist
            destFile.getParentFile().mkdirs();
            
            FileUtils.copyFile(srcFile, destFile);
            return screenshotPath;
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }
}
