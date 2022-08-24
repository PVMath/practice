package com.tms.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.comcast.genericutility.ExcelUtility;
import com.tms.comcast.genericutility.FileUtility;

public class CreatePackages {
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	
	public CreatePackages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//input[@placeholder='Create Package']")
private WebElement pkgname;
@FindBy(xpath="//input[@name='packagetype']")
private WebElement pkgtype;
@FindBy(xpath="//input[@name='packagelocation']")
private WebElement pkglocation;
@FindBy(xpath="//input[@name='packageprice']")
private WebElement pkgprice;
@FindBy(xpath="//input[@name='packagefeatures']")
private WebElement pkgfeatures;
@FindBy(xpath="//textarea[@placeholder='Package Details']")
private WebElement pkgdetails;
@FindBy(xpath="//input[@type='file']")
private WebElement pkgimg;
@FindBy(xpath="//button[@type='submit']")
private WebElement submitbtn;


public void createPack() throws Throwable 
{
	pkgname.sendKeys(elib.getExcelData("Sheet1", 2, 4));
	pkgtype.sendKeys(elib.getExcelData("Sheet1", 3, 4));
	pkglocation.sendKeys(elib.getExcelData("Sheet1", 4, 4));
	pkgprice.sendKeys(elib.getExcelData("Sheet1", 5, 4));
	pkgfeatures.sendKeys(elib.getExcelData("Sheet1", 6, 4));
	pkgdetails.sendKeys(elib.getExcelData("Sheet1", 7, 4));
	pkgimg.sendKeys("C:\\Users\\PRASHANT\\Desktop\\mysore.jpg");
	submitbtn.click();
}
}
