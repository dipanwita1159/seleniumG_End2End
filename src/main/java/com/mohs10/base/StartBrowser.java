package com.mohs10.base;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StartBrowser {
	public static WebDriver driver;
	//set up report
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	ExtentSparkReporter sparkReporter;
	//keyword
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void generateReport()
	{
		sparkReporter = new ExtentSparkReporter("Report/AutomationReport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}

	@BeforeMethod
	public void methodName(Method method)
	{
		parentTest = extent.createTest(method.getName()); 
	}
	 
	 
	@Test
	public static  WebDriver launchapp(String browser) throws MalformedURLException, InterruptedException { 


		if (browser.equalsIgnoreCase("firefox")) {
			DesiredCapabilities capability =new DesiredCapabilities();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WIN10);
			FirefoxOptions Options=new FirefoxOptions();
			Options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			Options.merge(capability);
			String Node = "http://localhost:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), Options);
			//driver.get(Url);
			driver.manage().window().maximize();
			System.out.println("firefox closed");
			Thread.sleep(5000);



		}


		else if(browser.equalsIgnoreCase("chrome")) {
			DesiredCapabilities capability =new DesiredCapabilities();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WIN11);
			ChromeOptions Options=new ChromeOptions();
			//Options.setBinary("");
			Options.merge(capability);
			String Node = "http://localhost:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), Options);
			//driver.get(Url);
			driver.manage().window().maximize();
			System.out.println("chrome closed");
			Thread.sleep(5000);


		}


		else if (browser.equalsIgnoreCase("msedge")) { // Check if the browser is Microsoft Edge
			DesiredCapabilities capability =new DesiredCapabilities();
			capability.setBrowserName("msedge");
			capability.setPlatform(Platform.ANY);
			EdgeOptions Options=new EdgeOptions();
			Options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
			Options.merge(capability);
			String Node = "http://localhost:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), Options);
			//driver.get(Url);
			driver.manage().window().maximize();
			System.out.println("edge closed");
			Thread.sleep(5000);
		}


		else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}



		return driver;
	}

	
	
	
	  @AfterClass public void afterClass() {
	  
	  driver.close(); extent.flush(); }
	 


}

