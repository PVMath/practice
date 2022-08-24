package com.SDET38.VIEJE.TESTNG;

import org.testng.annotations.Test;

import com.tms.comcast.genericutility.BaseClass1;
import com.tms.comcast.genericutility.DataBaseUtility;
import com.tms.comcast.genericutility.ExcelUtility;
import com.tms.comcast.genericutility.FileUtility;
import com.tms.comcast.genericutility.WebDriverUtlity;
import com.tms.comcast.pomrepositorylib.UserLogin;
import com.tms.comcast.pomrepositorylib.WriteUs;

public class writeUs1Test extends BaseClass1{
	WebDriverUtlity wlib=new WebDriverUtlity();
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	DataBaseUtility dlib=new DataBaseUtility();
	@Test(groups = "smokeTest")
	public void issueTest() throws Throwable  {
		
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
		//logout of user
		UserLogin UL1=new UserLogin(driver);
		UL1.getLogoutBtn().click();
		
	}
	}


