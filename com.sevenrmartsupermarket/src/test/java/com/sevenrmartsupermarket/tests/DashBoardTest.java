package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class DashBoardTest extends Base{
	DashBoardPage dashboardpage;
	LoginPage loginpage;
	
	@Test(groups = {"smoke", "regression"})
	public void verifyUserLogout() {			
		loginpage = new LoginPage(driver);
		dashboardpage=new DashBoardPage(driver);
		loginpage.login();
		dashboardpage.userLogout();
		Assert.assertTrue(loginpage.isSignInButtonDisplayed());
	}
}
