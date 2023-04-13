package com.pack.testng.examples;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

//	@Test
//	public void TestGoogle() throws Exception {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com/");
//		driver.findElement(By.name("q")).sendKeys("HYR Tutorials", Keys.ENTER);
//		String expectedTitle = "HYR Tutorials - Google search";
//		String actualTitle = driver.getTitle();
//		assertEquals(actualTitle, expectedTitle, "Title is mismatched");
//		assertTrue(false);
//		Thread.sleep(3000);
//
//		driver.quit();
//	}

	@Test
	public void TestFacebook() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		SoftAssert softAssert = new SoftAssert();
		
		//Title assertion
		String actualTitle = driver.getTitle();
		String expectedTitle =  "Facebook - log in or sign up";
		softAssert.assertEquals(actualTitle, expectedTitle, "Title is mismatched");
		
		//URL assertion
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl =  "https://www.facebook.com/45";
		softAssert.assertNotEquals(actualUrl, expectedUrl, "Url is mismatched");
		
		//Text assertion
		String actualText = driver.findElement(By.id("email")).getAttribute("value");
		String expectedText =  "";
		assertEquals(actualText, expectedText, "Username text is mismatched");
		
		//Border assertion
		String actualBorder = driver.findElement(By.id("email")).getAttribute("value");
		String expectedBorder =  "1px solid rgb(240, 40, 73)";
		softAssert.assertEquals(actualBorder, expectedBorder, "Border is mismatched");
		
		//Error msg
		String actualErrorMessage = driver.findElement(By.xpath("//input[@id='email']")).getText();
		String expectedErrorMessage =  "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		softAssert.assertEquals(actualText, expectedText, "Error message is mismatched");
		
		
		driver.findElement(By.id("email")).sendKeys("9959380509");
		driver.findElement(By.id("pass")).sendKeys("Ahmedmiah@6");
		driver.findElement(By.name("login")).click();
		
		//driver.quit();
		//softAssert.assertAll();
	}

}
