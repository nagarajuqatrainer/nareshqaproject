package com.AppProject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.AppObjects.AppObjects;
import com.AppUtilities.BrowserFactory;
import com.AppUtilities.ConfigReader;
import com.AppUtilities.ElementCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class AppBaseClass {
	
	public static WebDriver driver;
	public static BrowserFactory browser;
	public static ConfigReader config;
	public static AppObjects Apploginpage;
	public static ElementCapture capture;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	
	
@BeforeSuite
public void AppSuite() {
	browser=new BrowserFactory();
	config=new ConfigReader();
	Apploginpage=new AppObjects(driver);
	capture=new ElementCapture();
	report = new ExtentReports("./myfiles/testreport.html",true);
	
	
}
	


@AfterClass
public void endExtents() {
	
	report.flush();
	report.close();
}

@AfterTest
public void closeBrowser() {
	browser.closebrowser();
}
	
	
	
	
}
