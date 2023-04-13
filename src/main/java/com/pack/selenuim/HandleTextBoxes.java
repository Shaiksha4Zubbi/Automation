package com.pack.selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleTextBoxes {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/login");
		Thread.sleep(2000);
		WebElement usernameTxt = driver.findElement(By.id("login_field"));
		if (usernameTxt.isDisplayed()) {
			if (usernameTxt.isEnabled()) {
				usernameTxt.sendKeys("shaikshavali.java@gmail.com");
				String enteredText = usernameTxt.getAttribute("value");
				System.out.println(enteredText);
				Thread.sleep(4000);
				
			} else
				System.out.println("Username Text is not Enabled");
		} else
			System.out.println("Username Text is not displayed");

		WebElement password = driver.findElement(By.id("password"));
		if (password.getText() != null) {
			password.sendKeys("ShaikAmira@25");
			String enteredText = password.getAttribute("value");
			System.out.println(enteredText);
			WebElement sign_in = driver.findElement(By.name("commit"));
			sign_in.click();
			Thread.sleep(3000);
			if (sign_in.isSelected()) {
				sign_in.click();
				Thread.sleep(3000);
				Thread.sleep(3000);
				driver.findElement(By.name("commit")).click();

			}
		}
	}
}
