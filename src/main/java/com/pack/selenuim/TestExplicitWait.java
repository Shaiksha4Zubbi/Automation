package com.pack.selenuim;

import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1000, 1000));

		WebDriverWait wait = new WebDriverWait(driver, 500);

		driver.get("https://testproject.io/");
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Login")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(windowHandle)) {
				
				driver.switchTo().window(windowHandle);
//				Function<WebDriver, Boolean> f = new Function<WebDriver, Boolean>() {
//
//					@Override
//					public Boolean apply(WebDriver webDriver) {
//
//						return webDriver.findElement(By.id("username")).isDisplayed();
//					}
//				};
				//wait.until(d->d.findElement(By.id("username")).isDisplayed());
				//	wait.until(f);
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
				driver.findElement(By.id("username")).sendKeys("Shaikshavali");
				driver.quit();
			}
		}
	}
}
