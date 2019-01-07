package com.hemant.dynamicelements;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/20304/aus-vs-ind-4th-test-india-tour-of-australia-2018-19");
	
	
		/*
		 * 	Table Header Row Class : cb-col cb-col-100 cb-scrd-hdr-rw  : 1 colum
			Table Sub Header Row Class : cb-col cb-col-100 cb-scrd-sub-hdr cb-bg-gray : 7 column
			Row Items Class : cb-col cb-col-100 cb-scrd-itms : 7 cloumn
			Header Class : cb-col cb-col-100 cb-scrd-sub-hdr cb-bg-gray text-bold : 1 Column
		 * */
		
		List<WebElement>  noOfRows = driver.findElements(By.xpath("//div[@id='innings_1']/div/div "));
		
		Iterator<WebElement> itr = noOfRows.iterator();
		
		while(itr.hasNext()) {
			
			WebElement element = itr.next();
			String elementClass = element.getAttribute("class");
			printElement(element, elementClass);
		}
	}

	private static void printElement(WebElement element, String elementClass) {
		
		if(elementClass.equals("cb-col cb-col-100 cb-scrd-hdr-rw")) {
			System.out.print(element.getText());
			System.out.println();
			
		}else if(elementClass.equals("cb-col cb-col-100 cb-scrd-sub-hdr cb-bg-gray text-bold")) {
			System.out.print(element.getText());
			System.out.println();
		}else {
			List<WebElement> rows = element.findElements(By.tagName("div"));
			print(rows);
			System.out.println();
		}
		
	}

	private static void print(List<WebElement> rows) {
		Iterator<WebElement> itr = rows.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next().getText()+" | ");
		}
	} 

}
