package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateNewOrganisationPage extends WebDriverLibrary {
	@FindBy(name="accountname")
	private WebElement OrgNameElement;
	
	@FindBy(name="industry")
	private WebElement industryDrDn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveElement;

	public CreateNewOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrgNameElement()
	{
		return OrgNameElement;
	}
	
	public WebElement getIndustrydpdn()
	{
		return industryDrDn;
	}
	
	public WebElement getSaveElement()
	{
		return saveElement;
	}
	
	public void createNewOrg(String Org,String industryDrDnValue)
	{
		OrgNameElement.sendKeys(Org);
		handleDropdown(industryDrDn,industryDrDnValue);
		saveElement.click();
		
	}

}
