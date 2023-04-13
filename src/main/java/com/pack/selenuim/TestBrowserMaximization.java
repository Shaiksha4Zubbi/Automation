package com.pack.selenuim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowserMaximization {

	public static void main(String[] args) throws Exception {
		// way 1
//		WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://youtube.com");
//        
        //Way 2
		
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        Thread.sleep(3000);
        driver.get("https://www.youtube.com/watch?v=YxWlaYCA8MU");
        
	}

}
