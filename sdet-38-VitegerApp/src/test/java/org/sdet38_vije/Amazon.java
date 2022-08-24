package org.sdet38_vije;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SendKeysAction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	
		public static void main(String[] args)
		{
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.amazon.com/");
		    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("redmenote10pro");
		    driver.findElement(By.xpath("//input[@type='submit']")).click();
		    driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='sg-col-inner']/descendant::span[contains(text(),239)]")).click();
	}


	}


