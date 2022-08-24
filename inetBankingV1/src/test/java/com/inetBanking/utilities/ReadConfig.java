package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReadConfig {
	WebDriver driver=null;
	FileInputStream fis = new FileInputStream(".\\Configurations\\config.properties");
	Properties prop = new Properties();
	prop.loa
	String URL = prop.getProperty("baseURL");
	String USERNAME = prop.getProperty("username");
	String PASSWORD = prop.getProperty("password");
	String BROWSER = prop.getProperty("browser");
	

	
	
	
	
}
