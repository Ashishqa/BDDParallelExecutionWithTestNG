package com.myPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	private By userNameInputText= By.id("user-name");
	private By passwordInputText= By.id("password");
	private By loginButton=By.id("login-button");
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public String getLoginPageTitle()
	{
		return getPageTitle();
	}
	
	public String getUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public void navigateToLoginPage()
	{
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");
	}
		
	public HomePage doLogin(String userName, String password)
	{
		enterText(userNameInputText, userName);
		enterText(passwordInputText, password);
		clickElement(loginButton);
		return getInstance(HomePage.class);
		
	}
}
