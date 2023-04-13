package com.pack.reports;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports2 {

	public static void main(String[] args) throws Exception {
		ExtentReports extent = new ExtentReports();
		File file = new File("ExtentReports1.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		extent.attachReporter(spark);
		
		extent
		.createTest("Test 1")
		.log(Status.INFO, "info1")
		.log(Status.INFO, "info2")
		.log(Status.INFO, "info2")
		.log(Status.PASS, "pass");
		//.log(Status.WARNING, "warning")
		//.log(Status.WARNING, "warning");
		//.log(Status.SKIP, "skip");
		//.log(Status.FAIL, "fail");
		
		extent.flush();
		Desktop.getDesktop().browse(new File("ExtentReports1.html").toURI());
	}

}
