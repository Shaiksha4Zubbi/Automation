package com.pack.selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebElementProperties {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        Thread.sleep(2000);
        
        
  //   System.out.println(driver.findElement(By.name("commit")).getTagName());
        
  //   System.out.println(driver.findElement(By.name("commit")).getAttribute("type"));
        
        WebElement usernameTxt = driver.findElement(By.id("login_field"));
        usernameTxt.sendKeys("shaikshavali.java@gmail.com");
        System.out.println(usernameTxt.getAttribute("value"));
        
  //    System.out.println(driver.findElement(By.xpath("//input[@id='login_field']/preceding-sibling::label")).getText());
        
  //    System.out.println(driver.findElement(By.name("commit")).getCssValue("background-color"));
        driver.quit();
	}

}
