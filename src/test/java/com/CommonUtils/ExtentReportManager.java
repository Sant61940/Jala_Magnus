package com.CommonUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test;

    public static ExtentReports getInstance(String reportPath) {
        if (extent == null) {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
            htmlReporter.config().setTheme(Theme.STANDARD);
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

    public static ExtentTest startTest(String testName) {
        test = new ThreadLocal<>();
        ExtentTest extentTest = extent.createTest(testName);
        test.set(extentTest);
        return extentTest; // Change the return type to ExtentTest
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void endTest() {
        extent.flush();
    }
}
