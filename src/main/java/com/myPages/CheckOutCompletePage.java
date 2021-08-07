package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutCompletePage extends BasePage{

	private By checkOutCompleteHeaderTitle= By.className("title");
	private By completeHeader= By.className("complete-header");
	private By menuButton= By.id("react-burger-menu-btn");
	private By logOutButton= By.id("logout_sidebar_link");
	public CheckOutCompletePage(WebDriver driver) {
		super(driver);
	}

	public String getCheckOutCompleteHeaderTitle()
	{
		return getPageHeader(checkOutCompleteHeaderTitle);
	}
	
	public String getSuccessfulOrderMessage()
	{
		return getElement(completeHeader).getText();
	}
	
	public LoginPage doLogOut()
	{
		clickElement(menuButton);
		clickElement(logOutButton);
		return getInstance(LoginPage.class);
	}
}
