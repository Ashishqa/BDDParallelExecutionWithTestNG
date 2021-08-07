package com.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.Scenario;

public class ScreenShots {
	
	
	public void tearDown(Scenario scenario, WebDriver driver)
	{
		if (scenario.isFailed()) {

			try {
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png",scenario.getName());
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png",scenario.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(driver!=null)
		{
			driver.close();
			driver.quit();
		}
		
	}

}
