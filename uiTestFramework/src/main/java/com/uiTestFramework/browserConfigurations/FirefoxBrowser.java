package com.uiTestFramework.browserConfigurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiTestFramework.Helper.ResourceHelper;

public class FirefoxBrowser {

public FirefoxOptions getFirefoxOptions() {
	DesiredCapabilities firefoxCapabilities=DesiredCapabilities.firefox();
	firefoxCapabilities.setJavascriptEnabled(true);
	
	FirefoxProfile firefoxProfile=new FirefoxProfile();
	firefoxProfile.setAcceptUntrustedCertificates(true);
	firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
	
	firefoxCapabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
	firefoxCapabilities.setCapability("marionette", true);
	
	FirefoxOptions firefoxOptions=new FirefoxOptions(firefoxCapabilities);
	//Linux system needs to have Headless browser because of no GUI
	return firefoxOptions;
	
}

public WebDriver getFirefoxDriver(FirefoxOptions firefoxOptions) {
	if (System.getProperty("os.name").contains("Windows")) {
		 System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("/resources/geckodriver.exe"));
		 return new FirefoxDriver(firefoxOptions);
	} else if(System.getProperty("os.name").contains("Mac")) {
		 System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("/resources/geckodriver"));
		 return new FirefoxDriver(firefoxOptions);
	}
	return null;
	
	
}
}
