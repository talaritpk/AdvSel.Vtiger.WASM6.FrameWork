package vTigerAppPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

	@Test
	public void createCustomer()
	{
		
		System.out.println("Customer created");
	}
	
	@Test(enabled=false,invocationCount = 0)
	public void modifyCustomer()
	{
		//Assert.fail(); //used to purposefully fail the test case
		System.out.println("Customer modified");
	}
	
	@Test//(dependsOnMethods = {"createCustomer","modifyCustomer"})
	public void deleteCustomer()
	{
		System.out.println("Customer deleted");
	}
	
	//we can disable the test scripts with the help of 
	//invocation count=0 and enabled=false and also by using dependsOnMethods 
	//@ignore also used to disable the test script have to mention @ignore above @Test
}
