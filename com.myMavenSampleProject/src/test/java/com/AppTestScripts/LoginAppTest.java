package com.AppTestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.AppUtilities.BrowserFactory;

public class LoginAppTest {
	public static WebDriver driver;
	public static BrowserFactory browser;
  
	
	
@BeforeSuite
public void setupSuite() {
	browser=new BrowserFactory();
}
	
  @Test
  public void verifyLogin() {
	  
	  
	  
	  
	  
	  
  }
}
