package org.SDET38_VIAJE_PRACTICE;

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
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePackage {

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
		
		driver.findElement(By.xpath("/html/body/div[5]/div/form/div[2]/div/ul/li[1]/input")).sendKeys(COMMENT);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@name='submit2'])")).click();
	}
}
