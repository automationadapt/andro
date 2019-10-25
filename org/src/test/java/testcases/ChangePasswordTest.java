package testcases;

import org.testng.annotations.Test;

import pageclasses.ChangePassword;

public class ChangePasswordTest extends ChangePassword {
	
	
	@Test
	public static void nav() throws InterruptedException {
		fn_NavChangePassword(); 
	}
	
}
