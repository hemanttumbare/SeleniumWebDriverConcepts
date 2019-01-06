package com.hemant.alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptAlerts {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		
		//1. Alert Box
		//<button class="btn btn-default" onclick="myAlertFunction()">Click me!</button>
		WebElement alertBox = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
		alertBox.click();
		
		Alert alert1 = driver.switchTo().alert();
		System.out.println("AlertBox Message : "+ alert1.getText());
		Thread.sleep(5000);
		alert1.accept();
		
		
		
		//2. Confirm Box
		//<button class="btn btn-default btn-lg" onclick="myConfirmFunction()">Click me!</button>
		WebElement confirmBox = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
		confirmBox.click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println("ConfirmBox Message : "+ alert2.getText());
		Thread.sleep(5000);
		alert2.dismiss();
	
		
		
		//3. Prompt Box
		//<button class="btn btn-default btn-lg" onclick="myPromptFunction()">Click for Prompt Box</button>
		WebElement promptBox = driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
		promptBox.click();
		Alert alert3 = driver.switchTo().alert();
		System.out.println("ConfirmBox Message : "+ alert3.getText());
		Thread.sleep(3000);
		alert3.sendKeys("This is Alert Message");
		Thread.sleep(3000);
		alert3.accept();
		
		
	}

}
