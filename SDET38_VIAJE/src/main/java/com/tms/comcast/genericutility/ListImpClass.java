package com.tms.comcast.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImpClass implements ITestListener{
public void onTestFailure(ITestResult result) {
		
	
		String testname=result.getMethod().getMethodName();
		System.out.println(testname+"execute i m listening");
        JavaUtility JU= new JavaUtility();
		String Date = JU.getSystemDate();
		int randum = JU.getRanDomNumber();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass1.sDriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./screenshot/"+testname+Date+randum+".png"));
		}
				 catch(IOException e) {
					 e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}


