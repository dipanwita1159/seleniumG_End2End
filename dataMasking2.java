package com.mohs10.ActionDriver;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.sym.Name;
import com.mohs10.base.StartBrowser;

public class dataMasking2 extends StartBrowser {
 
	

	public static void maskEmail2(By locator, String email) {
	    // Mask the email address
	    String[] emailParts = email.split("@");
	    String username = emailParts[0];
	    String domain = emailParts[1];
	    String maskedUsername = "";
	    for (int i = 0; i < username.length() - 1; i++) {
	        maskedUsername += "*";
	    }
	    maskedUsername += username.charAt(username.length() - 1);
	    String maskedEmail = maskedUsername + "@" + domain;

	    // Pass the masked email to the field
	    System.out.println(maskedEmail);
	    WebElement ele = StartBrowser.driver.findElement(locator);
	    ele.sendKeys(maskedEmail);
	}




	
	
	public static void maskPassword2(By locator, String password) {
	    // Mask the password
	    String maskedPassword = maskData(password);

	    // Pass the masked password to the field
	    System.out.println(maskedPassword);
	    WebElement ele = StartBrowser.driver.findElement(locator);
	    ele.sendKeys(maskedPassword);
	}


	public static String maskData(String data) {
	    // Replace characters with asterisks
	    StringBuilder masked = new StringBuilder();
	    int length = data.length();
	    for (int j = 0; j < length; j++) {
	        masked.append("*");
	    }
	    return masked.toString();
	}

	
	public static void maskFirstName2(By locator, String firstName) {
	    // Replace characters with asterisks except for the last character
	    String maskedFirstName = "";
	    int length = firstName.length();
	    for (int j = 0; j < length - 1; j++) {
	        maskedFirstName += "*";
	    }
	    maskedFirstName += firstName.charAt(length - 1);

	    // Pass the masked first name to the field
	    System.out.println(maskedFirstName);
	    WebElement ele = StartBrowser.driver.findElement(locator);
	    ele.sendKeys(maskedFirstName);
	}


	public static void maskLastName2(By locator, String lastName) {
	    // Replace characters with asterisks except for the last character
	    String maskedLastName = "";
	    int length = lastName.length();
	    for (int j = 0; j < length - 1; j++) {
	        maskedLastName += "*";
	    }
	    maskedLastName += lastName.charAt(length - 1);

	    // Pass the masked last name to the field
	    System.out.println(maskedLastName);
	    WebElement ele = StartBrowser.driver.findElement(locator);
	    ele.sendKeys(maskedLastName);
	}



	
	public static void maskOccupation(By locator, String occoName) {
	    // Replace characters with asterisks except for the last character
	    String maskedOccupation = "";
	    int length = occoName.length();
	    for (int j = 0; j < length - 1; j++) {
	        maskedOccupation += "*";
	    }
	    maskedOccupation += occoName.charAt(length - 1);

	    // Pass the masked occupation to the field
	    System.out.println(maskedOccupation);
	    WebElement ele = StartBrowser.driver.findElement(locator);
	    ele.sendKeys(maskedOccupation);
	}

	
	
	public static void maskReligion(By locator, String name) {
	    // Replace characters with asterisks except for the last character
	    String maskedName = "";
	    int length = name.length();
	    for (int j = 0; j < length - 1; j++) {
	        maskedName += "*";
	    }
	    maskedName += name.charAt(length - 1);

	    // Pass the masked name to the field
	    System.out.println(maskedName);
	    WebElement ele = StartBrowser.driver.findElement(locator);
	    ele.sendKeys(maskedName);
	}


	public static void maskMobileNumber(By locator, String mobileNumber) {
	    // Replace characters with asterisks except for the first two and last three characters
	    if (mobileNumber.length() < 5) {
	        return;
	    }
	    int length = mobileNumber.length();
	    String maskedMobileNumber = mobileNumber.substring(0, 2);
	    for (int j = 2; j < length - 3; j++) {
	        maskedMobileNumber += "*";
	    }
	    maskedMobileNumber += mobileNumber.substring(length - 3);

	    // Pass the masked mobile number to the field
	    System.out.println(maskedMobileNumber);
	    WebElement ele = StartBrowser.driver.findElement(locator);
	    ele.sendKeys(maskedMobileNumber);
	}


	


	public static void maskAge(By locator, String age) {
	    // Mask the age value
	    String maskedAge = "";
	    int length = age.length();
	    for (int j = 0; j < length - 1; j++) {
	        maskedAge += "*";
	    }
	    maskedAge += age.charAt(length - 1);

	    // Pass the masked age to the field
	    System.out.println(maskedAge);
	    WebElement ele = StartBrowser.driver.findElement(locator);
	    ele.sendKeys(maskedAge);
	}

	    

	  
	        
	

	
	public static void maskname(By locator, String Name, String excelfile, String excelsheet, int columnIndex, int rowIndex) throws Exception {
	    // Load Excel file
	    FileInputStream file = new FileInputStream(excelfile);
	    Workbook workbook = WorkbookFactory.create(file);
	    Sheet sheet = workbook.getSheet(excelsheet);

	    // Find the row with the matching first name
	    Row targetRow = sheet.getRow(rowIndex);
	    if (targetRow != null) {
	        Cell firstNameCell = targetRow.getCell(columnIndex);

	        if (firstNameCell != null) {
	            String rowFirstName = firstNameCell.getStringCellValue();
	            if (rowFirstName.equals(Name)) {
	                // Replace characters with asterisks except for the last character
	                String maskedFirstName = "";
	                int length = Name.length();
	                for (int j = 0; j < length - 1; j++) {
	                    maskedFirstName += "*";
	                }
	                maskedFirstName += Name.charAt(length - 1);

	                // Pass the masked first name to the field
	                System.out.println(maskedFirstName);
	                WebElement ele = StartBrowser.driver.findElement(locator);
	                ele.sendKeys(maskedFirstName);
	            }
	        }
	    }

	    file.close();
	}


	
	public static void maskName(By locator, String name) {
	    // Replace characters with asterisks except for the last character
	    String maskedName = "";
	    int length = name.length();
	    for (int j = 0; j < length - 1; j++) {
	        maskedName += "*";
	    }
	    maskedName += name.charAt(length - 1);

	    // Pass the masked name to the field
	    System.out.println(maskedName);
	    WebElement ele = StartBrowser.driver.findElement(locator);
	    ele.sendKeys(maskedName);
	}

	public static void maskExpectChar(By locator, String firstName) {
	    // Replace characters with asterisks except for the first and last character
	    String maskedFirstName = firstName.charAt(0) + "";
	    int length = firstName.length();
	    for (int j = 1; j < length - 2; j++) {
	        maskedFirstName += "*";
	    }
	    maskedFirstName += firstName.charAt(length - 2);

	    // Pass the masked first name to the field
	    System.out.println(maskedFirstName);
	    WebElement ele = StartBrowser.driver.findElement(locator);
	    ele.sendKeys(maskedFirstName);
	}

	
}

	


