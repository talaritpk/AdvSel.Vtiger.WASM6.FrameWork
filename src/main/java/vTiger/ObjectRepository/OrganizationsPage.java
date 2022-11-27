package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgLookUpImgElement;
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will click on create organization look up image 
	 * @return
	 */
	public WebElement getCreateOrgLookUpImg()
	{
		return createOrgLookUpImgElement;
	}
}
