package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;


public class DashBoardPage {
	WebDriver driver;
	PageUtility pageutility;
	
	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileName;
	@FindBy(xpath = "//li[@class='nav-item dropdown']//a[@class='nav-link']")
	private WebElement userOptions;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	private WebElement logoutOption;
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProfileName() {
		return profileName.getText();
	}
	
	public void clickOnTile(String name) {
		pageutility=new PageUtility(driver);
		WebElement tileElement = driver.findElement(By.xpath("//div[@class='inner']//p[contains(text(),'"+name+"')]//following::a[1]"));
		pageutility.scrollAndClick(tileElement);
	}
	public void userLogout() {
		pageutility=new PageUtility(driver);
		pageutility.scrollAndClick(userOptions);
		pageutility.scrollAndClick(logoutOption);
	}


}
