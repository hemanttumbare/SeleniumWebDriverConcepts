package com.hemant.sslcertificate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLCetificate {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		/////////////////////Google Chrome/////////////////////////////

		WebDriverManager.chromedriver().setup();
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setAcceptInsecureCerts(true);
		
		ChromeOptions chromeOpt = new ChromeOptions();
		chromeOpt.merge(cap);
		
		driver = new ChromeDriver(chromeOpt);
		
		driver.get("https://expired.badssl.com/");

		//////////////////////////FireFox//////////////////////////////
		WebDriverManager.firefoxdriver().setup();
		
		FirefoxOptions firefoxOpt = new FirefoxOptions();
		firefoxOpt.setAcceptInsecureCerts(true);
	
		driver = new FirefoxDriver(firefoxOpt);
		
		driver.get("https://expired.badssl.com/");
		
	}

}
