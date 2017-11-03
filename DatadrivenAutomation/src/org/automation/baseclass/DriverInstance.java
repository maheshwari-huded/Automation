package org.automation.baseclass;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.automation.utility.Utility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInstance 
{
	public WebDriver driver;
	
	@BeforeMethod
	public void initiateDriverInstance() throws Exception 
	{
		//converting object to string format
		if(Utility.fetchPropertyValue("browsername").toString().equalsIgnoreCase("chrome"))
		{	
			System.setProperty("webdriver.chrome.driver","/home/maheshwari/Downloads/chromedriver");
			driver=new ChromeDriver();
		}
		else if(Utility.fetchPropertyValue("browsername").toString().equalsIgnoreCase("firefox") )
		{
			System.setProperty("webdriver.gecko.driver","/home/maheshwari/Downloads/Browsers/geckodriver");
			driver=new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver","/home/maheshwari/Downloads/chromedriver");
			driver=new ChromeDriver();
		}
		 driver.get(Utility.fetchPropertyValue("applicationurl").toString());
	}	 

	@AfterMethod
	
	 
	public void closeDriverInstance()
	{
	  Utility.captureScreenshot(driver,"Name of screenshot");
	  driver.quit();
	}

}
