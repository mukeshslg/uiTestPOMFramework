package com.uiTestFramework.Helper;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class FrameHelper {



	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(FrameHelper.class);



	public FrameHelper(WebDriver driver) {

		this.driver = driver;

	}
/**
 * switch to frame by index
 * @param index
 */
public void switchToFrame(int index) {
	driver.switchTo().frame(index);
	log.info("switch to frame index:"+index);
}
/**
 * switch to frame by frame Name
 * @param fname
 */
public void switchToFrame(String fname) {
	driver.switchTo().frame(fname);
	log.info("switch to frame :"+fname);
}

public void switchToFrame(WebElement element) {
	driver.switchTo().frame(element);
	log.info("switch to frame :"+element.toString());
}

}
