package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.utility.ConfigReader;
import com.utility.Driver;
import com.utility.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends Driver{
  private WebDriver driver;
  private String browserName;
    
  @BeforeMethod
  @Parameters("browserName")
  public void SetupBrowser(String browserName) throws Exception
  {  this.browserName=browserName;
	  ConfigReader.ConfigFileReader();
	  try {
	  if(browserName.equalsIgnoreCase("Chrome"))
	  {
		  WebDriverManager.chromiumdriver().setup();
		  if(ConfigReader.pros.get("ExecuteLocal").toString().equalsIgnoreCase("True"))
		  {
		  driver= getChromeDriverLocal();
		  }
		  else
		  {
			  driver=getRemoteChromeDriver();	  
		  }
	  }
	  else if(browserName.equalsIgnoreCase("FireFox"))
	  {
		  WebDriverManager.firefoxdriver().setup();
		  if(ConfigReader.pros.get("ExecuteLocal").toString().equalsIgnoreCase("True"))
		  {
		  driver= getFireFoxDriverLocal();
		  }
		  else
		  {
			  driver=getRemoteFireFoxDriver();	  
		  }
	  }
	  else if(browserName.equalsIgnoreCase("Edge"))
	  {
		  WebDriverManager.edgedriver().setup();
		  if(ConfigReader.pros.get("ExecuteLocal").toString().equalsIgnoreCase("True"))
		  {
		  driver= getEdgeDriverLocal();
		  }
		  else
		  {
			  driver=getRemoteEdgeDriver();	  
		  }
	  }
	  else
	  {
		  throw new Exception("No browser is not  defined in xml file");
	  }
	  DriverManager.setDriver(driver);
	  driver.manage().window().maximize();
	  }
	  catch(Exception e)
	  {
		  
			  throw new Exception("Exception has occured while creating driver : "+ browserName);
	  }
  }
  

@AfterMethod
  public synchronized void closeBrowser() {
      if(DriverManager.getDriver()!=null)
      {
    	  if(browserName.equalsIgnoreCase("FireFox"))
    	  {
    		  DriverManager.getDriver().quit();
    	  }
    	  else
    	  {
    		  DriverManager.getDriver().close();
        	  DriverManager.getDriver().quit();
    	  }
    	 
      }
  }
}
