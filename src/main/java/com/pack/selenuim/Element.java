package com.pack.selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element 
{
    public static void main( String[] args ) throws Exception
    {
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        Thread.sleep(2000);
        highlight(driver, driver.findElement(By.id("login_field")));
        Thread.sleep(2000);
        highlight(driver, driver.findElement(By.name("password")));
        Thread.sleep(2000);
        highlight(driver, driver.findElement(By.className("header-logo")));
        Thread.sleep(2000);
        highlight(driver, driver.findElement(By.linkText("Forgot password?")));
        Thread.sleep(2000);
        highlight(driver, driver.findElement(By.partialLinkText("Create an")));
        Thread.sleep(2000);
        highlight(driver, driver.findElement(By.tagName("h1")));
        Thread.sleep(2000);
        highlight(driver, driver.findElement(By.xpath("//label[contains(text(),'Username or email address')]")));
        Thread.sleep(2000);
        highlight(driver, driver.findElement(By.cssSelector("input[name='commit']")));
        
    }
    
    public static void highlight(WebDriver driver, WebElement element) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    	jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
    	
    }
}
