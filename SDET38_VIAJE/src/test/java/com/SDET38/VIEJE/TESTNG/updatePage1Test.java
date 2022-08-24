package com.SDET38.VIEJE.TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tms.comcast.genericutility.BaseClass1;
import com.tms.comcast.genericutility.DataBaseUtility;
import com.tms.comcast.genericutility.ExcelUtility;
import com.tms.comcast.genericutility.FileUtility;
import com.tms.comcast.genericutility.WebDriverUtlity;
import com.tms.comcast.pomrepositorylib.AdminLogin;
import com.tms.comcast.pomrepositorylib.ManagePages;
import com.tms.comcast.pomrepositorylib.UserLogin;

public class updatePage1Test extends BaseClass1{
	WebDriverUtlity wlib=new WebDriverUtlity();
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	DataBaseUtility dlib=new DataBaseUtility();
	@Test(groups = "regressionTest")
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
				
				WebElement we = driver.findElement(By.xpath("//div[text()=':Page data updated  successfully ']"));
				String actual = we.getText();
				System.out.println(actual);
				Assert.assertEquals(actual, "SUCCESS:Page data updated successfully");
				//Logout of AdminModule
				AdminLogin AL1=new AdminLogin(driver);
				AL1.logout();
				
				//Signin to application
				UserLogin UL=new UserLogin(driver);
				UL.logintoUser(USERNAME,PASSWORD);
		
	}
}
