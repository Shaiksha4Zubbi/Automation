package com.pack.selenuim;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScreenShots {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		
		//File
		
//		File sourceFile = driver.getScreenshotAs(OutputType.FILE);
//		File destFile = new File("C:\\Users\\DELL\\Desktop\\vali\\img.jpg");
//		FileUtils.copyFile(sourceFile, destFile);
//		System.out.println("Screenshot saved successfully");
		
		//Byte Array
//		byte[] byteArr = driver.getScreenshotAs(OutputType.BYTES);
//		File destFile1 = new File("C:\\Users\\DELL\\Desktop\\vali\\img.jpg");
//		FileOutputStream fos = new FileOutputStream(destFile1);
//		fos.write(byteArr);
//		fos.close();
//		System.out.println("Screenshot saved successfully");
		
		//Base64
		String base64code = driver.getScreenshotAs(OutputType.BASE64);
		byte[] byteArr = Base64.getDecoder().decode(base64code);
		File destFile1 = new File("C:\\Users\\DELL\\Desktop\\vali\\img2.jpg");
		FileOutputStream fos = new FileOutputStream(destFile1);
		fos.write(byteArr);
		fos.close();
		System.out.println("Screenshot saved successfully");
		driver.quit();
	}

}