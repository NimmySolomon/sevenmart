package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageNewsPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageNewsTest extends Base {
	LoginPage loginpage;
	DashBoardPage dashboardpage;
	ManageNewsPage managenewspage;
	ExcelReader excelreader= new ExcelReader();
			
	@Test(groups="smoke")
	public void verifyNewNewsInput() {
		GeneralUtility generalutility = new GeneralUtility();
		String randName = GeneralUtility.getRandomName();
		loginpage = new LoginPage(driver);
		dashboardpage=new DashBoardPage(driver);
		managenewspage=new ManageNewsPage(driver);
		loginpage.login();
		dashboardpage.clickOnTile("Manage News");
		excelreader.setExcelFile("NewsData", "newsSheet");
		String data =excelreader.getCellData(1, 0);
		managenewspage.sendNews(data);
		String resultMessage=managenewspage.getAlert();
		String s[]=resultMessage.split("\n");
		String actualResult=s[2];
		String expectedResult ="News Created Successfully";
		Assert.assertEquals(actualResult, expectedResult);
	}


}
