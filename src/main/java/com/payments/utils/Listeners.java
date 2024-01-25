package com.payments.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class Listeners extends BaseClass implements ITestListener{
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ExtentTest test;	
	
	ThreadLocal<ExtentTest> extenttestlocal=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extenttestlocal.set(test);
	}
	
	public void onTestSuccess(ITestResult result) {
		extenttestlocal.get().log(Status.PASS, "Test Execution Passed");
	}
	
	public void onTestFailure(ITestResult result) {
		extenttestlocal.get().fail(result.getThrowable());

		try {
			driver=  (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		extenttestlocal.get().log(Status.FAIL, result.getMethod().getMethodName() + "Test Execution Failed.");
		String filepath=null;
		
		try {
			filepath = getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		extenttestlocal.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());		
		extenttestlocal.get().log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.RED));
	}
	
	public void onTestSkipped(ITestResult result) {
		extenttestlocal.get().skip(result.getMethod().getMethodName());
		extenttestlocal.get().log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}	
	
}
