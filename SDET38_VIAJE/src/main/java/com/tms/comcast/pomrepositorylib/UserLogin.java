package com.tms.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.comcast.genericutility.FileUtility;

public class UserLogin {
	FileUtility flib=new FileUtility();
	public UserLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[.='/ Sign In']")
	private WebElement Signin;
@FindBy(xpath="//input[@placeholder='Enter your Email']")
private WebElement UserName;
@FindBy(xpath="//input[@id='password']")
private WebElement Password;
@FindBy(xpath="//input[@value='SIGNIN']")
private WebElement Submitbtn;
@FindBy(xpath="//a[@href='logout.php']")
private WebElement logoutBtn;



public WebElement getSignin() {
	return Signin;
}
public WebElement getLogoutBtn() {
	return logoutBtn;
}
public WebElement getUserName() {
	return UserName;
}
public WebElement getPassword() {
	return Password;
}
public WebElement getSubmitbtn() {
	return Submitbtn;
}
public void logintoUser(String username,String password) throws Throwable {
	Signin.click();
	UserName.sendKeys(flib.getPropertyKeyValue("username"));
	Password.sendKeys(flib.getPropertyKeyValue("password"));
	Submitbtn.click();
}

}
