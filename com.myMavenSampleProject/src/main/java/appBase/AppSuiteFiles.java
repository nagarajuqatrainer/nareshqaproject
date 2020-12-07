package appBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.AppUtilities.BrowserFactory;
import com.AppUtilities.ConfigReader;

import appObjects.LoginObjects;


public class AppSuiteFiles {
	
	public static WebDriver driver;
	public static BrowserFactory browser;
	public static LoginObjects loginpage;
	public static ConfigReader config;

	
	
@BeforeSuite
public void setupsuite() {
	browser=new BrowserFactory();
	config = new ConfigReader();
}






}
