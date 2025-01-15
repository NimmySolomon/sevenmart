package com.sevenrmartsupermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	public String getAttribute(WebElement element, String attribute)
	{
		return element.getAttribute(attribute);
	}
		
	public String getCSSValue(WebElement element, String property)
	{
		return element.getCssValue(property);
	}

	public List<String> getTextOfElements(List<WebElement> elements)
	{
		List<String> data = new ArrayList<String>();	//declaring List to store String returned by gettext() method.
		
		for(WebElement element: elements)
		{
			data.add(element.getText());
		}
		return data;
	}

	public List<String> getAllNamesFromTable(List<WebElement> names)
	{
		List<String> data = new ArrayList<String>();
		
		for(WebElement element: names)
		{
			data.add(element.getText());
		}
		return data;
	}

	public List<String> getPersonalDetailsFromTable(List<WebElement> person_details)
	{
		List<String> data = new ArrayList<String>();
		
		for(WebElement details:person_details)
		{
			data.add(details.getText());
		}
		return data;
	}
	
	public static String getTimeStamp() {
		String timeStamp =new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;
	}
	
	public static String getRandomName() {
		Faker faker = new Faker();
		return faker.name().firstName();	
	}

}
