package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseclasses.BaseClass; 

public class KnoxLogin extends BaseClass{
	
	
//	public static SelectScreenLock fn_KnoxLogin(String login, String pass) {
//				String vikastest= null; 
//				String vikas=fn_InputKnoxID(login,pass);
//				if (vikas= nu){
//					vikastest= getText("NoticeText_ID");
//					click("NoticeButton_ID");
//				}
//				
//				else 
//				{
//					System.out.println("else condition");
//				}
//				input("KnoxLogin_ID", login); 
//				input("KnoxPass_ID", pass);
//				click("LoginButton_ID");						
//				SelectScreenLock objSelectScreenLock=new SelectScreenLock(); 
//				return objSelectScreenLock; 
//				}
	
	
	public static String fn_InputKnoxID(String login,String pass) {
				String resulttext=null; 
				boolean noticeStatus= false; 
				click("KnoxLogin_ID"); 
		        input("KnoxLogin_ID", login); 
		        click("KnoxPass_ID");
		   
		        if (!driver.findElements(By.id("com.sds.efss.drive:id/dialogTextview")).isEmpty()) {
		        	resulttext= getText("NoticeText_ID");
					System.out.println(noticeStatus+ "Notice Status"+1);
					click("NoticeButton_ID");
		        }
		        else
		        {
		        	System.out.println("else");
		        	click("SelectCompany_ID");
		        	click("OKButton_ID");
		        	resulttext= fn_InputKnoxPassword(pass); 	
		        }
				return resulttext; 	
				} 
	
	
	
	public static String fn_InputKnoxPassword(String pass) {
			boolean passStatus= false; 
			String passresulttext= null; 
			input("KnoxPass_ID", pass);
			click("LoginButton_ID");		
			if (!driver.findElements(By.id("com.sds.efss.drive:id/dialogTextview")).isEmpty()) {
			passStatus =isEleEnabled("NoticeText_ID");
			passresulttext= getText("NoticeText_ID");
			click("NoticeButton_ID");
			 }
			 else {
				 passresulttext =getText("ScreenLockTypeHeading_ID");
		        	System.out.println("now final test will execute");
			 }
			 return passresulttext ; 	
			} 
	
	
	
}
