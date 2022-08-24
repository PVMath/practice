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
import com.tms.comcast.pomrepositorylib.AdminLogin;
import com.tms.comcast.pomrepositorylib.CreatePackages;
import com.tms.comcast.pomrepositorylib.Tourpackages;
import com.tms.comcast.pomrepositorylib.UserLogin;
import com.tms.comcast.pomrepositorylib.navigate;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePackageAdmin1 {
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
		AdminLogin AL=new AdminLogin(driver);
		AL.logintoAdmin(ADMIN, PASSWORD1);
		
		
		//Navigate to tourpackages
		Tourpackages TP=new Tourpackages(driver);
		TP.getTourpkg().click();
		TP.getCreatePackages().click();
		
		
		//Create package
		CreatePackages cr=new CreatePackages(driver);
		cr.createPack();
		
		//Navigate to create
	/*	driver.findElement(By.xpath("//a[@href='create-package.php']")).click();
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
		driver.findElement(By.xpath("//button[@type='submit']")).click();*/
		
		//Logout of AdminModule
		AdminLogin AL1=new AdminLogin(driver);
		AL1.logout();
		
		
		
		
		/* WebElement ele = driver.findElement(By.xpath("//i[@class='fa fa-angle-down']"));
		 ele.click();
		//Select se=new Select( ele);
		//se.selectByIndex(1);
		// wlib.select(ele, 1);
		 driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		
		driver.findElement(By.xpath("//a[@href='../index.php']")).click();*/
		
		//Signin to application
		UserLogin UL=new UserLogin(driver);
		UL.logintoUser(USERNAME,PASSWORD);
		
		
		
		
		
		
		/*driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
		Thread.sleep(2000);
		driver.findElement( By.xpath("(//input[@id='email'])[2]")).sendKeys(USERNAME);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		Thread.sleep(2000);*/
		
		//navigate to package and check the package
		navigate nv= new navigate(driver);
		 nv.getPkgverify().click();
		
		//driver.findElement(By.xpath("//a[@href='package-details.php?pkgid=27']")).click();
	}	
}	


