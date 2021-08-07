package com.myPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	public WebDriver driver;
	WebDriverWait wait;
	
	public Page(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(this.driver,90);
	}
	
	public abstract String getPageTitle();
	public abstract String getPageHeader(By locator);
	public abstract WebElement getElement(By locator);
	public abstract List<WebElement> getElements(By locator);
	public abstract void waitForElementPresent(By locator);
	public abstract void waitForElementClickable(By locator);
	public abstract void waitForElementToVisible(By locator);
	public abstract void clickElement(By locator);
	public abstract void enterText(By locator, String key);
	public <TPage extends Page> TPage getInstance(Class<TPage> pageClass)
	{
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
