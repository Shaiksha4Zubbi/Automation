package com.pack.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports1 {

	public static void main(String[] args) throws Exception {
		ExtentReports extent = new ExtentReports();
		File file = new File("ExtentReports.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		//ExtentSparkReporter spark = new ExtentSparkReporter("F:\\Automation\\MavenSeleniumProject\\ExtentReports.html");
		extent.attachReporter(spark);
		
		ExtentTest test1 = extent.createTest("Test1");
		test1.pass("This is passed");
		
		ExtentTest test2 = extent.createTest("Test2");
		test2.log(Status.FAIL, "Test2 is failed");
		
		extent.createTest("Test3").skip("Test3 is skipped");
		
		extent.flush();
		Desktop.getDesktop().browse(new File("ExtentReports.html").toURI());
	}

}
