package com.inetBanking.testcases;

import org.apache.logging.log4j.core.Logger;

import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class BaseClass {

	public String baseURL="https://demo.guru99.com/v4/";
	public String username="mngr428791";
	public String password="gYtydeh";
	public static WebDriver driver;
	
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
		
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}


