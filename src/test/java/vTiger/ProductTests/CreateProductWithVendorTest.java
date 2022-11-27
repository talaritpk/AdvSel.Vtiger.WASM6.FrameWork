package vTiger.ProductTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateProductWithVendorTest {

	@Test
	public void createProduct() throws IOException{
		// 1.create object of all libraries
		JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		WebDriverLibrary wLib = new WebDriverLibrary();

		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");

		String VENDORNAME = eLib.readDataFromExcel("Products", 4, 3);
		String PRODUCTNAME = eLib.readDataFromExcel("Products", 4, 2);

		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid browser name");
		}

		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);

		// 4.Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Navigate to more link and create vendor
		WebElement more = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		wLib.mouseHoverOn(driver, more);
		driver.findElement(By.name("Vendors")).click();
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		driver.findElement(By.name("vendorname")).sendKeys(VENDORNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// validation for vendor creation
		String vendorHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if (vendorHeader.contains(VENDORNAME)) {
			System.out.println("Vendor is created");
		} else {
			System.out.println("Vendor is not created");
		}

		// Navigate to Products link and create product with vendor name
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();

		wLib.switchToWindow(driver, "Vendors");
		driver.findElement(By.name("search_text")).sendKeys(VENDORNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(VENDORNAME)).click();

		wLib.switchToWindow(driver, "Products");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// validation for Product creation
		String productHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if (productHeader.contains(PRODUCTNAME)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

		// 13 sign out from the application
		WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHoverOn(driver, adminImg);
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
