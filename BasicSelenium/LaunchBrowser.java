package com.hemant.SeleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LaunchBrowser {
	
	public static WebDriver driver;

	public static void main(String[] args) {
	
//With Driver Files location specified
		
		/*System.setProperty("webdriver.chrome.driver", "./src/main/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		System.setProperty("webdriver.gecko.driver", "./src/main/Resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
	
		System.setProperty("webdriver.ie.driver", "./src/main/Resources/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("https://www.google.com");*/
	
//Without using downloaded Driver files WebDriver Manager
		
		/*<dependency>
	    <groupId>io.github.bonigarcia</groupId>
	    <artifactId>webdrivermanager</artifactId>
	    <version>3.1.1</version>
	    <scope>test</scope>
		</dependency>*/
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	/*
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
	
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		driver.get("https://www.google.com");
	*/
	}

}
