package com.SDET38.Manage_Tourpackage;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tms.comcast.genericutility.DataBaseUtility;
import com.tms.comcast.genericutility.ExcelUtility;
import com.tms.comcast.genericutility.FileUtility;
import com.tms.comcast.genericutility.WebDriverUtlity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateAllThePages {
	public static void main(String[] args) throws Throwable {
		
		//Create an Object to Utility
				WebDriverUtlity wlib=new WebDriverUtlity();
				FileUtility flib=new FileUtility();
				ExcelUtility elib=new ExcelUtility();
				DataBaseUtility dlib=new DataBaseUtility();
				WebDriver driver=null;
				
				//Read all the common necessary data
				String URL     =flib.getPropertyKeyValue("url");
				String USERNAME=flib.getPropertyKeyValue("username");
				String PASSWORD=flib.getPropertyKeyValue("password");
				String BROWSER =flib.getPropertyKeyValue("browser");
				String ADMIN   =flib.getPropertyKeyValue("admin");
				String PASSWORD1=flib.getPropertyKeyValue("password1");
		
		//Read all the common necessary data
		/*FileInputStream fis = new FileInputStream(".\\Data\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String ADMIN = prop.getProperty("admin");
		String PASSWORD1 = prop.getProperty("password1");
		String BROWSER = prop.getProperty("browser");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");*/
		
	    //Fetch data from excell sheet
		/*FileInputStream fis1 = new FileInputStream(".\\Data\\TestData Template.xlsx");
		//step 2:create workbook
		Workbook wb = WorkbookFactory.create(fis1);
		//step 3:load sheet
		String Sheet = wb.getSheet("Sheet1").getRow(2).getCell(4).getStringCellValue();
		String Sheet1 = wb.getSheet("Sheet1").getRow(3).getCell(4).getStringCellValue();
		String Sheet2 = wb.getSheet("Sheet1").getRow(4).getCell(4).getStringCellValue();
		  String Sheet3 = wb.getSheet("Sheet1").getRow(5).getCell(4).toString();
		String Sheet4 = wb.getSheet("Sheet1").getRow(6).getCell(4).getStringCellValue();
		String Sheet5 = wb.getSheet("Sheet1").getRow(7).getCell(4).getStringCellValue();*/
		
		//Launch the browser---- RunTime Polymorphism
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromiumdriver().setup();
			driver=new ChromeDriver();
			
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}else {
			System.out.println("invalid browser name");
		}
		wlib.waitForElementInDOM(driver);
		//driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS );
		driver.get(URL);
		
		
		//Login to admin module
		driver.findElement(By.xpath("//a[@href='admin/index.php']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(ADMIN);
		
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD1);
		//Alert ele = driver.switchTo().alert();
		//ele.accept();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Thread.sleep(2000);
		
		
		
		//Navigate to managePages
		driver.findElement(By.xpath("//a[@href='manage-pages.php']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//select[@name='menu1']"));
		ele.click();
		wlib.select(ele, 2);
		
		 driver.findElement(By.xpath("//div[@class=' nicEdit-main']")).click();
			Robot click=new Robot();
			click.keyPress(KeyEvent.VK_CONTROL);
			click.keyPress(KeyEvent.VK_A);
			click.keyRelease(KeyEvent.VK_CONTROL);
			click.keyRelease(KeyEvent.VK_A);
		 driver.findElement(By.xpath("(//div[@class=' nicEdit-button'])[2]")).click();
		 driver.findElement(By.xpath("//button[@name='submit']")).click(); 
		 
		 
			//Logout of AdminModule
		 WebElement ele1 = driver.findElement(By.xpath("//i[@class='fa fa-angle-down']"));
		 ele1.click();
		//Select se=new Select( ele);
		//se.selectByIndex(1);
		// wlib.select(ele, 1);
		 driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		
		driver.findElement(By.xpath("//a[@href='../index.php']")).click();
		
		//Signin to application
		driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
		Thread.sleep(2000);
		driver.findElement( By.xpath("(//input[@id='email'])[2]")).sendKeys(USERNAME);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='page.php?type=privacy']")).click();
	}
			
	}


