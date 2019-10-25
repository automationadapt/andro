package pageclasses;

import baseclasses.BaseClass;

public class ChangePassword extends BaseClass {
	
	public static void fn_NavChangePassword() throws InterruptedException {
		Home.fn_NavtoMore().fn_NavScreenLockSetting().click("ChangeScreenLockPassword_ID");
	}
	
	
	public static void fn_Autorized() {
		
	}
	
}
