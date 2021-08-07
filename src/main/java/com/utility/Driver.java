package com.utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {
	
	private WebDriver driver;
	
	public WebDriver getChromeDriverLocal()
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-infobars");
		driver= new ChromeDriver(option);
		return driver;
	}
	
	public WebDriver getFireFoxDriverLocal()
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("disable-infobars");
		driver= new FirefoxDriver(option);
		return driver;
	}
	
	public WebDriver getEdgeDriverLocal()
	{
		EdgeOptions option = new EdgeOptions();
		driver = new EdgeDriver(option);
		return driver;
	}
	
	public WebDriver getRemoteChromeDriver()
	{
		DesiredCapabilities caps= DesiredCapabilities.chrome();
		try {
			driver= new RemoteWebDriver(new URL(ConfigReader.pros.get("NodeUrl").toString()),caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public WebDriver getRemoteFireFoxDriver()
	{
		DesiredCapabilities caps= DesiredCapabilities.firefox();
		try {
			driver= new RemoteWebDriver(new URL(ConfigReader.pros.get("NodeUrl").toString()),caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
	public WebDriver getRemoteEdgeDriver()
	{
		DesiredCapabilities caps= DesiredCapabilities.edge();
		try {
			driver= new RemoteWebDriver(new URL(ConfigReader.pros.get("NodeUrl").toString()),caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

}
