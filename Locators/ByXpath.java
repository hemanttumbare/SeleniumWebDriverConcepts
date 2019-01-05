package com.hemant.locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ByXpath {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.icicibank.com/");
		
		
		//<div id="push-modal-close" style="background: #dedede; height: 23px; top: 122px; left: 45px; width: 72px; position: relative; color: #7d7d7d; text-align: center; line-height: 25px; border: 1px solid #dedede;" onclick="dataLayer.push({'event':'GAevent', 'gaEventCategory':'push-notification-popup', 'gaEventAction':'later-button-click-m', 'gaEventLabel':'popup', 'gaEventInteraction':'true'});">Later</div>
		WebElement popUp = driver.findElement(By.xpath("//div[@id='push-modal-close']"));
		popUp.click();
		
		//<input id="Search" name="token" type="text" class="ui-autocomplete-input" autocomplete="off">
		WebElement searchBox = driver.findElement(By.xpath("//input[@name='token']"));
		searchBox.sendKeys("Search My Name");
		Thread.sleep(3000);
		
		/*
		 * Xpath=//input[@type='text']				
		   Xpath=//label[@id='message23']
		   Xpath=//input[@value='RESET']
	       Xpath=//*[@class='barone']
		   Xpath=//a[@href='http://demo.guru99.com/']
		   Xpath=//img[@src='//cdn.guru99.com/images/home/java.png']
*/		
		
		/*
		 * Complex xPath using text(), contains(), starts-with(), ends-with() 
		 * functions
		 * */
		
		//***************** text() 
		
		//<a rel="ct_ctnr" href="/Personal-Banking/products.page?" target="">Products</a>
		WebElement productLink = driver.findElement(By.xpath("//a[text()='Products']"));
		productLink.click();
		Thread.sleep(3000);
		
		//******************Starts-with()
		
		//<div class="linktitle">Car Insurance</div>
		WebElement carInsu = driver.findElement(By.xpath("//div[starts-with(text(),'Car')]"));
		carInsu.click();
		Thread.sleep(3000);
		
		////*[contains(@href,'google.com')]	
		//******************Contains() & And (Similarly we can use OR also)
		
		//<a onclick="dataLayer.push({'event':'GAevent','gaEventCategory':'products-insurance','gaEventAction':'claim-click','gaEventLabel':'car-insurance'});" href="/Personal-Banking/insurance/general-insurance/motor-insurance/motor-claims.page?#toptitle">Claims</a>
		WebElement carInsu1 = driver.findElement(By.xpath("//a[contains(text(),'Claims') and @href='/Personal-Banking/insurance/general-insurance/motor-insurance/motor-claims.page?#toptitle']"));
		carInsu1.click();
		Thread.sleep(3000);
		
		//****************Multiple Attributes 
		
		//<a class="selected" href="/Personal-Banking/insurance/general-insurance/motor-claims.page?#toptitle">Claims</a>
		WebElement claim = driver.findElement(By.xpath("//a[@class='selected' and @href='/Personal-Banking/insurance/general-insurance/motor-claims.page?#toptitle']"));
		claim.click();
		
		/*
		 * XPATH AXES
		 * parent, child, following, following-sibling, preceding, preceding-sibling
		 * 
		 * */
		
		driver.navigate().to("https://www.facebook.com/");
		
		WebElement fbUserNameLabel = driver.findElement(By.xpath("//input[@id='email']//preceding::label[@for='email']"));
		
		
		/*
		//*[@type='text']//following::input
		//*[text()='Enterprise Testing']//ancestor::div
		//*[@id='java_technologies']/child::li
		//*[@type='submit']//preceding::input
		//*[@type='submit']//following-sibling::input
		//*[@id='rt-feature']//parent::div
		 */		
		}

}
