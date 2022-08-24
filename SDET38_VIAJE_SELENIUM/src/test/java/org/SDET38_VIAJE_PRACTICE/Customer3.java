package org.SDET38_VIAJE_PRACTICE;

import org.testng.annotations.Test;

public class Customer3 {
	@Test(invocationCount=4)
	public void createCustomerTest() {
		System.out.println("execute HDFC createCustomerTest");
	}
	@Test
	public void modifyCustomerTest() {
		System.out.println("execute modify HDFC to AIRTEL CustomerTest");
	}
    @Test
    public void deleteCustomerTest() {
    	System.out.println("execute HDFC delete customerTest");
    }
}
