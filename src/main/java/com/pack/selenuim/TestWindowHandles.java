package com.pack.selenuim;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWindowHandles {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		

		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		// Single Window
//		String parentWindowHandle = driver.getWindowHandle();
//		System.out.println("Parent Window Handle" + parentWindowHandle + driver.getTitle());
//		driver.findElement(By.id("newWindowBtn")).click();
//		Set<String> windowHandles = driver.getWindowHandles();
//		for (String windowHandle : windowHandles) {
//			if (!windowHandle.equals(parentWindowHandle)) {
//				driver.switchTo().window(windowHandle);
//				driver.manage().window().maximize();
//				driver.findElement(By.id("firstName")).sendKeys("Shaikshavali");
//				Thread.sleep(3000);
//				driver.close();
//				Thread.sleep(3000);
//			}
//
////      System.out.println(windowHandle + driver.getTitle());
//		}
//		driver.switchTo().window(parentWindowHandle);
//		driver.findElement(By.id("name")).sendKeys("Zubeda");

		// Single Tab
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent Window Handle" + parentWindowHandle + driver.getTitle());
		driver.findElement(By.id("newTabBtn")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				System.out.println(driver.findElement(By.id("output")).getText());
				driver.findElement(By.id("alertBox")).click();
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				System.out.println(driver.findElement(By.id("output")).getText());
				Thread.sleep(3000);
				driver.close();
			}

//      System.out.println(windowHandle + driver.getTitle());
		}
		driver.switchTo().window(parentWindowHandle);
		driver.findElement(By.id("name")).sendKeys("Zubeda");

		Thread.sleep(3000);
		driver.quit();
	}
}
