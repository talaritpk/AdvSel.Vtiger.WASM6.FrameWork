package vTiger.OrganisationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.BaseClass;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;
import vTiger.ObjectRepository.CreateNewOrganisationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateOrganisationWithIndustry extends BaseClass{

	@Test
	public void createOrganisationWithIndustry() throws EncryptedDocumentException, IOException{
		//1.Read the data
				//FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData1.properties");
				/*JavaLibrary jLib=new JavaLibrary();
				ExcelFileLibrary eLib=new ExcelFileLibrary();
				PropertyFileLibrary pLib=new PropertyFileLibrary();
				WebDriverLibrary wLib=new WebDriverLibrary();
				
				String BROWSER=pLib.readDataFromPropertyFile("browser");
				String URL=pLib.readDataFromPropertyFile("url");
				String UNAME=pLib.readDataFromPropertyFile("username");
				String PWD=pLib.readDataFromPropertyFile("password");*/
				
				String ORGNAME=eLib.readDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
				String INDUSTRY=eLib.readDataFromExcel("Sheet1", 4, 3);
				
				//Properties pobj=new Properties();
				//pobj.load(fis);
				
				/*String BROWSER=pobj.getProperty("browser");
				String URL=pobj.getProperty("url");
				String UNAME=pobj.getProperty("username");
				String PWD=pobj.getProperty("password");
				
				FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				Workbook wb=WorkbookFactory.create(fis1);
				Sheet sh = wb.getSheet("contacts");
				Row rw=sh.getRow(1);
				Cell ce=rw.getCell(2);
				String ORGNAME=ce.getStringCellValue();
				
				Random ran=new Random();
				int value=ran.nextInt(500);
				
				String ORG=ORGNAME+value;*/
				
				
				/*WebDriver driver=null;
				//launch browser
				if(BROWSER.equalsIgnoreCase("Chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver =new ChromeDriver();
					System.out.println("=="+BROWSER+" is Launched ===");
				}
				else if(BROWSER.equalsIgnoreCase("edge"))
				{
					WebDriverManager.edgedriver().setup();
					driver =new EdgeDriver();
					System.out.println("==="+BROWSER+" is Launched ===");
				}
				else
				{
					System.out.println("Provide apllicable browser");
				}
				
				//driver.manage().window().maximize();
				wLib.maximizeWindow(driver);
				driver.get(URL);
				//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				wLib.waitForPageLoad(driver);
				
				//LOGIN TO THE APPLICATION
				//driver.manage().window().maximize();
				//driver.get("http://localhost:8888/");
				//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
				//driver.findElement(By.name("user_name")).sendKeys(UNAME);
				//driver.findElement(By.name("user_password")).sendKeys(PWD);
			
				//driver.findElement(By.id("submitButton")).click();
				LoginPage lp=new LoginPage(driver);
				lp.loginPage(UNAME, PWD);*/
				
				HomePage hp=new HomePage(driver);
				hp.clickOrganizationLnk();
				//driver.findElement(By.linkText("Organizations")).click();
				
				OrganizationsPage op=new OrganizationsPage(driver);
				op.getCreateOrgLookUpImg().click();
				
				CreateNewOrganisationPage cnp=new CreateNewOrganisationPage(driver);
				cnp.createNewOrg(ORGNAME, INDUSTRY);
				
				/*OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				String orgHeader=oip.getOrgHeader();
				if(orgHeader.contains(ORGNAME))
				{
					System.out.println("PASS");
				}
				else {
					System.out.println("FAIL");
				}
				/*driver.findElement(By.xpath("//iMG[@title='Create Organization...']")).click();
				driver.findElement(By.name("accountname")).sendKeys(ORG);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/

				//hp.getSignOutLnk().click();
	}

}
