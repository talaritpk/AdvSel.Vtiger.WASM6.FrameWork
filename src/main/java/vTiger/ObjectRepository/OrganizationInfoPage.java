package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	//Declaration
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement OrgHeaderText;
		
		public OrganizationInfoPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//Initialization
		public WebElement getOrgHeaderText() {
			return OrgHeaderText;
		}
		
		//Business Libraries
		public String getOrgHeader()
		{
			return OrgHeaderText.getText();
			 
		}
}
