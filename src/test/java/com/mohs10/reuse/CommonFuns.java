package com.mohs10.reuse;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mohs10.base.StartBrowser;
import com.mohs10.ActionDriver.Action;
import com.mohs10.ActionDriver.SSreuseclass;
import com.mohs10.ActionDriver.dataEncrypt_Decrypt2;
import com.mohs10.ActionDriver.dataMasking;
import com.mohs10.ActionDriver.dataMasking2;

import com.mohs10.or.HomePage;

public class CommonFuns extends Action {
	

	public static Action aDriver;
	public WebDriver driver;

	public CommonFuns() {
		aDriver = new Action();
		driver = StartBrowser.driver;
	}

	public void login(String Userid, String Pwd) throws Exception {

		StartBrowser.childTest = StartBrowser.parentTest.createNode("login for data Masking");
		aDriver.navigateToApplication("http://jyotsnaprod.ap-south-1.elasticbeanstalk.com/");

		dataMasking.HideData(HomePage.LoginId, Userid, "enter user id");//
		aDriver.type(HomePage.Password, Pwd, "Password Entered");
		aDriver.click(HomePage.Login, "button for login clicked");
		SSreuseclass.SSReusablemethod(driver, "login");

	}

	public void DataEntry_hidden(String name, String location, String email, String password, String role)
			throws Exception {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Enter Masked Data");

		aDriver.click(HomePage.addAdmin, "Add Admin button clicked");

		dataMasking.HideData(HomePage.adminName, name, "Adminname entered");
		aDriver.selectDropDown(HomePage.Location, "value", location);

		dataMasking.HideData(HomePage.Email, email, "email enterd");
		dataMasking.HideData(HomePage.password, password, "password entered");
		aDriver.type(HomePage.Role, role, "enter role");
		Thread.sleep(5000);
		SSreuseclass.SSReusablemethod(driver, "data enterd");
		aDriver.submitButton(HomePage.submitButton);
	}

	public void logout() throws Exception {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Log-Out");

		aDriver.click(HomePage.suplogout, "log out button clicked");
		aDriver.click(HomePage.singout, "sing out button clicked");
		SSreuseclass.SSReusablemethod(driver, "sucessfully logged out");
		Thread.sleep(5000);
	}

}
