package org.SDET38_VIAJE_PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A {
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver d=new FirefoxDriver();
	}

}
