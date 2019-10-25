package pageclasses;

import baseclasses.BaseClass;

public class SelectScreenLock extends BaseClass {
	
	
	public static void fn_FillLetterPass(String locator, String value ) {
		input(locator,value);
	}

	
	public static void fn_ConfirmLetterPass(String locator, String value ) {
		input(locator,value);
	}
	
	
	public static boolean fn_AddAlphaPass(String pass) {
		fn_FillLetterPass("LetterPass_ID",pass);
		boolean status= isEleEnabled("Nextbutton_ID"); 
		return status; 
		
	}

	
	public static void fn_ConfirmAlphaPass(String confirmPass) {
		click("Nextbutton_ID");
		fn_ConfirmLetterPass("LetterConfirmPass_ID",confirmPass);
		click("DoneButton_ID");
	}
	
	
	public static void fn_ConfirmBio() throws InterruptedException {
		Thread.sleep(3000);
		click("CancelBio_ID");
	}
	
	
	public static void fn_SelectLockType (String value) {
		
		if (value.equalsIgnoreCase("Letter")) {
			System.out.println("pre clicking on the character ");
			click("CharacterOption_ID");		
		}
		
		else {
			click("NumberOption_ID");
		}

	}
	
}
