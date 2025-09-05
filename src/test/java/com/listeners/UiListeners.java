package com.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utils.TestUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UiListeners implements ITestListener {

    ExtentReports extentReports;
    ExtentSparkReporter extentSparkReporter;
    ExtentTest extentTest;

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    @Override
    public void onStart(ITestContext context) {
        try {
            extentReports = new ExtentReports();
            File reportFolder = new File(System.getProperty("user.dir") + "/reports");
            LocalDate date = LocalDate.now();
            String formatedDate = date.format(DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm"));
            if (reportFolder.exists()) {
                FileUtils.forceDelete(reportFolder);
                FileUtils.forceMkdir(reportFolder);
            } else FileUtils.forceMkdir(reportFolder);
            extentSparkReporter = new ExtentSparkReporter(reportFolder + "/report-" + formatedDate);
            extentReports.attachReporter(extentSparkReporter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        extentTest.addScreenCaptureFromPath(TestUtil.takeScreenshots(driver));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }
}
