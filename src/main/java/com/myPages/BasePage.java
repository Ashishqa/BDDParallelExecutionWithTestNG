package com.myPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		waitForElementPresent(locator);
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element =null;
		try {
			element=driver.findElement(locator);
		}
		catch(Exception e)
		{
			System.out.println("Some error has occured while creating an element : "+element.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	@Override
	public void waitForElementClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	@Override
	public void waitForElementToVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	@Override
	public List<WebElement> getElements(By locator) {
		List<WebElement> element =null;
		try {
			element=driver.findElements(locator);
		}
		catch(Exception e)
		{
			System.out.println("Some error has occured while creating an elements : "+element.toString());
		}
		return element;
	}

	@Override
	public void clickElement(By locator) {
			waitForElementClickable(locator);
			getElement(locator).click();
	}

	@Override
	public void enterText(By locator, String key) {
		waitForElementClickable(locator);
		getElement(locator).clear();
		getElement(locator).sendKeys(key);
	}
	

}
