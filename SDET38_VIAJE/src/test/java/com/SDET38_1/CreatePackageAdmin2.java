package com.SDET38_1;

import org.testng.annotations.Test;

import com.tms.comcast.genericutility.BaseClass;
import com.tms.comcast.pomrepositorylib.AdminLogin;
import com.tms.comcast.pomrepositorylib.CreatePackages;
import com.tms.comcast.pomrepositorylib.Tourpackages;
import com.tms.comcast.pomrepositorylib.UserLogin;

public class CreatePackageAdmin2 extends BaseClass {
	@Test
	public void createPackageTest() throws Throwable {
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
	

}
