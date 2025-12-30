package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.generic.webdriverutility.UtilityClassObject;
import com.crm.comcast.baseutility.BaseClass;

public class ListenerImpClass implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		// Spark report config
		String currentTime = new Date().toString().replace(" ", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReport/report_"+currentTime+".html");
		spark.config().setDocumentTitle("CRM test Suite result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// Add Env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("=====>" + result.getMethod().getMethodName() + ">=====Start=====");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "=====>STARTED<=====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=====>" + result.getMethod().getMethodName() + ">=====End=====");
		test.log(Status.PASS, result.getMethod().getMethodName() + "=====>COMPLETED<=====");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot tks = (TakesScreenshot) BaseClass.sdriver;
		String filePath = tks.getScreenshotAs(OutputType.BASE64);

		String currentTime = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath, testName + "_" + currentTime);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "=====>FAILED<=====");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}
}
