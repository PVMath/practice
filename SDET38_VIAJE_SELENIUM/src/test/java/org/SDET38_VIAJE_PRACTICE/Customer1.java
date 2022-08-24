package org.SDET38_VIAJE_PRACTICE;

import org.testng.annotations.Test;

public class Customer1 {
	@Test(priority=1)
	public void createCustomer() {
		System.out.println("execute");
		
	}
	@Test(priority=2)
	public void modifyCustomer() {
		System.out.println("modify");
	}
	@Test(priority=3)
	public void deleteCustomer() {
		System.out.println("delete");
	}

}
