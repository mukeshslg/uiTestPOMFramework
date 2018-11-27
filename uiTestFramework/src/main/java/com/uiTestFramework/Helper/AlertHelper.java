package com.uiTestFramework.Helper;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;



public class AlertHelper {



	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(AlertHelper.class);



	public AlertHelper(WebDriver driver) {

		this.driver = driver;

	}
	public Alert getAlert() {
		log.info("Alert says:"+driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			log.info(e.getCause());
			return false;
		}
	}


}
