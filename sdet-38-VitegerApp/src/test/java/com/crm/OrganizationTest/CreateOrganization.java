package com.crm.OrganizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class CreateOrganization {

	public static void main(String[] args) throws IOException {
		WebDriver driver=null;
		//Read all the common necessary data
		FileInputStream fis = new FileInputStream(".\\data\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		String BROWSER = prop.getProperty("browser");
		
		//Read all the test data from excel sheet
		
		FileInputStream fileExcell = new FileInputStream(".\\data\\Datadriven.xlsx") ;
		Workbook wb = WorkbookFactory.create(fileExcell);
		String orgName = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		
		
		//Launch the browser---- RunTime Polymorphism
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromiumdriver().setup();
			driver=new ChromeDriver();
			
		}else if(BROWSER.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}else {
			System.out.println("invalid browser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		driver.get(URL);
		driver.findElement(By.name(orgName)).sendKeys(args);
		driver.findElement(By.name(orgName)).sendKeys(args);
		driver.findElement(By.name(orgName)).click();
		driver.findElement(By.name(orgName)).click();
		driver.findElement(By.xpath(orgName)).click();
		driver.findElement(By.xpath(orgName)).click();
		
		
		
		

	}

}
