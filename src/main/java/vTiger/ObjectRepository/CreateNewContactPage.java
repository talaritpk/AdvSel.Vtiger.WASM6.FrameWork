package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateNewContactPage extends WebDriverLibrary{
	
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name="leadsource")
	private WebElement leadSrcDrpdn;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img[@alt='Select']")
	private WebElement organizationImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdtEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(id="1")
	private WebElement selectOrg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getLeadSrcDrpdn() {
		return leadSrcDrpdn;
	}

	public WebElement getOrganizationImg() {
		return organizationImg;
	}

	public WebElement getSearchEdtEdt() {
		return searchEdtEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getSelectOrg()
	{
		return selectOrg;
		
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Libraries
	
	/**
	 * With This method new contact will create with last name 
	 * @param lastName
	 */
	public void createNewContact(String lastName)
	{
		lastnameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	/**
	 * This method will create contact with lead source drop down
	 * @param lastName
	 * @param leadSourceValue
	 */
	public void createNewContact(String lastName,String leadSourceValue)
	{
		lastnameEdt.sendKeys(lastName);
		handleDropdown(leadSrcDrpdn, leadSourceValue);
		saveBtn.click();
		
	}
	
	public void createNewContactWithOrg(String lastname)
	{
		lastnameEdt.sendKeys(lastname);
		organizationImg.click();
		
	}
}
