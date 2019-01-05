package com.hemant.locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ById {

	public static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.icicibank.com/");
		
		//<div id="push-modal-close" >Later</div>
		WebElement popUpClose = driver.findElement(By.id("push-modal-close"));
		popUpClose.click();
		
		//<input id="Search" name="token" type="text" class="ui-autocomplete-input" autocomplete="off">	
		WebElement searchBox = driver.findElement(By.id("Search"));
		searchBox.sendKeys("TestIDLocator");
		
	}

}
