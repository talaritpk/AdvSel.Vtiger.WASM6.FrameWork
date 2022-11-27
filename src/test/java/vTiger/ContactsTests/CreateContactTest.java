package vTiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.BaseClass;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

@Listeners(vTiger.GenericLibrary.ListenerImplementationLibrary.class)
public class CreateContactTest extends BaseClass {
	
	@Test(groups = "RegressionSuite")
	public void createContactTest() throws IOException {
		//1.create object of all libraries
		/*JavaLibrary jLib=new JavaLibrary();
		PropertyFileLibrary pLib=new PropertyFileLibrary();
		ExcelFileLibrary eLibLib=new WebDriverLibrary();
		
		//2.read all the required data
		String BROWSER=new ExcelFileLibrary();
		WebDriverLibrary w=pLib.readDataFromPropertyFile("browser");
		String URL=pLib.readDataFromPropertyFile("url");
		String USERNAME=pLib.readDataFromPropertyFile("username");
		String PASSWORD=pLib.readDataFromPropertyFile("password");*/
		
		String LASTNAME=eLib.readDataFromExcel("Contacts", 1, 2)+jLib.getRandomNumber();
		
		/*WebDriver driver=null;
		//3.launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("invalid browseer name");
		}
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		//4.Login to application
		LoginPage lP=new LoginPage(driver);
		lP.loginPage(USERNAME, PASSWORD);
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		//5.Navigate to the contacts
		HomePage hp=new HomePage(driver);
		hp.clickContactLnk();
		//Assert.fail();
		//driver.findElement(By.xpath("//a[.='Contacts']")).click();
		
		//6.Navigate create to contact link
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		
		//7.Provide create contact with mandatory fields
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.createNewContact(LASTNAME);
		/*driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
		
		//8.Validation
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String contactHeader=cip.getContactHeader();
		//String contactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		/*if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}*/
		
		//9.Logout from application
		//hp.signOutOfApp(driver);
		/*WebElement adminImg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHoverOn(driver, adminImg);
		driver.findElement(By.linkText("Sign Out")).click();*/
	}
	
	@Test
	public void createContactDemoTest()
	{
		System.out.println("Demo test");
		//Assert.fail();
	}
	
	@Test
	public void createContactWithLeadSource()
	{
		System.out.println("Lead Source");
		//Assert.fail();
	}
	
	@Test
	public void createContactWithLeadSourceAndOrg()
	{
		System.out.println("Lead Source with Org");
		//Assert.fail();
	}
}
