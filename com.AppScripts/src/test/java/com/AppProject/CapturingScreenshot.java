package com.AppProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AppUtilities.ElementCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CapturingScreenshot
{
    ExtentReports extent;
    ExtentTest test;
    WebDriver driver;
     
    @BeforeTest
    public void init()
    {
        extent = new ExtentReports("./myfiles/ExtentScreenshot.html", true);
    }
     
    @Test
    public void captureScreenshot()
    {
        test = extent.startTest("captureScreenshot");
        System.setProperty("webdriver.chrome.driver","./AppDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.in");
        String title = driver.getTitle();
       
        
        Assert.assertEquals("Google", title);
        test.log(LogStatus.PASS, "Test Passed",title);
        
        
        String text = driver.findElement(By.name("btnK")).getText();
        Assert.assertEquals("GoogleSearch", text);
        test.log(LogStatus.PASS, "Test Passed",text);
        
    }
     
    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String screenShotPath = ElementCapture.captureScreenshot(driver, "sampletest");
            test.log(LogStatus.FAIL, result.getThrowable());
            test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
        }
        extent.endTest(test);
    }
     
         
    @AfterTest
    public void endreport()
    {
        driver.close();
        extent.flush();
        extent.close();
    }
}