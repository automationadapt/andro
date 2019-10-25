package baseclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import utility.ExcelReader;
import utility.ExtentManager;

public class BaseClass {

	
//	public static WebElement driver;
	public static AndroidDriver<MobileElement> driver;
	public static FileInputStream fis;
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static AndroidDriver wait;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir")
					+ "/src/test/resources/excel/DataSource.xlsx");
	
	public ExtentReports rep= ExtentManager.getInstance(); 
	public static ExtentTest test;

	
	
	@BeforeTest	
	public static void StartDriver() throws MalformedURLException {
		
		System.out.println("prerequisite");
		
		try
		{

			fis = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/properties/Config.properties");
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			Config.load(fis);
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		try
		{
			fis = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/properties/OR.properties");
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			OR.load(fis);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "android"); 
		
		cap.setCapability("appPackage", "com.sds.efss.drive");
		cap.setCapability("appActivity", "com.sds.efss.drive.activity.auth.BaseIntroActivity");

		driver = new AndroidDriver<MobileElement> (new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
	}
	
	
	
	
	public static void click(String locator)
	{
		try
		{
			if (locator.endsWith("_XPATH"))
				
			{
			   driver.findElement(By.xpath(OR.getProperty(locator))).click();
			} else if (locator.endsWith("_CSS"))
			{
				driver.findElement(By.cssSelector(OR.getProperty(locator)))
						.click();
			} else if (locator.endsWith("_ID"))
			{
			
				driver.findElement(By.id(OR.getProperty(locator))).click();
			} else
			{
				System.out.println("Check the Locator of WebElement");
			}
		} catch (Throwable t)
		{
			System.out.println("Element Unavailablity");
		}
		test.log(LogStatus.INFO, "Clicked on: "+ locator.split("_")[0] );
	}
	
	
	
	public static void clear(String locator)
	{
		try
		{
			if (locator.endsWith("_XPATH"))
				
			{
			   driver.findElement(By.xpath(OR.getProperty(locator))).clear();
			} else if (locator.endsWith("_CSS"))
			{
				driver.findElement(By.cssSelector(OR.getProperty(locator)))
						.clear();
			} else if (locator.endsWith("_ID"))
			{
			
				driver.findElement(By.id(OR.getProperty(locator))).clear();
			} else
			{
				System.out.println("Check the Locator of WebElement");
			}
		} catch (Throwable t)
		{
			System.out.println("Element Unavailablity");
		}
		test.log(LogStatus.INFO, "Clicked on: "+ locator.split("_")[0] );
	}
	
	
	
	public static boolean isEleEnabled (String locator)
	{
		
		boolean status= false;
		
		
			 if(locator.endsWith("_ID"))
			{
				status =driver.findElement(By.id(OR.getProperty(locator))).isEnabled();
				
			} else
			{
				System.out.println("Webelement is not active");
			}
	
		test.log(LogStatus.INFO, locator.split("_")[0]+"Element is: " + status );
		
	
		return status;
	}
	
	
	
	

	public static String getText(String locator) {
		{
			String text=null; 
			try
			{
				if (locator.endsWith("_XPATH"))
					
				{
					text= driver.findElement(By.xpath(OR.getProperty(locator))).getText();
					
				} else if (locator.endsWith("_CSS"))
					
				{
				
					text= driver.findElement(By.cssSelector(OR.getProperty(locator))).getText();
					
				} else if (locator.endsWith("_ID"))
					
				{
					text= driver.findElement(By.id(OR.getProperty(locator))).getText();
					System.out.println(text);
					
				} else
					
				{
					System.out.println("Check the text of WebElement");
				}
			}
			catch (Throwable t)
			{
				
				Reporter.log(t.getMessage());
				
			}
			
			test.log(LogStatus.INFO, "Getting Text of: " + locator.split("_")[0]);
			test.log(LogStatus.INFO, "Value of "+ locator.split("_")[0]+" is: " + text);
			return text; 

		}
		
	}




	public static void input(String locator, String value) {
		try
		{
			if (locator.endsWith("_XPATH"))
			{
				driver.findElement(By.xpath(OR.getProperty(locator))).clear();
				driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_CSS"))
			{
				driver.findElement(By.cssSelector(OR.getProperty(locator))).clear();
				
				driver.findElement(By.cssSelector(OR.getProperty(locator)))
						.sendKeys(value);
				
			} else if (locator.endsWith("_ID"))
			{
				driver.findElement(By.id(OR.getProperty(locator))).clear();
				driver.findElement(By.id(OR.getProperty(locator)))
						.sendKeys(value);
				
			} else
			{
				System.out.println("Check the Locator of WebElement");
			}
		}
		
		catch (Throwable t)
		{
			
			Reporter.log(t.getMessage());
			
		}
		test.log(LogStatus.INFO, "Typing in "+ locator.split("_")[0] + " with Value: '"+value+"'" );
		
	}
	
	
}
