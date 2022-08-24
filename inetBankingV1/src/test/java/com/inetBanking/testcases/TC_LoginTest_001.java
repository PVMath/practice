package com.inetBanking.testcases;

import org.junit.Assert;

import com.inetBankingPageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	public void loginTest() {
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(baseURL);
		lp.clickSubmit();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
		Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

}
