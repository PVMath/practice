package com.tms.comcast.genericutility;

import static org.testng.Assert.assertThrows;

import java.sql.Connection;
import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.tms.comcast.pomrepositorylib.AdminLogin;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	 //Create an Object to Utility
	public WebDriverUtlity wlib=new WebDriverUtlity();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public DataBaseUtility dlib=new DataBaseUtility();
	
	
	@BeforeSuite
	public void ConfigBS() {
	/*	Connection con=null;
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "root");*/
		System.out.println("connect to db");
		
	}
	@BeforeClass
	public void ConfigBC() throws Throwable {
		//Launch the browser---- RunTime Polymorphism
		String BROWSER =flib.getPropertyKeyValue("browser");
				if(BROWSER.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromiumdriver().setup();
					driver=new ChromeDriver();
					
				}else if(BROWSER.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
					
				}else {
					System.out.println("invalid browser name");
				}
				
				wlib.waitForElementInDOM(driver);
				//driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS );
				driver.manage().window().maximize();
	}
	@BeforeMethod	
	public void ConfigBM() throws Throwable  {
		String URL     =flib.getPropertyKeyValue("url");
		String USERNAME=flib.getPropertyKeyValue("username");
		String PASSWORD=flib.getPropertyKeyValue("password");
		
		
		String ADMIN   =flib.getPropertyKeyValue("admin");
		String PASSWORD1=flib.getPropertyKeyValue("password1");
		driver.get(URL);
		
		//Login to admin module
				AdminLogin AL=new AdminLogin(driver);
				AL.logintoAdmin(ADMIN, PASSWORD1);
				
		
	}
	@AfterMethod
	public void configAM() {
		//Logout of AdminModule
				AdminLogin AL1=new AdminLogin(driver);
				AL1.logout();
		}
	@AfterClass
	public void configAC() {
		driver.quit();
	}
	@AfterSuite
	public void AS() {
		System.out.println("closedb");
	}
	
	

}
