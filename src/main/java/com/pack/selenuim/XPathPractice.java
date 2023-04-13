package com.pack.selenuim;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathPractice {
	public static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

		// XPath with operators
		driver.findElement(By.xpath("//input[@maxlength=10]")).sendKeys("Text");
		driver.findElement(By.xpath("//input[@maxlength!=10]")).sendKeys("Text2");

		
		// XPath with index
		highlight(driver, driver.findElement(By.xpath("//table[@id='contactList']/tbody/tr[2]")));

		highlight(driver, driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr/td)[23]")));

		// Xpath with text function
		highlight(driver, driver.findElement(By.xpath("//a[text()='Sign in']")));
		highlight(driver, driver.findElement(By.xpath("//label[text()='Email']")));
		highlight(driver, driver.findElement(By.xpath("//h1[text()='Register']")));

		// xpath with contains funtion and with attribute
		// highlight(driver,
		// driver.findElement(By.xpath("//a[contains(text(),'account')]")));
		// highlight(driver,
		// driver.findElement(By.xpath("//div[contains(@class,'signin')]")));

		// xpath with starts-with funtion and with attribute
		highlight(driver, driver.findElement(By.xpath("//a[starts-with(text(),'Sign in into')]")));

		// xpath with normalize-space funtion and with attribute
		highlight(driver, driver.findElement(By.xpath("//label[normalize-space(text())='First Name']")));

		// xpath with last funtion and with attribute
		highlight(driver, driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr)[last()]")));

		// xpath with position funtion and with attribute
        System.out.println(driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr)[position()>=6]")).getSize());

		
		
		
		
		
		// List<WebElement> elements =
		// driver.findElement(By.xpath("//input[@maxlength<=16]"));
//		for(WebElement element : elements) {
//			highlight(driver, element);
//		}
		// chapter4();
		// chapter3();
//		driver.get("https://www.w3schools.com/");
//
//		// absolute xpath
//		driver.findElement(By.xpath("/html/body/div[3]/a[4]"));
//
//		// Relative xpath
//		highlight(driver, driver.findElement(By.xpath("//a[@title='Exercises']")));
//		highlight(driver, driver.findElement(By.xpath("//a[@id='navbtn_references']")));
//		driver.findElement(By.xpath("//a[@title=\"Search W3Schools\"]")).click();
//		
		// XPath Operators

	}

	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')",
				element);

	}

	// Types of xpath
//	public static void chapter2() {
//		driver.get("https://www.w3schools.com");
//		// Absolute Xpath
//		// highlight(driver.findElement(By.xpath("/html/body/div[3]/a[4]")));
//
//		// Relative Xpath
//		highlight(driver.findElement(By.xpath("//a[@title='Exercises']")));	
//	}

	// Xpath using attribute
//	public static void chapter3() {
//		driver.get("https://www.w3schools.com/");
//		highlight(driver.findElement(By.xpath("//a[@id='navbtn_references']")));
//		driver.findElement(By.xpath("//a[@title=\"Search W3Schools\"]"));
//		}

//	  public static void chapter4() {
//		  driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
//		  driver.findElement(By.xpath("//input[@maxlength=10]"));
//	  }
}
