package com.SDET38.Manage_Tourpackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.tms.comcast.genericutility.BaseClass1;
import com.tms.comcast.genericutility.DataBaseUtility;
import com.tms.comcast.genericutility.ExcelUtility;
import com.tms.comcast.genericutility.FileUtility;
import com.tms.comcast.genericutility.WebDriverUtlity;
import com.tms.comcast.pomrepositorylib.AdminLogin;
import com.tms.comcast.pomrepositorylib.CreatePackages;
import com.tms.comcast.pomrepositorylib.ManagePackages;
import com.tms.comcast.pomrepositorylib.ManagePages;
import com.tms.comcast.pomrepositorylib.Tourpackages;
import com.tms.comcast.pomrepositorylib.UserLogin;
import com.tms.comcast.pomrepositorylib.WriteUs;
import com.tms.comcast.pomrepositorylib.manageBook1;

public class Admin1 extends BaseClass1 {
	
	 //Create an Object to Utility
	public WebDriverUtlity wlib=new WebDriverUtlity();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public DataBaseUtility dlib=new DataBaseUtility();
	
	
	
	
	@Test(priority=1)
public void  createPackageAdminTest() throws Throwable  {
		
		//Read all the common necessary data
		String URL     =flib.getPropertyKeyValue("url");
		String USERNAME=flib.getPropertyKeyValue("username");
		String PASSWORD=flib.getPropertyKeyValue("password");
		String BROWSER =flib.getPropertyKeyValue("browser");
		
		String ADMIN   =flib.getPropertyKeyValue("admin");
		String PASSWORD1=flib.getPropertyKeyValue("password1");
		driver.get(URL);
		
		
		
		//Login to admin module
		AdminLogin AL=new AdminLogin(driver);
		AL.logintoAdmin(ADMIN, PASSWORD1);
		

		//Navigate to tourpackages
		Tourpackages TP=new Tourpackages(driver);
		TP.getTourpkg().click();
		TP.getCreatePackages().click();
		
		//Create package
		CreatePackages cr=new CreatePackages(driver);
		cr.createPack();
		//Logout of AdminModule
				AdminLogin AL1=new AdminLogin(driver);
				AL1.logout();
				//Signin to application
				UserLogin UL=new UserLogin(driver);
				UL.logintoUser(USERNAME,PASSWORD);
				
	}
	@Test(priority=5)
	public void manageBookingTest() throws Throwable {
		
		
		//Read all the common necessary data
		String URL     =flib.getPropertyKeyValue("url");
		String USERNAME=flib.getPropertyKeyValue("username");
		String PASSWORD=flib.getPropertyKeyValue("password");
		String BROWSER =flib.getPropertyKeyValue("browser");
		
		String ADMIN   =flib.getPropertyKeyValue("admin");
		String PASSWORD1=flib.getPropertyKeyValue("password1");
		driver.get(URL);
		
		//Login to admin module
		AdminLogin AL=new AdminLogin(driver);
		AL.logintoAdmin(ADMIN, PASSWORD1);
		
		
		manageBook1 MB=new manageBook1(driver);
		MB.managebook();
	}
	@Test(priority=3)
	public void tourPackageTest() throws Throwable {
		
		//Read all the common necessary data
		String URL     =flib.getPropertyKeyValue("url");
		String USERNAME=flib.getPropertyKeyValue("username");
		String PASSWORD=flib.getPropertyKeyValue("password");
		String BROWSER =flib.getPropertyKeyValue("browser");
		
		String ADMIN   =flib.getPropertyKeyValue("admin");
		String PASSWORD1=flib.getPropertyKeyValue("password1");
		driver.get(URL);
		
		
		
		
		//Login to admin module
				AdminLogin AL=new AdminLogin(driver);
				AL.logintoAdmin(ADMIN, PASSWORD1);
		
		
		//Navigate to tourpackages
				Tourpackages TP=new Tourpackages(driver);
				TP.getTourpkg().click();
				TP.getManagePackages().click();
				//Navigate to manage
						ManagePackages MP=new ManagePackages(driver);
						MP.updatepkg();
						
						//Logout of AdminModule
						AdminLogin AL1=new AdminLogin(driver);
						AL1.logout();
						//Signin to application
						UserLogin UL=new UserLogin(driver);
						UL.logintoUser(USERNAME,PASSWORD);
	}
	@Test(priority=2)
	public void privacyPageTest() throws Throwable {
		
		//Read all the common necessary data
		String URL     =flib.getPropertyKeyValue("url");
		String USERNAME=flib.getPropertyKeyValue("username");
		String PASSWORD=flib.getPropertyKeyValue("password");
		String BROWSER =flib.getPropertyKeyValue("browser");
		
		String ADMIN   =flib.getPropertyKeyValue("admin");
		String PASSWORD1=flib.getPropertyKeyValue("password1");
		driver.get(URL);
		
		//Login to admin module
				AdminLogin AL=new AdminLogin(driver);
				AL.logintoAdmin(ADMIN, PASSWORD1);
				
		
		
		//Navigate to managePages
				ManagePages MP=new ManagePages(driver);
				MP.mngpage();
				
				//Logout of AdminModule
				AdminLogin AL1=new AdminLogin(driver);
				AL1.logout();
				
				//Signin to application
				UserLogin UL=new UserLogin(driver);
				UL.logintoUser(USERNAME,PASSWORD);
		
	}
	@Test(priority=4)
	public void writeUsTest() throws Throwable {
		
		//Read all the common necessary data
		String URL     =flib.getPropertyKeyValue("url");
		String USERNAME=flib.getPropertyKeyValue("username");
		String PASSWORD=flib.getPropertyKeyValue("password");
		String BROWSER =flib.getPropertyKeyValue("browser");
		
		String ADMIN   =flib.getPropertyKeyValue("admin");
		String PASSWORD1=flib.getPropertyKeyValue("password1");
		driver.get(URL);
		
		//Signin to application
		UserLogin UL=new UserLogin(driver);
		UL.logintoUser(USERNAME,PASSWORD);
		//Verification of write us
		WriteUs WS=new WriteUs(driver);
		WS.wrtUs();
		
	}
	
}
