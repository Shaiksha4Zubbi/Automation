package com.pack.testng.examples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationsTest {
	
	WebDriver driver;
	@BeforeTest
	public void InitialiseBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
//	@AfterTest
//	public void Teardown() {
//		driver.quit();
//	}
	
	boolean actualValue = driver.findElement(By.xpath("//span[text()='Friend requests']")).isDisplayed();
	
	@Test
	public void LaunchApp() {
		driver.get("https://facebook.com");
	}
	
	@Test
	public void EnterLoginDetails() throws Exception {
		driver.findElement(By.id("email")).sendKeys("9959380509");
		driver.findElement(By.id("pass")).sendKeys("Ahmedmiah@6");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
	}
	
	@Test
	public void VerifyLogin() {
		WebElement element = driver.findElement(By.id("facebook"));
		System.out.println(element.isDisplayed());
		System.out.println(element.getText());
	}


	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}

}
