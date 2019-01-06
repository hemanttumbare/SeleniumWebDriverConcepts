package com.hemant.frames;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframes {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.quackit.com/html/tags/html_iframe_tag.cfm");
		
		//<iframe class="result" src="https://www.quackit.com/preview/preview_example_code.cfm?r=editorCode4" name="result4"></iframe>
		
		
		//Using WebElement
		WebElement frameToSwitch = driver.findElement(By.xpath("//iframe[@name='result4']"));
		driver.switchTo().frame(frameToSwitch);
			
		//Using Frame Name/Id
		//driver.switchTo().frame("result4");
		
		//Using Frame index
		driver.switchTo().frame(0);
		System.out.println("Frame Content : "+driver.findElement(By.tagName("body")).getAttribute("innerText"));
		
		//Switch back to Parent frame
		driver.switchTo().defaultContent();
			
		//Switch back to Original WebPage
		driver.switchTo().defaultContent();
			
		//Get list of all frames
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println("Total frames : "+ iframeList.size());
		
		
	}

	}


