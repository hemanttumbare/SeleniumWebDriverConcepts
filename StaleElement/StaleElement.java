package com.hemant.waits;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElement {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://eagercrow.com/SignIn");

		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window : " + parentWindow);
		System.out.println("Page Title : " + driver.getTitle());

		// <span class="firebaseui-idp-text firebaseui-idp-text-long">Sign in with
		// Google</span>
		WebElement signInByGoogle = driver.findElement(By.xpath("//span[text()='Sign in with Google']"));
		signInByGoogle.click(); // This will open another window

		// Thread.sleep(3000);

		// Get list of all open window
		Set<String> windowSet = driver.getWindowHandles();
		System.out.println("All windows : " + windowSet.toString());

		// Switch to Google SignIn Window

		Iterator<String> itr = windowSet.iterator();

		while (itr.hasNext()) {

			String window = itr.next();

			if (!window.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(window);
				System.out.println("Child Window : " + window);
				System.out.println("Child Page Title : " + driver.getTitle());
				break;
			}
		}

		// <input type="email" class="whsOnd zHQkBf" jsname="YPqjbf"
		WebElement email = driver.findElement(By.id("identifierId"));
		email.sendKeys("tumbare27");

		// <span class="RveJvd snByac">Next</span>
		WebElement userNext = driver.findElement(By.xpath("//span[text()='Next']"));
		userNext.click();

		// <input type="password" class="whsOnd zHQkBf" jsname="YPqjbf"
		driver.findElement(By.name("password")).sendKeys("123");

		// <span class="RveJvd snByac">Next</span>
	
		for (int i = 0; i <= 2; i++) {
			try {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
