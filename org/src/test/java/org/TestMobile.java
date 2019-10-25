package org;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseclasses.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import utility.ExcelReader;
import utility.TestUtility;

public class TestMobile extends BaseClass{
	
//	public static AndroidDriver driver;
//	public static ExcelReader excel = new ExcelReader(
//			System.getProperty("user.dir")
//					+ "/src/test/resources/excel/DataSource.xlsx");

//	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	

	@Test(dataProvider = "getData")
	
	public static void hitclick(String Username, String Pass) throws MalformedURLException, InterruptedException {
		
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "android"); 
		
//		cap.setCapability("appPackage", "com.sds.ioffice.efss");
//		cap.setCapability("appActivity", "com.sds.ioffice.efss.activity.auth.BaseIntroActivity");
		
//		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.sds.ioffice.efss:id/dialogPositiveButton")).click();
		
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		
//		driver.findElement(By.id("com.sds.ioffice.efss:id/idInputEditTextView")).sendKeys("Mobiletestuser01@samsung.com");
		driver.findElement(By.id("com.sds.ioffice.efss:id/idInputEditTextView")).sendKeys(Username);
		
//		driver.findElement(By.id("com.sds.ioffice.efss:id/pwdInputEditTextView")).sendKeys("1111");
		driver.findElement(By.id("com.sds.ioffice.efss:id/pwdInputEditTextView")).sendKeys(Pass);
		
		driver.findElement(By.id("com.sds.ioffice.efss:id/signInBtn")).click();	
//		com.android.packageinstaller:id/permission_allow_button
//		driver.get("http://google.com");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.name("q")).sendKeys("Hello Appium");
		
		Thread.sleep(3000);
//		driver.quit();
		
	}
	
	public static void m2() {
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return TestUtility.getData("Login");
	}

}
