package com.pack.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReports5 {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		ExtentReports extent = new ExtentReports();
		File file = new File("ExtentReports5.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		extent.attachReporter(spark);
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
		driver.get("https://www.youtube.com/watch?v=YxWlaYCA8MU");
		
		extent
		.createTest("Test 1")
		.assignAuthor("Shaikshavali")
		.assignCategory("Smoke")
		.assignDevice("Chrome 144")
		.pass("This is a passed test");
		
		extent
		.createTest("Test 2", "Test desc")
		.assignAuthor("Vali")
		.assignCategory("Sanity")
		.assignDevice("Edge 144")
		.fail("This is a failed test");
		
		extent
		.createTest("Test 3", "Test desc")
		.assignDevice("Firefox 144")
		.assignCategory("Regression")
		.assignAuthor("Zubeda")
		.fail("This is a failed test");
		
		extent
		.createTest("Test 4", "Test desc")
		.assignDevice("Firefox 144")
		.assignDevice("Firefox 134")
		.assignCategory("Regression")
		.assignCategory("Smoke")
		.assignAuthor("Zubeda")
		.assignAuthor("Shaikshavali")
		.pass("This is a passed test");
		
		extent
		.createTest("Test 5", "Test desc")
		.assignDevice("Firefox 100","Chrome 90")
		.assignCategory("Regression","Sanity","Smoke")
		.assignAuthor("Zubeda","Vali","Amira")
		.pass("This is a passed test");
		
		extent
		.createTest("Test 6", "Test desc")
		.assignDevice(new String[] {"Firefox 100","Chrome 90"})
		.assignCategory("Regression","Sanity")
		.assignAuthor(new String[] {"Zubeda","Vali","Amira"})
		.pass("This is a passed test");
		
		extent.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("ExtentReports5.html").toURI());

	}
}
		
	
