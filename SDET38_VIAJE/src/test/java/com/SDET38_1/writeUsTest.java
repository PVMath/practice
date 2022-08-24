package com.SDET38_1;

import org.testng.annotations.Test;

import com.tms.comcast.genericutility.BaseClass1;
import com.tms.comcast.genericutility.DataBaseUtility;
import com.tms.comcast.genericutility.ExcelUtility;
import com.tms.comcast.genericutility.FileUtility;
import com.tms.comcast.genericutility.WebDriverUtlity;
import com.tms.comcast.pomrepositorylib.UserLogin;
import com.tms.comcast.pomrepositorylib.WriteUs;

public class writeUsTest extends BaseClass1 {
	public WebDriverUtlity wlib=new WebDriverUtlity();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public DataBaseUtility dlib=new DataBaseUtility();

@Test
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
