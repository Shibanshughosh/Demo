package com.Maven_Demo1.MyMavenDemo1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utility 
{
   public static WebDriver driver = null;
   public static WebDriverWait driverwait = null;
   
	public static WebDriver getDriver(String browser) {
	  
		switch (browser) {
		case "Firefox":
	   System.setProperty("webdriver.gecko.driver", "C:/Users/Shibanshu_Standard/workspace/geckodriver.exe");
	   driver = new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "C:/Users/Shibanshu_Standard/workspace/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}
	   return driver;
   }
   
   public static void setExplicitWait(By locator, int timeOutInSeconds, String waitType){
	   
	   driverwait = new WebDriverWait(driver, timeOutInSeconds);
	   
	   switch (waitType) {
		case "presence":
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			driverwait.until(ExpectedConditions.presenceOfElementLocated(locator));
			break;
		case "clickable":
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			driverwait.until(ExpectedConditions.elementToBeClickable(locator));
			break;
		case "visibility":
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			driverwait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			break;
		default:
			break;
	}

   }
}
