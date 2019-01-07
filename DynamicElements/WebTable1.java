package com.hemant.dynamicelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/20754/ban-vs-wi-2nd-test-windies-tour-of-bangladesh-2018");
	
		int noOfRows = driver.findElements(By.xpath("//div[@id='innings_1']/div/div")).size();
		System.out.println("No of Rows : "+ noOfRows);
		int noOfColmns = driver.findElements(By.xpath("//div[@id='innings_1']/div[1]/div[2]/div")).size();
		System.out.println("No of Columns : "+ noOfColmns);
		
		for(int i=2; i< noOfRows-8;i++) {
			for(int j=1;j<=noOfColmns;j++) {
				System.out.print(driver.findElement(By.xpath("//div[@id='innings_1']/div[1]/div["+i+"]/div["+j+"]")).getText());
				System.out.print(" | ");
			}
			System.out.println();
		}
	}

}
