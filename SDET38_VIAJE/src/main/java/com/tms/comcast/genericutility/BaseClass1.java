package com.tms.comcast.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	public static WebDriver sDriver;
	public WebDriver driver;
	 //Create an Object to Utility
	 WebDriverUtlity wlib=new WebDriverUtlity();
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	DataBaseUtility dlib=new DataBaseUtility();

	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void ConfigBS() {
	/*	Connection con=null;
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "root");*/
		System.out.println("connect to db");
		
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	
	public void ConfigBC(/*String BROWSER*/) throws Throwable {
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
				sDriver=driver;
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


	
