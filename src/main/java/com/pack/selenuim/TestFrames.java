package com.pack.selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFrames {

	public static void main(String[] args) throws Exception {
		SwitchToFrame_By_Index();
		//SwitchToFrame_By_WebElement();
		//SwitchToFrame_By_Id();
		
	}
	
	private static void SwitchToFrame_By_Index() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/iframe");
		
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		WebElement message_text_box = driver.findElement(By.xpath("//body[@id='tinymce']"));
		message_text_box.clear();
		
		message_text_box.sendKeys("Shaikshavali");
		Thread.sleep(3000);
		
		message_text_box.clear();
		Thread.sleep(3000);
		message_text_box.sendKeys("Amira");
		
		Thread.sleep(3000);
		driver.close();
	}

	private static void SwitchToFrame_By_WebElement() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/iframe");
		
		WebElement iframe_xpath = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(iframe_xpath);
		Thread.sleep(3000);
		WebElement message_text_box = driver.findElement(By.xpath("//body[@id='tinymce']"));
		message_text_box.sendKeys("Shaikshavali");
		message_text_box.clear();
		
		Thread.sleep(3000);
		message_text_box.sendKeys("Amira");
		Thread.sleep(3000);
		driver.close();
	}

	private static void SwitchToFrame_By_Id() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.switchTo().frame("mce_0_ifr");
		
		WebElement message_text_box = driver.findElement(By.xpath("//body[@id='tinymce']"));
		Thread.sleep(3000);
		message_text_box.sendKeys("Shaikshavali");
		
		Thread.sleep(3000);
		message_text_box.clear();
		message_text_box.sendKeys("Shaik Zubeda");
	}

}
