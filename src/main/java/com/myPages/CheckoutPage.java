package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

	private By checkOutHeaderTitle= By.className("title");
	private By firstNameInputText= By.id("first-name");
	private By lastNameInputText = By.id("last-name");
	private By zipCodeInputText= By.id("postal-code");
	private By continueButton= By.id("continue");
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public String getCheckoutHeaderTitle()
	{
		return getPageHeader(checkOutHeaderTitle);
	}
	
	public OverViewPage enterYourInformation(String firstName, String lastName, String zipCode)
	{
		enterText(firstNameInputText, firstName);
		enterText(lastNameInputText, lastName);
		enterText(zipCodeInputText, zipCode);
		clickElement(continueButton);
		return getInstance(OverViewPage.class);
		
	}
	
	

}
