package com.payments.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentSparkReporter reporter;
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		String TestStamp=new SimpleDateFormat("yyyy-mm-dd-hh-ms-ss").format(new Date());
		String filename="Test-Report-"+TestStamp+".html";
		String path=System.getProperty("user.dir")+ "\\Reports\\"+filename;
		reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Test Report");
		reporter.config().setDocumentTitle("Automation Test Report");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Surya Pal");	
		
		return extent;		
	}
}
