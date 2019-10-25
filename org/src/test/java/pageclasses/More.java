package pageclasses;

import baseclasses.BaseClass;

public class More extends BaseClass {
	
	
	public static SelectScreenLock fn_NavScreenLockSetting() {
		
		click("ScreenLockSetting_ID");
		SelectScreenLock objSelectScreenLock=new SelectScreenLock(); 
		return objSelectScreenLock;
		
	}
	

	
}
