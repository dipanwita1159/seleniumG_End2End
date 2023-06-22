package com.mohs10.scripts;

import org.testng.annotations.Test;

import com.mohs10.ActionDriver.Action;
import com.mohs10.ActionDriver.SSreuseclass;
import com.mohs10.ActionDriver.XLUtils;

import com.mohs10.ActionDriver.dataEncrypt_Decrypt2;
import com.mohs10.ActionDriver.dataMasking2;
import com.mohs10.base.StartBrowser;
import com.mohs10.or.HomePage;
import com.mohs10.reuse.CommonFuns;

public class HomeTest extends StartBrowser {

	String excelFilePath = "TestData\\Data.xlsx";
	String excelsheet = "Login";

	@Test
	public void LoginTestCase3() throws Exception {
		CommonFuns hm2 = new CommonFuns();

		int rowcount = XLUtils.getRowCount(excelFilePath, excelsheet);

		for (int i = 1; i < rowcount; i++) {
			String Email = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 0);
			String Pwd = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 1);
			String adminname = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 2);
			String location = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 3);
			String Emailid = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 4);
			String password = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 5);
			String role=XLUtils.getStringCellData(excelFilePath, excelsheet, i, 20);
		
			
			String url = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 17);
			
			StartBrowser.launchapp("firefox");

			// data Encryption script
			//dataEncryption.encryptData(excelFilePath, excelsheet);

			// data hiding script
			hm2.login(Email, Pwd);
			SSreuseclass.SSReusablemethod(driver, "login");
			///Thread.sleep(5000);
			

			// data hiding script
			hm2.DataEntry_hidden(adminname, location, Emailid, password, role);
			Thread.sleep(5000);
			SSreuseclass.SSReusablemethod(driver, "From Filled up");// take screenshot

			
			
			//SSreuseclass.SSReusablemethod(driver, "enter credtential");// take the screenshort
			
			//logout
			hm2.logout();
			
			

			Thread.sleep(5000);
			
			

		}
	}

}
