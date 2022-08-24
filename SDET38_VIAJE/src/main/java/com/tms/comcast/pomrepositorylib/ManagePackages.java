package com.tms.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.comcast.genericutility.ExcelUtility;
import com.tms.comcast.genericutility.FileUtility;

public class ManagePackages {
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	public ManagePackages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Manali Trip ']/ancestor::tr/descendant::button[@type='button']")
	private WebElement viewdetails;

@FindBy(xpath="//input[@id='packagetype']")
private WebElement pkgtype;
@FindBy(xpath="//input[@id='packagelocation']")
private WebElement pkglocation;
@FindBy(xpath="//input[@id='packageprice']")
private WebElement pkgprice;
@FindBy(xpath="//input[@id='packagefeatures']")
private WebElement pkgfeatures;
@FindBy(xpath="//textarea[@id='packagedetails']")
private WebElement pkgdetails;
@FindBy(xpath="//a[@href='change-image.php?imgid=1']")
private WebElement pkgimg;
@FindBy(xpath="//button[@type='submit']")
private WebElement submitbtn;


public void updatepkg() throws Throwable {
	viewdetails.click();
	pkgtype.clear();
	pkgtype.sendKeys(elib.getExcelData("Sheet1", 3, 4));
	pkglocation.clear();
	pkglocation.sendKeys(elib.getExcelData("Sheet1", 4, 4));
	pkgprice.clear();
	pkgprice.sendKeys(elib.getExcelData("Sheet1", 5, 4));
	pkgfeatures.clear();
	pkgfeatures.sendKeys(elib.getExcelData("Sheet1", 6, 4));
	pkgdetails.clear();
	pkgdetails.sendKeys(elib.getExcelData("Sheet1", 7, 4));
	
	pkgimg.sendKeys("C:\\Users\\PRASHANT\\Desktop\\mysore.jpg");
	submitbtn.click();
	
}

}
