package com.AppTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AppUtilities.BrowserFactory;
import com.AppUtilities.ConfigReader;

import appBase.AppSuiteFiles;
import appObjects.LoginObjects;

public class AppTest extends AppSuiteFiles
{

	public static WebDriver driver;
	

	
	

	@BeforeTest
	public void launchBrowser() {
		driver= BrowserFactory.getbrowser(ConfigReader.getbrowserdriver(),config.getbrowserurl());
		Reporter.log("launching browser");
	
	}

	
	@Test
	public void verifyLogin() {
		
		loginpage=PageFactory.initElements(driver, LoginObjects.class);
		loginpage.verifyusername("tester");
		loginpage.verifypassword("admin");
		loginpage.clickloginbutton();
	}
    	
    	@AfterTest
    	public void closebrowser() {
    		browser.closebrowser();
    	}

    	
	}


