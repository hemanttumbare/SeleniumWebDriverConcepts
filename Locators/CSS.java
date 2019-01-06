package com.hemant.locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSS {
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
		
		//1. Id
		//<input id="Search" name="token" type="text" class="ui-autocomplete-input" autocomplete="off">
		WebElement searchBoxbyId = driver.findElement(By.cssSelector("input#Search"));
		searchBoxbyId.sendKeys("CSS Selector By Id");
		
		
		//2. Class
		//<input id="Search" name="token" type="text" class="ui-autocomplete-input" autocomplete="off">
		WebElement searchBoxByClass = driver.findElement(By.cssSelector("input.ui-autocomplete-input"));
		searchBoxByClass.clear();
		searchBoxByClass.sendKeys("CSS Selector By Class");
				
		//3. Multiple Class
		//<div id="Loan" class="btn inline-btn services">Apply Online</div>
		WebElement applyOnlineBtn = driver.findElement(By.cssSelector("div.btn.inline-btn.services"));
		applyOnlineBtn.click();
		
		//Close the box
		//<div class="slvj-close-icon"></div>
		WebElement closeBox = driver.findElement(By.cssSelector("div.slvj-close-icon"));
		closeBox.click();
		Thread.sleep(2000);
		
		
		//4. With Attributes
		//<a rel="ct_ctnr" href="/Personal-Banking/products.page?" target="">Products</a>
		WebElement products = driver.findElement(By.cssSelector("a[rel='ct_ctnr'][href='/Personal-Banking/products.page?']"));
		products.click();
		Thread.sleep(3000);
		
		//<a rel="ct_ctnr" href="/Personal-Banking/apply-online/index.page?" target="">Apply Online</a>
		WebElement applyonline = driver.findElement(By.cssSelector("a[rel*='ctnr'][href$='/Personal-Banking/apply-online/index.page?']"));
		applyonline.click();
		Thread.sleep(3000);
		
		//<a rel="ct_ctnr" href="/Personal-Banking/connect.page?" target="">Ways to Bank</a>
		WebElement wayToBank = driver.findElement(By.cssSelector("a[href^='/Personal-Banking/connect.page']"));
		wayToBank.click();
		Thread.sleep(3000);
		
		
		//<a rel="ct_ctnr" href="/customer-care.page?" target="">Get in Touch</a>
		WebElement getInTouch = driver.findElement(By.cssSelector("a[rel$='_ctnr'][href='/customer-care.page?']"));
		getInTouch.click();
		Thread.sleep(3000);
		
		//5. Contains
		//<a class="selected" href="/customer-care.page?#toptitle">Customer Care Numbers</a>
		/*WebElement carInsLink  = driver.findElement(By.cssSelector("a:contains('Customer Care Numbers')"));
		carInsLink.click();*/
	}

}
