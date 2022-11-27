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
import vTiger.ObjectRepository.CreateNewOrganisationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

//@Listeners(vTiger.GenericLibrary.ListenerImplementationLibrary.class)
public class CreateContactWithOrganization extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void createContactWithOrgTest() throws IOException{
		//1.create object of all libraries
		/*JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		WebDriverLibrary wLib = new WebDriverLibrary();

		// 2.read all the required data
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");*/

		String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2) + jLib.getRandomNumber();
		String ORGNAME=eLib.readDataFromExcel("contacts", 4, 3)+jLib.getRandomNumber();

		/*WebDriver driver = null;
		// 3.launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("invalid browseer name");
		}

		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);

		// 4.Login to application
		LoginPage lp=new LoginPage(driver);
		lp.loginPage(USERNAME, PASSWORD);
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		//5.Navigate to Organizations link
		HomePage hp=new HomePage(driver);
		hp.clickOrganizationLnk();
		//driver.findElement(By.linkText("Organizations")).click();
		
		//6.Navigate to create Organizations lookup image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgLookUpImg().click();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//7.create new Organization and save
		CreateNewOrganisationPage cno=new CreateNewOrganisationPage(driver);
		cno.getOrgNameElement().sendKeys(ORGNAME);
		/*driver.findElement(By.name("accountname")).sendKeys(ORGNAME);*/
		cno.getSaveElement().click(); 
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//8.Validate for Organization
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgHeader=oip.getOrgHeader();
		//String orgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgHeader);
		Assert.assertTrue(orgHeader.contains(ORGNAME), "Organisation Created");
		/*if(orgHeader.contains(ORGNAME)) 
		{
			System.out.println("Organisation created");
		}
		else
		{
			System.out.println("Organisation creation failed");
		}*/
		
		// 9.Navigate to the contacts
		hp.clickContactLnk();
		//driver.findElement(By.xpath("//a[.='Contacts']")).click();

		// 10.Navigate create to contact link lookup image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// 11.Provide create contact with mandatory fields
		CreateNewContactPage cnc=new CreateNewContactPage(driver);
		cnc.getLastnameEdt().sendKeys(LASTNAME);
		//driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		// 12.Select the organization created in org window
		cnc.getOrganizationImg().click();
		
		wLib.switchToWindow(driver, "Accounts");
		cnc.getSearchEdtEdt().sendKeys(ORGNAME);
		cnc.getSearchBtn().click();
		cnc.getSelectOrg().click();
		wLib.switchToWindow(driver, "Contacts");
		//driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		//driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		//driver.findElement(By.linkText(ORGNAME)).click();
		//driver.findElement(By.name("search")).click();
		
		cnc.getSaveBtn().click();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//13.Validate for Contact
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String contactHeader=cip.getContactHeader();
		//String contactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		Assert.assertTrue(contactHeader.contains(LASTNAME), "Contact Created");
		/*
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
			wLib.takeScreenShot(driver, "CreateContactWithOrganization");
		}*/
		
		
		//13 sign out from the application
		//WebElement adminImg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//wLib.mouseHoverOn(driver, adminImg);
		//hp.signOutOfApp(driver);
		//driver.findElement(By.linkText("Sign Out")).click();*/
	}
	
	@Test(groups = "RegressionSuite")
	public void demoRegionalRegression()
	{
		System.out.println("This is regional regression ");
		HomePage hp=new HomePage(driver);
		hp.clickOrganizationLnk();
		//Assert.fail();
	}

}
