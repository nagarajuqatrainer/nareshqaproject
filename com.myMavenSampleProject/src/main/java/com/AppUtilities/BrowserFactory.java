package com.AppUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class BrowserFactory {
	

	
	public static WebDriver driver;
	//public static ConfigReader config;
	
	public static  WebDriver getbrowser(String browsertype,String Appurl) {
		
		ConfigReader config2=new ConfigReader();
		
		if(browsertype.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",config2.getbrowserpath());
			driver=new ChromeDriver();
					
		}
		
		else if(browsertype.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./myDrivers/geckodriver.exe");
			driver=new ChromeDriver();
		}
		
		
		else if(browsertype.equals("edge")) {
			System.setProperty("webdriver.msedgeserver.driver", "./myDrivers/msedgedriver.exe");
			driver=new ChromeDriver();
		}
		
		
		driver.get(Appurl);
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	
	public void closebrowser() {
		driver.close();
	}

}
