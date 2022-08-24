package com.SDET38_1;

import org.testng.annotations.Test;

import com.tms.comcast.genericutility.BaseClass;
import com.tms.comcast.pomrepositorylib.ManagePackages;
import com.tms.comcast.pomrepositorylib.Tourpackages;

public class tourpackage_ManageVerificationTest extends BaseClass{
	@Test
	public void tourPackageTest() throws Throwable {
		//Navigate to tourpackages
		Tourpackages TP=new Tourpackages(driver);
		TP.getTourpkg().click();
		TP.getManagePackages().click();
		//Navigate to manage
				ManagePackages MP=new ManagePackages(driver);
				MP.updatepkg();
	}
	

}
