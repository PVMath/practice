package com.SDET38_1;

import org.testng.annotations.Test;

import com.tms.comcast.genericutility.BaseClass;
import com.tms.comcast.pomrepositorylib.ManagePackages;
import com.tms.comcast.pomrepositorylib.ManagePages;

public class updatePageTest extends BaseClass{
	@Test
	public void privacyPageTest() throws Throwable {
		//Navigate to managePages
		ManagePages MP=new ManagePages(driver);
		MP.mngpage();
		
	}

}
