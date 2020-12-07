package com.AppUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties prop;
	
	
	public  ConfigReader() {
		
		//Reading data from property files
		
		try {
			
			File file = new File("./myFiles/login.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			System.out.println("Properties loaded successfully");
		}
		
	}
	
	
	//Create a method for each property
		public static String getbrowserdriver() {
		return prop.getProperty("browserdriver");
		}
		
		
		public  String getbrowserpath() {
			return prop.getProperty("browserpath");
		}
		
		
		public String getbrowserurl() {
			return prop.getProperty("browserurl");
		}
		
		
		public String getusername() {
			return prop.getProperty("username");
		}
		
		public String getpassword() {
			return prop.getProperty("password");
		}
		
		public String getcofirmpassword() {
			return prop.getProperty("confirmpassword");
		}
		
		
		
		//Creating methods for Interface element locators
		public String getunameelement() {
			return prop.getProperty("uname");
		}
		
		
		public String getpwordelement() {
			return prop.getProperty("pword");
		}
		
				
		public String getbuttonelement() {
			return prop.getProperty("lbutton");
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	


