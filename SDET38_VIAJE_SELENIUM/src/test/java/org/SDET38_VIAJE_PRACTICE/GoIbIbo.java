package org.SDET38_VIAJE_PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoIbIbo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=null;
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only+Goibibo&utm_term=%21SEM%21DF%21G%21Brand%21RSA%21108599293%216504095653%21602838584772%21e%21goibibo%21c%21&gclid=CjwKCAjwi8iXBhBeEiwAKbUofQq1NQpkX6RSSofnGQtNCyU9bqD-h9wZyg4ZP1DL2Sj2YkO3Q69XbBoChPoQAvD_BwE");
       
		//Actions act=new Actions(driver);
		//act.moveByOffset(10, 10).click().perform();
		
		   driver.findElement(By.xpath("//div[@class='sc-jJoQJp iPfLQ']/descendant::div[@class='sc-hiCibw dGZLZw']")).click();
           
		   driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Banglore");
		   driver.findElement(By.xpath("//span[text()='Bengaluru, India']")).click();

		 //  driver.findElement(By.xpath("//div[@class='sc-jJoQJp iPfLQ']/descendant::div[@class='sc-hiCibw dGZLZw']")).click();
           
		   driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mumbai");
		   driver.findElement(By.xpath("//span[text()='Mumbai, India']")).click();
		   driver.findElement(By.xpath("//div[text()='August 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='27']")).click();
		   driver.findElement(By.xpath("//span[text()='Done']")).click();
		   Thread.sleep(20);
		   driver.findElement(By.xpath("//a[text()='Done']")).click();
		   driver.findElement(By.xpath("//div[text()='August 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='29']")).click();
		   driver.findElement(By.xpath("//span[text()='Done']")).click();
		   driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();
	}

}
