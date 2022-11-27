package vTigerAppPractice;

import java.io.IOException;

import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;

public class GenericMethodPractice {

	public static void main(String[] args) throws IOException {
		JavaLibrary w=new JavaLibrary();
		
		String date=w.getSystemDate();
		System.out.println(date);
		
		String date1=w.getSystemDateInFormat();
		System.out.println(date1);
		
		PropertyFileLibrary pf=new PropertyFileLibrary();
		String value=pf.readDataFromPropertyFile("username");
		System.out.println(value);
		
		ExcelFileLibrary efl=new ExcelFileLibrary();
		String value1=efl.readDataFromExcel("contacts",0,1);
		System.out.println(value1);
		int count=efl.getRowCount("contacts");
		System.out.println(count);
		efl.writeDataIntoExcel("contacts",1,6,"kumar");
		
	}

}
