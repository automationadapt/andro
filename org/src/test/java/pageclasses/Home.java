package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseclasses.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
public class Home extends BaseClass{
	

//#Home
//More_ID=com.sds.ioffice.efss:id/moremenu
//	
	
	public static More fn_NavtoMore() throws InterruptedException {
		
		System.out.println("vikas click before the Click  ");
		Thread.sleep(7000);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, 40); 
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.sds.efss.drive:id/moremenu")))); 
	
		TouchAction objTouchAction=new TouchAction(driver); 
		objTouchAction.tap(PointOption.point(650,1320)).perform();
		System.out.println("vikas click after the Click ");
		More objMore=new More();
		return objMore; 
		
	}

	
}
