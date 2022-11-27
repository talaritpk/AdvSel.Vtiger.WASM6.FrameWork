package vTigerAppPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactwithORGWithDDT {

	public static void main(String[] args) throws IOException {
		//1.Read the data
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		Properties pobj=new Properties();
		pobj.load(fis);
		
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String UNAME=pobj.getProperty("username");
		String PWD=pobj.getProperty("password");
		
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contacts");
		Row rw=sh.getRow(1);
		Cell ce=rw.getCell(1);
		String value=ce.getStringCellValue();
		
		
		WebDriver driver=null;
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
		
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//LOGIN TO THE APPLICATION
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(UNAME);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
	
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[.='Contacts'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(value);
		driver.findElement(By.xpath("(//input[@name='button' and @value='  Save  '])[1]"));
		
		Actions a=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		a.moveToElement(ele).perform();
		driver.findElement(By.xpath("(//a[@class='drop_down_usersettings'])[2]")).click();
		
		driver.close();
		
		
		

	}

}
