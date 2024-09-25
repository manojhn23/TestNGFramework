package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ExtentReportManager {

    static ExtentReports reports;
    static ExtentTest test;
    static int i;

    public static void initReporter() {
        String path = System.getProperty("user.dir") + "\\src\\reports\\extentReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reports = new ExtentReports();
        reports.attachReporter(reporter);
    }

    public static void flush() {
        reports.flush();
    }

    public static void createTest(String name) {
        test = reports.createTest(name);
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void attachScreenshot() {
        test.addScreenCaptureFromPath(takeScreenshot());
    }

    public static String takeScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File file = ts.getScreenshotAs(OutputType.FILE);
        String path = "src\\test\\resources\\screenshots\\screenshot" + ++i + ".png";
        try {
            FileUtils.copyFile(file, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return System.getProperty("user.dir") + "\\" + path;
    }


}
