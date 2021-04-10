package com.Maven_Demo1.TestDriver;

import static org.testng.AssertJUnit.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Maven_Demo1.BusinessLogic.Login_Logic;
import com.Maven_Demo1.MyMavenDemo1.Utility;

public class Login_Driver {

	WebDriver driver = null;
	File file;
	FileInputStream fileInput;
	Properties properties;
	String configfile = "C:/Users/Shibanshu_Standard/workspace/MyMavenDemo1/src/main/java/com/Maven_Demo1/MyMavenDemo1/Config.properties";
	String browser = "Chrome";

	@BeforeTest
	public void setDriver() {

		try {
			System.out.println("Initialize the Driver");
			file = new File(configfile);
			fileInput = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInput);
			driver = Utility.getDriver(browser);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void myLogin() {

		try {
			driver.manage().window().maximize();
			driver.get(properties.getProperty("URL"));
			// Login_Logic ll = new Login_Logic(driver);
			assertTrue("Login Page is loaded!", driver.getCurrentUrl().contains(properties.getProperty("URL")));
			Login_Logic ll = PageFactory.initElements(driver, Login_Logic.class);
			ll.makeMyTripAccount();
			ll.makeMyTripLogin(properties.getProperty("USER_ID"), properties.getProperty("PASSWORD"));
			Thread.sleep(5000);
			driver.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.close();
		}
	}

	@AfterTest
	public void killDriver() {
		if (driver != null) {
			System.out.println("Driver session still exist");
			driver.quit();

		}
	}

}
