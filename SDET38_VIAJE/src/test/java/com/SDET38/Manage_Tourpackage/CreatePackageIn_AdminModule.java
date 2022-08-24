package com.SDET38.Manage_Tourpackage;

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
import org.openqa.selenium.support.ui.Select;

import com.tms.comcast.genericutility.DataBaseUtility;
import com.tms.comcast.genericutility.ExcelUtility;
import com.tms.comcast.genericutility.FileUtility;
import com.tms.comcast.genericutility.WebDriverUtlity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePackageIn_AdminModule {
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
		String Sheet =elib.getExcelData("Sheet1", 2, 4);
		String Sheet1=elib.getExcelData("Sheet1", 3, 4);
		String Sheet2=elib.getExcelData("Sheet1", 4, 4);
		String Sheet3=elib.getExcelData("Sheet1", 5, 4);
		String Sheet4=elib.getExcelData("Sheet1", 6, 4);
		String Sheet5=elib.getExcelData("Sheet1", 7, 4);
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
		
		//Navigate to tourpackages
		driver.findElement(By.xpath("//span[text()=' Tour Packages']")).click();
		Thread.sleep(2000);
		
		//Navigate to create
		driver.findElement(By.xpath("//a[@href='create-package.php']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Create Package']")).sendKeys(Sheet);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='packagetype']")).sendKeys(Sheet1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='packagelocation']")).sendKeys(Sheet2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='packageprice']")).sendKeys(Sheet3);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='packagefeatures']")).sendKeys(Sheet4);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@placeholder='Package Details']")).sendKeys(Sheet5);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\PRASHANT\\Desktop\\mysore.jpg");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Logout of AdminModule
		 WebElement ele = driver.findElement(By.xpath("//i[@class='fa fa-angle-down']"));
		 ele.click();
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
		
		//navigate to package and check the package
		driver.findElement(By.xpath("//a[@href='package-details.php?pkgid=27']")).click();
	}	
}


