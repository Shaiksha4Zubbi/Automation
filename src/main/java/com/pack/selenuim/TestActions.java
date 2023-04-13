package com.pack.selenuim;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		driver.get("https://www.facebook.com/");
//		driver.findElement(By.name("username")).sendKeys("Admin");
//		driver.findElement(By.name("password")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).click();
		
//		actions
//		.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule")))
//		.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule")))
//		.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule")))
//		.click()
//		.perform();
		
		driver.findElement(By.id("email")).sendKeys("Shaikshavali");
		actions.doubleClick(driver.findElement(By.id("email"))).perform();
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		actions.contextClick(driver.findElement(By.xpath("//span[.='right click me']"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[.='Edit']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		
		driver.quit();
	
	}

}
