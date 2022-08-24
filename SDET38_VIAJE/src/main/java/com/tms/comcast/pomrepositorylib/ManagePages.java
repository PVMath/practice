package com.tms.comcast.pomrepositorylib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.comcast.genericutility.WebDriverUtlity;

public class ManagePages {
	WebDriver driver;
	WebDriverUtlity wlib=new WebDriverUtlity();
	public ManagePages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='manage-pages.php']")
	private WebElement Mngpages;
	@FindBy(xpath="//select[@name='menu1']")
	public WebElement selectpagedropdown;
	@FindBy(xpath="//div[@class=' nicEdit-main']")
	private WebElement pkgdetails;
	@FindBy(xpath="(//div[@class=' nicEdit-button'])[2]")
	private WebElement boldbtn;
	@FindBy(xpath="//button[@name='submit']")
	private WebElement updatebtn;
	
	
	
public void mngpage() throws AWTException {
	Mngpages.click();
	selectpagedropdown.click();
	wlib.select(selectpagedropdown, 2);
	Robot click=new Robot();
	click.keyPress(KeyEvent.VK_CONTROL);
	click.keyPress(KeyEvent.VK_A);
	click.keyRelease(KeyEvent.VK_CONTROL);
	click.keyRelease(KeyEvent.VK_A);
	boldbtn.click();
	updatebtn.click();
	
}
	
	
	
	
}
