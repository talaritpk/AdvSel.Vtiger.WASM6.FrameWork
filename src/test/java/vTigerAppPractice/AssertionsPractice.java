package vTigerAppPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	@Test
	public void demoTest()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(true, true);
		//Assert.assertEquals(true, false);
		Assert.assertTrue(true);
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
	@Test
	public void demoTest2()
	{
		SoftAssert sa=new SoftAssert();
		
		System.out.println("Step1");
		System.out.println("Step2");
		sa.assertEquals(10, 9);
		
		System.out.println("Step3");
		sa.assertTrue(true);
		System.out.println("Step4");
		sa.assertAll();
	}

}
