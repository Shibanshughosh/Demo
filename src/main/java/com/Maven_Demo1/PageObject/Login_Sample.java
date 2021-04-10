package com.Maven_Demo1.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Maven_Demo1.MyMavenDemo1.Utility;

public class Login_Sample extends Utility{

	public WebDriver driver;
	
	public Login_Sample(WebDriver driver){
		this.driver = driver;
	}
	
	By myAccount = By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser']");
	public WebElement getMyAccount(){
		Utility.setExplicitWait(myAccount, 40, "presence");
		return driver.findElement(myAccount);
	}
	
	By userName = By.xpath("//input[@id='username']");
	public WebElement getUserName(){
		Utility.setExplicitWait(userName, 40, "presence");
		return driver.findElement(userName);
	}
	
	By password = By.xpath("//input[@id='password']");
	public WebElement getPassword(){
		Utility.setExplicitWait(password, 40, "presence");
		return driver.findElement(password);
	}
	
	By loginButton = By.xpath("//span[contains(text(),'Login')]");
	public WebElement getLoginButton(){
		return driver.findElement(loginButton);
	}
	

}
