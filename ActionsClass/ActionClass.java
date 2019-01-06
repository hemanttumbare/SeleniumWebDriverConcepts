package com.hemant.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClass {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		
		//<div id="draggable" class="ui-widget-content ui-draggable ui-draggable-handle"><p>Drag me to my target</p>
		//<div id="droppable" class="ui-widget-header ui-droppable">
		
		
		//1. Drag and Drop
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		Actions action =new Actions(driver);
		
		//action.dragAndDrop(drag, drop).build().perform();
		
		Thread.sleep(2000);
		
		//2. Drag and Drop
		
		action.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
		
		//Switch back to main window
		driver.switchTo().defaultContent();
		
		//3. Right Click
		//action.contextClick().perform();;
		
		//4. Keys Operations
		//<input type="text" name="s" value="" placeholder="Search">
		WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
		action.keyDown(Keys.SHIFT).perform();
		searchBox.sendKeys("Hello Dear");
		action.keyUp(Keys.SHIFT).perform();
		
		//5. Move To Element
		//<a href="https://jqueryui.com/progressbar/">Progressbar</a>
		WebElement progressBar  = driver.findElement(By.xpath("//a[text()='Progressbar']"));
		
		action.moveToElement(progressBar).perform();
	}

}
