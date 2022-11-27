package vTigerAppPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise {

	@Test(dataProvider = "Phones")
	public void addProductToCartTest(String name,String model,int price,int qty)
	{
		System.out.println(" Phone :"+name+"  Model :"+model+"  Price :"+price+"  Quantity :"+qty);
		
	}
	
	@DataProvider(name="Phones")
	public Object[][] getData()
	{
		Object[][] data=new Object[3][4];  //rows ,column
		
		data[0][0]="Samsung";
		data[0][1]="A80";
		data[0][2]=25000;
		data[0][3]=10;
		
		data[1][0]="IPhone";
		data[1][1]="11 Pro";
		data[1][2]=5000;
		data[1][3]=5;
		
		data[2][0]="Vivo";
		data[2][1]="Y21";
		data[2][2]=10000;
		data[2][3]=15;
		
		return data;
	}
	
	@DataProvider(name="Phones1")
	public Object[][] getData1()
	{
		Object [][] data=new Object[4][2];
		data[0][0]="Qspiders";
		data[0][1]="HealthCare";
		return data;
		
	}
	
}
