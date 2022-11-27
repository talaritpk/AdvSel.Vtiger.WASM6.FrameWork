package vTigerAppPractice;


import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.LoginPage;


public class PomPractiseForLoginPage {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.get("http://localhost:8888");
		
		System.out.println("hai");
		LoginPage lp=new LoginPage(driver);
		//lp.getUserNameEdt1().isDisplayed();
		//lp.getPasswordEdt().sendKeys("admin");
		//lp.getLoginBtn().click();
		
		lp.loginPage("admin", "admin");
		
	}

}
