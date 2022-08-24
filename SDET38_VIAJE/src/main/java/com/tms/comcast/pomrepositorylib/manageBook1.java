package com.tms.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.comcast.genericutility.WebDriverUtlity;

public class manageBook1 {
	WebDriver driver;
	WebDriverUtlity wlib=new WebDriverUtlity();
	public manageBook1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Manage Booking']")
	private WebElement mngbooking;
	@FindBy(xpath="//span[@class='fa fa-bars']")
	private WebElement element;
	@FindBy(xpath="//a[text()='Cancel' and href='manage-bookings.php?bkid=11']")
	private WebElement cancel;
	
	
	public void managebook() {
		mngbooking.click();	
		element.click();
		driver.manage().window().maximize();
		cancel.click();
		wlib.swithToAlertWindowAndAccpect(driver, null);
	}
	
}
