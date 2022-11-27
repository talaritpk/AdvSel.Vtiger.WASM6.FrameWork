package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { 
	//1.create a separate java class for every page
	//2.identify elements using @FindBY @FindAll,@FindBys
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindAll({@FindBy(name="user_password"),
		@FindBy(xpath="//input[@type='password']")})
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//3.create a constructor to initialize the variable
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//4.provide getters methods to access these variables
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//business libraries
	/**
	 * This method will perform login operation
	 * @param userName
	 * @param password
	 */
	public void loginPage(String userName,String password)
	{
		userNameEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
}
