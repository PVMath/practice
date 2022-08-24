package com.tms.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tourpackages {
	public Tourpackages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()=' Tour Packages']")
	private WebElement Tourpkg;
	@FindBy(xpath="//a[@href='create-package.php']")
	private WebElement CreatePackages;
	@FindBy(xpath="//a[@href='manage-packages.php']")
	private WebElement ManagePackages;
	
	
	
	public WebElement getTourpkg() {
		return Tourpkg;
	}
	public WebElement getCreatePackages() {
		return CreatePackages;
	}
	public WebElement getManagePackages() {
		return ManagePackages;
	}
	
	
	
	

}
