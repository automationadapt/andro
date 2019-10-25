package listeners;



import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import baseclasses.BaseClass;
import utility.TestUtility;


public class CustomListeners extends BaseClass implements  ITestListener, ISuiteListener

{
	
	public String messageBody;

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"PASS");
//		rep.endTest(test);
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestFailure(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try
		{
			TestUtility.captureScreenshot();

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed with exception : "+result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtility.fileName));
		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href="+TestUtility.fileName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtility.fileName+"><img src="+TestUtility.fileName+" height=400 width=800></img></a>");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test case Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log(" Test case is passed partially");
		
	}

	public void onStart(ITestContext context) {
		
		test = rep.startTest(context.getName().toUpperCase()); 
		
	}

	public void onFinish(ITestContext context) {
	
		
	} 

	
}
