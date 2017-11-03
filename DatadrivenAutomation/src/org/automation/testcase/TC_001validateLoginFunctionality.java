package org.automation.testcase;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.automation.baseclass.DriverInstance;
import org.automation.pages.Login;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TC_001validateLoginFunctionality extends DriverInstance
{
	@Test(dataProvider="Excel")
	public void tc_001testcase(String username,String password) throws Exception
	{
		
		Login log= new Login(driver);
		Thread.sleep(8000);
		log.loginbtn();
		Thread.sleep(2000);
		log.enterusername(username);
		log.enterpassword(password);
		Thread.sleep(20000);
	    log.clicklogin();
	}
    
	@DataProvider(name="Excel")
   public Object[][] testDatagenerator() throws Exception
	{
		FileInputStream file= new FileInputStream("./TestData/Data.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(file);
		XSSFSheet loginsheet= wb.getSheet("sheet1");
		int numberOfdata=loginsheet.getPhysicalNumberOfRows();
		Object[][] testdata =new Object[numberOfdata][2];
		
		for(int i=0;i<numberOfdata;i++)
		{
		 XSSFRow row=loginsheet.getRow(i);
		 XSSFCell username=row.getCell(0);
		 XSSFCell password=row.getCell(1);
		 testdata[i][0]=username.getStringCellValue();
		 testdata[i][1]=password.getStringCellValue();
		}
	   return testdata;
	}



} 



