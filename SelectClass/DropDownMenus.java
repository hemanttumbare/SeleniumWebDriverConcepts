package com.hemant.select;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownMenus {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://facebook.com");
		
		//<select aria-label="Day" name="birthday_day" id="day" title="Day" class="_5dba">
		//<select aria-label="Month" name="birthday_month" id="month" title="Month" class="_5dba">
		//<select aria-label="Year" name="birthday_year" id="year" title="Year" class="_5dba">
		
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
	
		Select dayMenu = new Select(day);
		Select monthMenu = new Select(month);
		Select yearMenu = new Select(year);
		
		dayMenu.selectByIndex(1);
		monthMenu.selectByValue("6");
		yearMenu.selectByVisibleText("2000");
		
		System.out.println("Number of options in Day :"+dayMenu.getOptions().size());
		System.out.println("Number of options in Month :"+monthMenu.getOptions().size());
		System.out.println("Number of options in Year :"+yearMenu.getOptions().size());
	
		//Print the Options
		List<WebElement> dayList = dayMenu.getOptions();
		
		Iterator<WebElement> itr  = dayList.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next().getText()+" ");
		}
		
		System.out.println();
		
		//Print with For loop
		for(int i=0;i<dayList.size();i++) {
			System.out.print(dayList.get(i).getText()+" ");
		}
		
		System.out.println();
		/////////////////////////////Without Select////////////////////////
		
		//Print Options From Day Select Box
		List<WebElement> list = driver.findElements(By.xpath("//select[@id='day']//option")); 
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i).getText()+ " ");
		}
		
	}

}
