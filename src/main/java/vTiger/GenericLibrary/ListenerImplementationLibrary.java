package vTiger.GenericLibrary;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class will provide Implementation to all the abstract methods in ITestListener
 * @author tpkta
 *
 */
public class ListenerImplementationLibrary implements ITestListener 
{
	ExtentReports reports;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		Reporter.log("Test Execution Started-> "+methodName,true);
		
		test = reports.createTest(methodName);
		test.log(Status.INFO,"Test Script Execution Started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		//Reporter.log("Test Successfull-> "+MethodName,true);
		
		test.log(Status.PASS,methodName+"--PASS");
	}

	public void onTestFailure(ITestResult result) {
		WebDriverLibrary wLib=new WebDriverLibrary();
		JavaLibrary jLib=new JavaLibrary();
		
		String methodName=result.getMethod().getMethodName()+jLib.getSystemDateInFormat();
		//Reporter.log("Test Failed-> "+methodName,true);
		
		try {
			String path=wLib.takeScreenShot(BaseClass.sDriver, methodName);
			
			test.addScreenCaptureFromPath(path);
			
			test.log(Status.PASS,methodName+"--FAIL");
			test.log(Status.FAIL, result.getThrowable());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		//Reporter.log("Test Skipped-> "+methodName,true);
		
		test.log(Status.PASS, methodName+"--Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		Reporter.log("Execution of Suite is Started");
		//Since the execution is started here,we have to configure extent reports here
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report"+new JavaLibrary().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger-Execution Reports");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Execution Report");
		
		//Attach report to extentReports
		reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("BaseBrowser", "Chrome");
		reports.setSystemInfo("Base Environment", "Testing");
		reports.setSystemInfo("Base Url", "http://lacalhost:8888");
		reports.setSystemInfo("Base Platform", "wondows");
		reports.setSystemInfo("Reporter", "Pavan Kumar");
	}

	public void onFinish(ITestContext context) {
		Reporter.log("Execution of Suite is Finished",true);
		
		//Mandatory because,this says all the test script execution is complete and final report can be generated
		reports.flush();
	}
	

}
