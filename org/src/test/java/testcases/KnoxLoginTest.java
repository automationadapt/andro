package testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageclasses.KnoxLogin;
import utility.TestUtility;

public class KnoxLoginTest extends KnoxLogin

{
	
	@Test(dataProvider = "getData")
	public static void fn_KnoxIDTest(String login, String pass, String result ) 
	{
		String expectedresult = fn_InputKnoxID(login, pass); 
		test.log(LogStatus.INFO, "Expected Value is: " + expectedresult + " Actual Value is: " + result );
		Assert.assertEquals(expectedresult, result, "Employee ID Is Not Correct");
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		return TestUtility.getData("Login");
	}

}
