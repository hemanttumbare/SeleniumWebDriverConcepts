package com.hemant.tricks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttributeValueOfTag {


	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.icicibank.com/");
		
		//<a rel="ct_ctnr" href="/Personal-Banking/products.page?" target="">Products</a>
		WebElement products = driver.findElement(By.xpath("//a[text()='Products']"));
		
		String href = products.getAttribute("href");
		System.out.println("Attribute href :"+ href);
		
		String innerText = products.getAttribute("innerText");
		System.out.println("Inner text for this tag : "+ innerText);
		
	}

}
