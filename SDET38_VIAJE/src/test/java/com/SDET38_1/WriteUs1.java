package com.SDET38_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tms.comcast.genericutility.DataBaseUtility;
import com.tms.comcast.genericutility.ExcelUtility;
import com.tms.comcast.genericutility.FileUtility;
import com.tms.comcast.genericutility.WebDriverUtlity;
import com.tms.comcast.pomrepositorylib.UserLogin;
import com.tms.comcast.pomrepositorylib.WriteUs;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteUs1 {

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
				String COMMENT =flib.getPropertyKeyValue("comment");
				
				
				
				
				
				/*FileInputStream fis = new FileInputStream(".\\Data\\CommonData.properties");
				Properties prop = new Properties();
				prop.load(fis);
				String URL = prop.getProperty("url");
				String USERNAME = prop.getProperty("username");
				String PASSWORD = prop.getProperty("password");
				String BROWSER = prop.getProperty("browser");
				String COMMENT = prop.getProperty("comment");
			
				
				*/
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
				//Signin to application
				UserLogin UL=new UserLogin(driver);
				UL.logintoUser(USERNAME,PASSWORD);
				
				
				
				/*driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
				
				driver.findElement( By.xpath("(//input[@id='email'])[2]")).sendKeys(USERNAME);
				
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
				
				driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();*/
				
				  
				//Verification of write us
				WriteUs WS=new WriteUs(driver);
				WS.wrtUs();
				
				
				
			/*	driver.findElement(By.xpath("(//a[@href='#'])[1]") ).click();
			   
			    WebElement ele = driver.findElement(By.xpath("//select[@id='country']"));
				ele.click();
				//Select se=new Select( ele);
				//se.selectByIndex(1);
				wlib.select(ele, 1);
				
				driver.findElement(By.xpath("//input[@class='special']")).sendKeys("Abcdef");
				
				driver.findElement(By.xpath("//button[@type='submit']")).click();*/
				UserLogin UL1=new UserLogin(driver);
				UL1.getLogoutBtn().click();
				
			}

		

	}


