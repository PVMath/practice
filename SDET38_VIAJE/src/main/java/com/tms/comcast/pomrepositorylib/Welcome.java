package com.tms.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Welcome {
public Welcome(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="")
private WebElement adminloginbtn;
@FindBy(xpath="")
private WebElement WriteUsBtn;


public WebElement getAdminloginbtn() {
	return adminloginbtn;
}
public WebElement getWriteUsBtn() {
	return WriteUsBtn;
}
}
