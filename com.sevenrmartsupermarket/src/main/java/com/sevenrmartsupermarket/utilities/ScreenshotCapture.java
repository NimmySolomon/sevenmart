package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenrmartsupermarket.constants.Constants;

public class ScreenshotCapture {
	TakesScreenshot takescreenshot;
	
	public void takescreenshot(WebDriver driver, String imageName) {
		try {
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			takescreenshot = (TakesScreenshot) driver;
			String path = Constants.SCREENSHOT_FILE_PATH+imageName+"_"+timeStamp+".png";
			File screenShot = takescreenshot.getScreenshotAs(OutputType.FILE); //captures Screenshot
			File destination = new File(path); //moves the screenshot to here
			FileHandler.copy(screenShot, destination); //Moving the captures screenshot
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 
