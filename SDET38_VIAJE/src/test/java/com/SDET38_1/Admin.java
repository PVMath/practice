package com.SDET38_1;

import org.testng.annotations.Test;

import com.tms.comcast.genericutility.BaseClass;
import com.tms.comcast.pomrepositorylib.CreatePackages;
import com.tms.comcast.pomrepositorylib.ManagePackages;
import com.tms.comcast.pomrepositorylib.ManagePages;
import com.tms.comcast.pomrepositorylib.Tourpackages;
import com.tms.comcast.pomrepositorylib.manageBook1;

public class Admin extends BaseClass{
	@Test(priority=1)
public void  createPackageAdminTest() throws Throwable  {
		

		//Navigate to tourpackages
		Tourpackages TP=new Tourpackages(driver);
		TP.getTourpkg().click();
		TP.getCreatePackages().click();
		
		//Create package
		CreatePackages cr=new CreatePackages(driver);
		cr.createPack();
	}
	@Test(priority=4)
	public void manageBookingTest() {
		manageBook1 MB=new manageBook1(driver);
		MB.managebook();
	}
	@Test(priority=3)
	public void tourPackageTest() throws Throwable {
		//Navigate to tourpackages
				Tourpackages TP=new Tourpackages(driver);
				TP.getTourpkg().click();
				TP.getManagePackages().click();
				//Navigate to manage
						ManagePackages MP=new ManagePackages(driver);
						MP.updatepkg();
	}
	@Test(priority=2)
	public void privacyPageTest() throws Throwable {
		//Navigate to managePages
				ManagePages MP=new ManagePages(driver);
				MP.mngpage();
		
	}
	
	
	
	
}
