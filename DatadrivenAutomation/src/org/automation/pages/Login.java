package org.automation.pages;

import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login 
{
	WebDriver driver;
	

	public Login(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void loginbtn() throws Exception
	{
		driver.findElement(By.xpath(Utility.fetchLocatorValue("xpath_login"))).click();
	}
	
	public void enterusername(String username) throws Exception
	{
		driver.findElement(By.xpath(Utility.fetchLocatorValue("xpath_login_username"))).sendKeys(username);
	}
	public void enterpassword(String password) throws Exception
	{
	    driver.findElement(By.xpath(Utility.fetchLocatorValue("xpath_login_password"))).sendKeys(password);	
	}
	//do recatcha manually
	
	public void clicklogin() throws Exception
	{
		driver.findElement(By.xpath(Utility.fetchLocatorValue("xpath_login_btn"))).click();
	}
	
}	
