package vTigerAppPractice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;
import vTiger.ObjectRepository.LoginPage;

public class reafFromCmdTest{
	public JavaLibrary jLib=new JavaLibrary();
	public PropertyFileLibrary pLib=new PropertyFileLibrary();
	public ExcelFileLibrary eLib=new ExcelFileLibrary();
	public WebDriverLibrary wLib=new WebDriverLibrary();
	public WebDriver driver=null;
	@Test
	public void readDataFromCmd() throws IOException
	{
		String BROWSER=pLib.readDataFromPropertyFile("browser");//
		String URL=pLib.readDataFromPropertyFile("url");
		String USERNAME=pLib.readDataFromPropertyFile("username");
		String PASSWORD=pLib.readDataFromPropertyFile("password");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Reporter.log("---Browser Launched---",true);
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			Reporter.log("---Browser Launched---",true);
		}
		else
		{
			System.out.println("invalid browseer name");
		}
		
		
		
		
		LoginPage lp=new LoginPage(driver);
		lp.loginPage(USERNAME, PASSWORD);
		Reporter.log("---LogIn Successful---",true);
		System.out.println("********From Ecclipse*********");
	}

}
