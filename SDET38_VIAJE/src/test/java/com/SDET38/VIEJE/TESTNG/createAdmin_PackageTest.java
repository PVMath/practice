package com.SDET38.VIEJE.TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tms.comcast.genericutility.BaseClass1;
import com.tms.comcast.genericutility.DataBaseUtility;
import com.tms.comcast.genericutility.ExcelUtility;
import com.tms.comcast.genericutility.FileUtility;
import com.tms.comcast.genericutility.WebDriverUtlity;
import com.tms.comcast.pomrepositorylib.AdminLogin;
import com.tms.comcast.pomrepositorylib.CreatePackages;
import com.tms.comcast.pomrepositorylib.Tourpackages;
import com.tms.comcast.pomrepositorylib.UserLogin;
@Listeners(com.tms.comcast.genericutility.ListImpClass.class)
public class createAdmin_PackageTest extends BaseClass1 {
	WebDriverUtlity wlib=new WebDriverUtlity();
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	DataBaseUtility dlib=new DataBaseUtility();


	@Test(groups = "regressionTest")
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
		//Assert.fail();
		WebElement we = driver.findElement(By.xpath("//div[text()=':Package Created Successfully ']"));
		String actual = we.getText();
		System.out.println(actual);
		Assert.assertEquals(actual, "SUCCESS:Package Created Successfully");


		//Logout of AdminModule
		AdminLogin AL1=new AdminLogin(driver);
		AL1.logout();
		//Signin to application
		UserLogin UL=new UserLogin(driver);
		UL.logintoUser(USERNAME,PASSWORD);

	}



}
