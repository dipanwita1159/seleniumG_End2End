
package com.mohs10.base;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;



public class PdfExcutionBrowser {
	public static WebDriver driver;
	// set up report
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	ExtentSparkReporter sparkReporter;

	@BeforeTest
	public void generateReport() {
		sparkReporter = new ExtentSparkReporter("Report/AutomationReport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}

	@BeforeMethod
	public void methodName(Method method) {
		parentTest = extent.createTest(method.getName());
	}

	@BeforeClass
	public void beforeClass() throws MalformedURLException, InterruptedException {
		
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		 // WebDriverManager.edgedriver().setup();
		  //driver = new ChromeDriver();
		  driver= new FirefoxDriver();
		  //driver= new EdgeDriver();
		  driver.manage().timeouts();
		  driver.manage().window().maximize();
	  
		/*
		 * DesiredCapabilities capability = new DesiredCapabilities(); //
		 * capability.setBrowserName("chrome"); capability.setPlatform(Platform.WIN11);
		 * ChromeOptions Options = new ChromeOptions(); // Options.setBinary("");
		 * Options.merge(capability); String Node = "http://192.168.1.11:4444"; driver =
		 * new RemoteWebDriver(new URL(Node), Options); // driver.get(Url);
		 * driver.manage().window().maximize(); System.out.println("chrome closed");
		 * Thread.sleep(5000);
		 */
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		extent.flush();
	}

}