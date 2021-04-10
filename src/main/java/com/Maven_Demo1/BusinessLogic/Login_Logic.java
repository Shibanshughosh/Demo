package com.Maven_Demo1.BusinessLogic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.Maven_Demo1.PageObject.Login_Sample;

public class Login_Logic extends Login_Sample
{

	public Login_Logic(WebDriver driver) {
		super(driver);
	}
	
	public void makeMyTripAccount()throws Exception{
		
		getMyAccount().click();
	}
	public void makeMyTripLogin(String userName, String password){
		
		getUserName().clear();
		getUserName().sendKeys(userName);
		System.out.println("UserId Entered");
		//getPassword().clear();
		getUserName().sendKeys(Keys.TAB);
		getPassword().sendKeys(password);
		System.out.println("Password Entered");
		getLoginButton().click();
		System.out.println("Login button clicked");
		
	}
	
}
