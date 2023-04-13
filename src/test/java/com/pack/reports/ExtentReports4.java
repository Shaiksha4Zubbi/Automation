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

public class ExtentReports4 {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		ExtentReports extent = new ExtentReports();
		File file = new File("ExtentReports2.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		extent.attachReporter(spark);
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
		driver.get("https://www.youtube.com/watch?v=YxWlaYCA8MU");
		
		String base64Code = captureScreenshot();
		String path = captureScreenshot("youtube.jpg");
		
		extent
		.createTest("Screenshot Test1", "This is for attaching the screenshot to the test at text level")
		.info("This is a info msg")
		.addScreenCaptureFromBase64String(base64Code);
		
		extent
		.createTest("Screenshot Test2", "This is for attaching the screenshot to the test at text level")
		.info("This is a info msg")
		.addScreenCaptureFromBase64String(base64Code,"Pathan Song in Youtube")
		.addScreenCaptureFromBase64String(base64Code,"Pathan Song in Youtube1")
		.addScreenCaptureFromBase64String(base64Code,"Pathan Song in Youtube2")
		.addScreenCaptureFromBase64String(base64Code,"Pathan Song in Youtube3");
		
		extent
		.createTest("Screenshot Test3", "This is for attaching the screenshot to the test at text level")
		.info("This is a info msg")
		.addScreenCaptureFromPath(path);
		
		extent
		.createTest("Screenshot Test4", "This is for attaching the screenshot to the test at text level")
		.info("This is a info msg")
		.addScreenCaptureFromPath(path,"SRK Song");
		
		
		extent
		.createTest("Screenshot Test5", "This is for attaching the screenshot to the test at text level")
		.info("This is a info msg")
		.addScreenCaptureFromBase64String(base64Code,"Pathan Song in Youtube");
		
		
		extent
		.createTest("Screenshot Test6", "This is for attaching the screenshot to the test at text level")
		.info("This is a info msg")
		.addScreenCaptureFromPath(path,"SRK Song")
		.addScreenCaptureFromPath(path,"SRK Song")
		.addScreenCaptureFromPath(path,"SRK Song")
		.addScreenCaptureFromPath(path,"SRK Song");
		
		extent.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("ExtentReports2.html").toURI());

	}
	
	public static String captureScreenshot() {
		TakesScreenshot takesSceenshot = (TakesScreenshot) driver;
		String base64Code = takesSceenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println("Screenshot saved successfully");
		
		return base64Code;
	}
		
		public static String captureScreenshot(String fileName) {
			TakesScreenshot takesSceenshot = (TakesScreenshot) driver;
			File sourceFile = takesSceenshot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./Screenshots/"+fileName);
			try {
				FileUtils.copyFile(sourceFile, destFile);
			}catch(IOException e) {
				e.printStackTrace();
			}
			System.out.println("Screenshot saved successfully");
			return destFile.getAbsolutePath();
		}
}
		
	
