package com.tms.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.comcast.genericutility.FileUtility;

public class AdminLogin {
	FileUtility flib=new FileUtility();
public AdminLogin(WebDriver driver) {
	
PageFactory.initElements(driver, this);	
}
@FindBy(xpath="//a[@href='admin/index.php']")
private WebElement admlinbtn;
@FindBy(xpath="//input[@name='username']")
private WebElement Username;
@FindBy(xpath="//input[@name='password']")
private WebElement Password;
@FindBy(xpath="//input[@name='login']")
private WebElement loginBtn;
@FindBy(xpath="//i[@class='fa fa-angle-down']")
private WebElement lgoutdropdown;
@FindBy(xpath="//a[@href='logout.php']")
private WebElement lgoutlnk;
@FindBy(xpath="//a[@href='../index.php']")
private WebElement backtohm;


public WebElement getAdmlinbtn() {
	return admlinbtn;
}
public WebElement getUsername() {
	return Username;
}
public WebElement getPassword() {
	return Password;
}
public WebElement getLoginBtn() {
	return loginBtn;
}
public WebElement getLgoutdropdown() {
	return lgoutdropdown;
}
public WebElement getLgoutlnk() {
	return lgoutlnk;
}
public WebElement getBacktohm() {
	return backtohm;
}
public void logintoAdmin(String admin,String password1) throws Throwable {
	admlinbtn.click();
	Username.sendKeys(flib.getPropertyKeyValue("admin"));
	Password.sendKeys(flib.getPropertyKeyValue("password1"));
	loginBtn.click();
}
public void logout() {
	
	lgoutdropdown.click();
	lgoutlnk.click();
	backtohm.click();
}
}


