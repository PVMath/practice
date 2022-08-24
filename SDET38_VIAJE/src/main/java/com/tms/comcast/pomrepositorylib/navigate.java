package com.tms.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.comcast.genericutility.ExcelUtility;
import com.tms.comcast.genericutility.FileUtility;

public class navigate {
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	
	public navigate(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//a[@href='package-details.php?pkgid=27']")
private WebElement pkgverify;
@FindBy(xpath="//a[@href='package-details.php?pkgid=1']")
private WebElement manageVerification;
@FindBy(xpath="//a[@href='page.php?type=privacy']")
private WebElement privacypage;


public WebElement getPkgverify() {
	return pkgverify;
}
public WebElement getManageVerification() {
	return manageVerification;
}
public WebElement getPrivacypage() {
	return privacypage;
}





}
