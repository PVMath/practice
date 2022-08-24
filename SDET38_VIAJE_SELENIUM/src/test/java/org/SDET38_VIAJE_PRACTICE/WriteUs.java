package org.SDET38_VIAJE_PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteUs {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=null;
		//Read all the common necessary data
		FileInputStream fis = new FileInputStream(".\\data1\\COMMONDATA.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		String BROWSER = prop.getProperty("browser");
		String COMMENT = prop.getProperty("comment");
	
		
		
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
		    driver.findElement(By.xpath("(//a[@href='#'])[1]") ).click();
		    Thread.sleep(2000); 
		
		
		 
		    
		 WebElement ele = driver.findElement(By.xpath("//select[@id='country']"));
		 ele.click();
		Select se=new Select( ele);
		se.selectByIndex(1);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='special']")).sendKeys("Abcdef");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
	}

}
