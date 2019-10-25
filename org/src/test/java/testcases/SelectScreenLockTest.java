package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageclasses.SelectScreenLock;
import utility.TestUtility;

public class SelectScreenLockTest extends SelectScreenLock{
	
	

	public static String msg="vikas"; 
	
	@Test(dataProvider = "getData", priority=1)
	public static void fn_SelectLetterPassTest(String lockType, String pass, String confirmPass, String sucessMessage ) {
		fn_SelectLockType(lockType);
		//Assert with The navigation 
		
	}
	
	
	@Test(dataProvider = "getData", priority=2)
	public static void fn_LetterPassTest(String lockType, String pass, String confirmPass, String sucessMessage ) {
		boolean status =fn_AddAlphaPass(pass);
		Assert.assertEquals(true, status);
		//Assert with the done button status
	}
	
	
	
	@Test(dataProvider = "getData", priority=3)
	public static void fn_ConfirmLetterPassTest(String lockType, String pass, String confirmPass, String sucessMessage ) throws InterruptedException {
		fn_ConfirmAlphaPass(confirmPass);
		System.out.println("cancel the bio option");
		fn_ConfirmBio();
		//Assert with the toast message
		Assert.assertEquals(msg, sucessMessage);
	}
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		return TestUtility.getData("SetLockType");
	}

}
