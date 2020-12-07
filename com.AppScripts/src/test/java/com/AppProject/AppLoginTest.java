package com.AppProject;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.AppObjects.AppObjects;
import com.AppUtilities.BrowserFactory;
import com.AppUtilities.ElementCapture;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;




public class AppLoginTest extends AppBaseClass {
	
	
	
@BeforeTest
public void launchBrowser() {
	 driver=BrowserFactory.getBrowser(config.getbrowsername(),config.getbrowserurl());
	   
     
}
	
@Test
public void verifylogin() throws Exception {
	
	
	//report = new ExtentReports("./myfiles/testreport.html",true);
	logger=report.startTest("sample extent test");
	
	Apploginpage=PageFactory.initElements(driver,AppObjects.class);
	Apploginpage.getusername(config.getusername(),config.getpassword());
	Apploginpage.clickloginbutton();
	
	ElementCapture.captureScreenshot(driver, "button");
	logger.log(LogStatus.PASS,"Clicking button");
	
	
	
	
	
	
}

@AfterMethod
public void getextentresult(ITestResult result) {
	
	if(result.getStatus()==ITestResult.FAILURE) {
		
		String screenShotPath = ElementCapture.captureScreenshot(driver, "test");
		String image = logger.addScreenCapture(screenShotPath);
		logger.log(LogStatus.FAIL,"screenshot",image);
		
	}
	
	report.endTest(logger);
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
