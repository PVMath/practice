package org.sdet38_vije;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympic {

	public static void main(String[] args) {
	WebDriverManager.firefoxdriver().setup();
    WebDriver driver=new FirefoxDriver();
    driver.get("https://olympics.com/en/");
    driver.findElement(By.xpath("//span[text()='Kaylee MCKEOWN']/ancestor::li[@class='b2p-list__item position-relative']/descendant::span[@class='result-medal result-medal--gold']")).click();
    
	}

}
