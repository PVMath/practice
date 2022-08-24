package com.SDET38.Manage_Tourpackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tms.comcast.genericutility.DataBaseUtility;
import com.tms.comcast.genericutility.ExcelUtility;
import com.tms.comcast.genericutility.FileUtility;
import com.tms.comcast.genericutility.WebDriverUtlity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Package {
	public static void main(String[] args) throws Throwable {
		
		
		//Create an Object to Utility
		WebDriverUtlity wlib=new com.tms.comcast.genericutility.WebDriverUtlity();
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

		
		
		
		
		/*//Read all the common necessary data
		FileInputStream fis = new FileInputStream(".\\data1\\COMMONDATA.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		String BROWSER = prop.getProperty("browser");
		String COMMENT = prop.getProperty("comment");*/
	
		
		
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
		
		driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS );
		driver.get(URL);
		driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
		Thread.sleep(2000);
		driver.findElement( By.xpath("(//input[@id='email'])[2]")).sendKeys(USERNAME);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='package-list.php']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='view']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@href='#'])[38]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='datepicker1'])")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@href='#'])[41]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div[5]/div/form/div[2]/div/ul/li[1]/input")).sendKeys();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@name='submit2'])")).click();
	}
}


