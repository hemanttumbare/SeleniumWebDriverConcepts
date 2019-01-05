package com.hemant.SeleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicWebDriverSetup {
	
	public static WebDriver driver;


	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		// Maximize the window
		driver.manage().window().maximize(); 
		
		// Assign implicit wait to driver
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.MINUTES);
		
		// Delete all Cookies
		driver.manage().deleteAllCookies();
		
		
		// Depending on your requirement assign page load setting
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");

	}

}
