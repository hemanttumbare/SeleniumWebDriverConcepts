package com.hemant.locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ByName {

	public static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.icicibank.com/");
		
		//Close the pop up first by using By ID
		WebElement popUp = driver.findElement(By.id("push-modal-close"));
		popUp.click();
		
		//<input id="Search" name="token" type="text" class="ui-autocomplete-input" autocomplete="off">
		WebElement searchBox = driver.findElement(By.name("token"));
		searchBox.sendKeys("Search My Name");
	}

}
