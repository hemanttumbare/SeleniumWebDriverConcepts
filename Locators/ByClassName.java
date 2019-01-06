package com.hemant.locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ByClassName {


	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.icicibank.com/");
		
		//<div id="push-modal-close" >Later</div>
		WebElement popUpClose = driver.findElement(By.id("push-modal-close"));
		popUpClose.click();
		
		//<span display-text="Personal Banking" class="pl-login-box">Personal Banking<img class="down_arrow" alt="" src="/assets/img/down_arrow.svg"></span>
		WebElement searchBox = driver.findElement(By.className("pl-login-box"));
		searchBox.click();

	}

}
