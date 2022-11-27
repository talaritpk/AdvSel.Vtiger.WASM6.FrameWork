package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class HomePage extends WebDriverLibrary {
	
	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminstrativeImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getAdminstrativeImg() {
		return AdminstrativeImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//Business Libraries
	/**
	 * This method will click on the Organization link
	 */
	public void clickOrganizationLnk()
	{
		OrganizationsLnk.click();
	}
	
	/**
	 * This method will click on contacts link
	 */
	public void clickContactLnk()
	{
		ContactsLnk.click();
	}
	
	/**
	 * This method will perform sign out from the application
	 * @param driver
	 */
	public void signOutOfApp(WebDriver driver)
	{
		mouseHoverOn(driver, AdminstrativeImg);
		SignOutLnk.click();
	}
	
	
	
	

}
