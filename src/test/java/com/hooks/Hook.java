package com.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.utility.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hook{
		
	@After
	public synchronized void afterScenario(Scenario scenario)
	{
		if (scenario.isFailed()) {

			try {
				final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png",scenario.getName());
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				scenario.attach(((TakesScreenshot)  DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png",scenario.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


}
