package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Initialization
	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
	//Business Libraries
	public String getContactHeader()
	{
		return contactHeaderText.getText();
		 
	}
}
