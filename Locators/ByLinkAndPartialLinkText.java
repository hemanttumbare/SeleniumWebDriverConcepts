package com.hemant.locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ByLinkAndPartialLinkText {

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
		
		//<a rel="ct_ctnr" href="/Personal-Banking/products.page?" target="">Products</a>
		WebElement products = driver.findElement(By.linkText("Products"));
		products.click();
		
		Thread.sleep(3000);
		//<a rel="ct_ctnr" href="/Personal-Banking/payments.page?" target="">Payments</a>
		WebElement payment = driver.findElement(By.linkText("Payments"));
		payment.click();
		
		Thread.sleep(2000);
		
		//<a class="selected" href="/Personal-Banking/connect.page?#toptitle">Ways to Bank</a>
		WebElement wayToBank = driver.findElement(By.partialLinkText("Ways to"));
		wayToBank.click();
		
		

	}

}
