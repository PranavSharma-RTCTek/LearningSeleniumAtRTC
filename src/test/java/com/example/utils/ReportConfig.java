package com.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportConfig {
    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
            String reportPath = "test-reports/ExtentReport_" + timestamp + ".html";
            
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setReportName("Selenium Test Report");
            sparkReporter.config().setDocumentTitle("Test Automation Results");
            
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester", "QA Team");
            extent.setSystemInfo("Environment", "Production");
        }
        return extent;
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
