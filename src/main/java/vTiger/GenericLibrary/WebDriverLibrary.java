package vTiger.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

	/**
	 * This class contains all generic methods related to web driver actions
	 * @author tpkta
	 *
	 */
	public class WebDriverLibrary {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will wait for 20 seconds to load the page
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 seconds for element to be visible
	 * @param driver
	 * @param ele
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	/**
	 * This method will wait for 10s for the element to be click able
	 * @param driver
	 * @param ele
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	/**
	 * This is a custom wait used to wait for an element and perform click action. 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClickOnElement(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<10)
		{
			try
			{
				element.click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * This method will handle drop-down through select class select data by value
	 * @param ele
	 * @param value
	 */
	public void handleDropdown(WebElement ele,String value )
	{
		Select s=new Select(ele);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle drop-down through select class and select data by index
	 * @param ele
	 * @param index
	 */
	public void handleDropdown(WebElement ele,int index)
	{
		Select s=new Select(ele);
		s.selectByIndex(index);
		
	}
	
	/**
	 * This method will handle drop-down through select class and select data by text
	 * @param text
	 * @param ele
	 */
	public void handleDropdown(String text,WebElement ele)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform move hover action 
	 * @param driver
	 * @param ele
	 */
	public void mouseHoverOn(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	/**
	 * This method will perform right click on the web page
	 * @param driver
	 * @param ele
	 */
	public void rightClickOn(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on a particular element
	 * @param driver
	 * @param ele
	 */
	public void rightClickOn(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.contextClick(ele).perform();;
	}
	
	/**
	 * This method will perform double click on a web page
	 * @param driver
	 */
	public void doubleClickOn(WebDriver driver) 
	{
		Actions act =new Actions(driver);
		act.doubleClick().perform();;
	}
	
	/**
	 * This method will perform double click on a particular web element 
	 * @param driver
	 * @param ele
	 */
	public void doubleClickOn(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
	}
	
	/**
	 * This method will drag and drop from source element to destination element
	 * @param driver
	 * @param srcEle
	 * @param desEle
	 */
	public void dragAndDropOn(WebDriver driver,WebElement srcEle,WebElement desEle)
	{
		Actions act =new Actions(driver);
		act.dragAndDrop(srcEle, desEle).perform();
	}
	
	/**
	 * Moves the mouse from its current position (or 0,0) by the given offset. If the coordinates 
	 * provided are outside the viewport (the mouse will end up outside the browser window) then 
	 * the viewport is scrolled to match.
	 * @param driver
	 * @param xOff
	 * @param yOff
	 */
	public void mouseHoverOn(WebDriver driver,int xOff,int yOff)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(xOff, yOff).perform();
	}
	
	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch to frame based on nameOrId
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will switch to the frame based on element
	 * @param driver
	 * @param ele
	 */
	public void swithToFrame(WebDriver driver,WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	
	/**
	 * This method will switch from current frame to the immediate parent frame 
	 * @param driver
	 */
	public void switchToParent(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch from current frame to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * THis method will click accept in alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();;
	}
	
	/**
	 * THis method will click dismiss in alert pop up
	 * @param driver
	 */
	public void dismissPopup(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * THis method will return text of the alert pop up to the caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		String alertText=driver.switchTo().alert().getText();
		return alertText;
	}
	
	/**
	 * This method will press the enter key
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//r.keyPress(KeyEvent.VK_CONTROL);
		//r.keyPress(KeyEvent.VK_T);
	}
	/**
	 * This method will switch from parent window to any child window or from child window to any parent window
	 * based on the partial window title.
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		//1.get the all the window handles
		Set<String> windowIds=driver.getWindowHandles();
		
		//2.iterate through all the window id's--works similar to for-each loop
		Iterator<String> it = windowIds.iterator();
		
		//3.navigate the each window and check the the title
		while(it.hasNext())
		{
			//4.capture the individual window id
			String winId = it.next();
			
			//5.Switch to that window and capture the title
			String currentTitle = driver.switchTo().window(winId).getTitle();
			
			//6.compare the current tile with partial title
			if(currentTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This method will take the screenshot
	 * @return 
	 */
	public String takeScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\Screeenhots\\"+screenshotName+".png");
		FileUtils.copyFile(src, dest);   //from commons IO
		
		return dest.getAbsolutePath(); // used for extents reports. 	
	}
	
	/**
	 * This method will scroll down for 500 units
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)","");
	}
	
	/**
	 * This method will scroll down until the specified element is found
	 * @param driver
	 * @param ele
	 */
	public void scrollAction(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",ele);
		//ele.getLocation().getX();
		//js.executeScript("window.scrollBy(0,+y+),ele");
	}

}
