package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.WaitUtility;


public class LoginPage {
	
	WebDriver driver;
	Properties properties = new Properties();
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signInButton;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);		//used to initialize all the WebElements located by @findby annotation
		try
		{
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
		}
		catch(Exception e){
			e.printStackTrace(); /**print Exception*/
		}
	}
	
	public void enterUserName(String userName)
	{
		userNameField.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void clickOnSignInButton() {
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.waitForElementToClick(signInButton, 30);
		signInButton.click();
	}
	
	public void login(String userName, String password)
	{
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}
	
	public void login()
	{
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}

	public boolean isSignInButtonDisplayed() {
		return false;
	}

}
