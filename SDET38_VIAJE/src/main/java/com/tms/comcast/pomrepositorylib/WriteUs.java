package com.tms.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.comcast.genericutility.WebDriverUtlity;

public class WriteUs {
	WebDriver driver;
	WebDriverUtlity wlib=new WebDriverUtlity();
public WriteUs(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);	
}
@FindBy(xpath="(//a[@href='#'])[1]")
private WebElement WriteUs;
@FindBy(xpath="//select[@id='country']")
public WebElement Selectisudropdown;
@FindBy(xpath="//input[@placeholder='description']")
private WebElement description;
@FindBy(xpath="//button[@type='submit']")
private WebElement submitbtn;


public void wrtUs() {
	WriteUs.click();
	Selectisudropdown.click();
	wlib.select(Selectisudropdown, 1);
	description.sendKeys("ahvgcfc");;
	submitbtn.click();
}




}
