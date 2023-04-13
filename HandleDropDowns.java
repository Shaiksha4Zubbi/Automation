package com.pack.selenuim;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDowns {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		Thread.sleep(3000);
		WebElement courseElement = driver.findElement(By.id("course"));
		Select courseDropDown = new Select(courseElement);
		List<WebElement> courseDropDownOptions = courseDropDown.getOptions();
		for(WebElement option : courseDropDownOptions ) {
			System.out.println(option.getText());
		}
		courseDropDown.selectByIndex(1);
		Thread.sleep(3000);
		courseDropDown.selectByValue("python");
		Thread.sleep(3000);
		courseDropDown.selectByVisibleText("Javascript");
		Thread.sleep(3000);
		String selectedOption = courseDropDown.getFirstSelectedOption().getText();
		System.out.println("Selected option:" +selectedOption);
	}

}
