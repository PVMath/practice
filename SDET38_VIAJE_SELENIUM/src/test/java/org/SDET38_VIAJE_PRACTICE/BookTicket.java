package org.SDET38_VIAJE_PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicket {
	@Test(dataProvider ="dataprovider_bookticketTest")
	public void bookTicketTest(String src,String dst) {
		System.out.println("Book ticket from "+src+" to"+dst);
		
		
	}
@DataProvider
public Object[][] dataProvider_bookTicketTest() {
	Object[][]objArr= new Object[5][2];
	
	objArr[0][0]="Banglore";
	objArr[0][1]="Goa";
	
	objArr[1][0]="Banglore";
	objArr[1][1]="mysore";
	
	objArr[2][0]="Banglore";
	objArr[2][1]="Manglore";
	
	objArr[3][0]="Banglore";
	objArr[3][1]="Banglore";
	return objArr;
}
}
