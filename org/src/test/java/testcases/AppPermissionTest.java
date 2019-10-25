package testcases;

import org.testng.annotations.Test;

import pageclasses.AppPermission;

public class AppPermissionTest extends AppPermission {
	
	@Test
	public static void fn_Permissiontest() {
		fn_acceptAppPermission();
	
		fn_acceptStoragePermission1();
		
		fn_acceptStoragePermission2();
		
		fn_acceptStoragePermission3();
		
		
	}

}
