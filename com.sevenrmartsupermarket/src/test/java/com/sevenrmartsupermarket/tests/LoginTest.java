package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;


public class LoginTest extends Base{
	LoginPage loginpage;
	DashBoardPage dashboardpage;
	
	@Test(groups="smoke")
	public void verifyUserLogin()
	{
		dashboardpage = new DashBoardPage(driver);
		loginpage = new LoginPage(driver);
		//loginpage.login("admin","admin");	
		loginpage.login();
		Assert.assertEquals(false, null);
	}
	

}
