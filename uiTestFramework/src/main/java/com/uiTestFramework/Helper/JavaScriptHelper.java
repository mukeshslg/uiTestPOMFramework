package com.uiTestFramework.Helper;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class JavaScriptHelper {



	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);



	public JavaScriptHelper(WebDriver driver) {

		this.driver = driver;
		log.info("javaScriptHelper is initialized");
	}
	
	public Object executeScript(String script) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		return js.executeScript(script);
	}
	/**
	 * execute javascript with multiple arguments
	 * @param script
	 * @param args
	 * @return
	 */
	public Object executeScript(String script,Object...args) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		return js.executeScript(script,args);
	}
	/**
	 * scroll to webelement
	 * @param element
	 */
	
	public void scrollToElement(WebElement element) {
		log.info("scroll to webelement...");
		executeScript("window.scrollTo(arguments[0],argument[1])",element.getLocation().x,element.getLocation().y);
	}
	/**
	 * scroll to webElement and click
	 * @param element
	 */
	public void scrollToElementAndClick(WebElement element) {
		
		scrollToElement(element);
		element.click();
		log.info("scroll to webelement"+element.toString()+" and click");
	}
	/**
	 * scroll into view
	 * @param element
	 */
	public void scrollIntoView(WebElement element) {
		log.info("scroll till webelement");
		executeScript("argument[0].scrollIntoView()",element);
	}
	/**
	 * scroll into view and click
	 * @param element
	 */
	public void scrollIntoViewAndClick(WebElement element) {
		log.info("scroll till webelement and click");
		scrollIntoView(element);
		element.click();
		}
	public void scrollDownVertically() {
		log.info("scrolling down vertically");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public void scrollUpVertically() {
		log.info("scrolling up vertically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	/**
	 * This method click on element
	 * @param element
	 */
	public void clickElement(WebElement element) {
		executeScript("argument[0].click();",element);
	}
}
