package com.pack.testng.examples;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametersTest {
	
	WebDriver driver;
	
	@Parameters("browserName")
	@BeforeTest
	public void InitialiseBrowser(String browserName) {
		switch(browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;	
		default:
			System.out.println("Browser is invalid");
			break;
		}
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
	}
	
	
//	@AfterTest
//	public void Teardown() {
//		driver.quit();
//	}
	
	
	@Parameters("url")
	@Test
	public void LaunchApp(String url) {
		driver.get(url);
	}
	
	@Test
	public void NavigateToMyInfo() {
		//driver.findElement(By.xpath("//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6']"));
		driver.findElement(By.xpath("//span[text()='Friends']")).click();
	}
	
	@Test
	public void HandleAlert() {
	System.out.println(driver.findElement(By.xpath("//div[@class='x1uvtmcs x4k7w5x x1h91t0o x1beo9mf xaigb6o x12ejxvf x3igimt xarpa2k xedcshv x1lytzrv x1t2pt76 x7ja8zs x1n2onr6 x1qrby5j x1jfb8zj']")).getText());
	driver.findElement(By.id("alertBox")).click();
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().accept();
	//System.out.println(driver.findElement(By.id("output")).getText());
	}
	
	@Test
	public void SeeFriendRequests() {
		driver.findElement(By.xpath("//span[text()='Friend requests']")).click();
	}
	
	@Test
	public void EnterLoginDetails() throws Exception {
		driver.findElement(By.id("email")).sendKeys("9959380509");
		driver.findElement(By.id("pass")).sendKeys("Ahmedmiah@6");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	
//	@Test
//	public void VerifyLogin() {
//		WebElement element = driver.findElement(By.id("facebook"));
//		System.out.println(element.isDisplayed());
//		assertTrue(element.isDisplayed());
//		assertTrue(element.getText().startsWith("Facebook"));
//		
//	}


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
