package utility;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager
{

	private static ExtentReports extent; 
	
	public static ExtentReports getInstance() {
		if (extent==null) {
		
			extent= new ExtentReports(System.getProperty("user.dir")+"/target/surefire-reports/extent.html",true,DisplayOrder.OLDEST_FIRST);

			
			extent.loadConfig(new File(System.getProperty("user.dir")+"/src/test/resources/extentreport/ExtentConfig.xml"));
		}
		
		return extent;
	}
	
}
