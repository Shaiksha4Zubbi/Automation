package com.pack.selenuim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestApplicationProperties {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumhq.com");
		
		//URL
		
		String currentURL = driver.getCurrentUrl();
		System.out.println("Curent URL -" +currentURL);
		
		//Title
		String title = driver.getTitle();
		System.out.println("Title -" +title);
		
		//Page Source
		String pageSource = driver.getPageSource();
		System.out.println("Page Source -" + pageSource);
		
		driver.quit();
	}

}
