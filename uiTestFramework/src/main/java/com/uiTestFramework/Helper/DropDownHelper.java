package com.uiTestFramework.Helper;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper {
	private WebDriver driver;
	private static Logger log = LoggerHelper.getLogger(VerificationHelper.class);
	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
		log.info("**DropDownHelper object created**");
	}
	public void selectUsingValue(WebElement element,String value) {
		Select select=new Select(element);
		log.info("selecting text by visibleText textis:"+value);
		select.selectByValue(value);
		
	}
	public void selectUsingIndex(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
		log.info("selecting text by index indexNo:"+index);
	}
	
	public List<String> getAllDropDownData(WebElement element){
		Select select=new Select(element);
		List<WebElement> list=select.getOptions();
		List<String> LnkList=new LinkedList<String>();
		for (WebElement ele : list) {
			LnkList.add(ele.getText());
		}
		return LnkList;
	}

}
