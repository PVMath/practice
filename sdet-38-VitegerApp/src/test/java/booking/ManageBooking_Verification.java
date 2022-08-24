package booking;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tms.comcast.genericutility.DataBaseUtility;
import com.tms.comcast.genericutility.ExcelUtility;
import com.tms.comcast.genericutility.FileUtility;
import com.tms.comcast.genericutility.WebDriverUtlity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageBooking_Verification {
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
			String BROWSER = prop.getProperty("browser");*/
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
		//	ele.accept();
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='Sign In']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='Manage Booking']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='fa fa-bars']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Cancel' and href='manage-bookings.php?bkid=11']")).click();
			Thread.sleep(2000);
			//Alert ele = driver.switchTo().alert();
			//ele.accept();
			wlib.swithToAlertWindowAndAccpect(driver, PASSWORD1);
	}

}
