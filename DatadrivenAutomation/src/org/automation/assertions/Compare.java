package org.automation.assertions;

import org.openqa.selenium.WebDriver;

public class Compare 
{
 public static boolean validatePageURL(WebDriver driver,String expUrl)
 {
	 boolean flag=false;
	 if(driver.getCurrentUrl().equalsIgnoreCase(expUrl))
	 {
		flag=true;
	 }
		 return flag;
 }
 
 public static boolean validatePageTitle(WebDriver driver,String expTitle)
 {
	 boolean flag=false;
	 if(driver.getTitle().equalsIgnoreCase(expTitle))
	 {
		flag=true;
	 }
		 return flag;
 }
	
}
