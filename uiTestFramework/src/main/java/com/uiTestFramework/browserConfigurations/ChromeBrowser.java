package com.uiTestFramework.browserConfigurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiTestFramework.Helper.ResourceHelper;

public class ChromeBrowser {
	
	
	public ChromeOptions getChromeOptions() {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-popup-blocking");
		option.addArguments("--test-type");
		DesiredCapabilities chromeCapabilities=DesiredCapabilities.chrome();
		chromeCapabilities.setJavascriptEnabled(true);
		option.setCapability(ChromeOptions.CAPABILITY, chromeCapabilities);
		return option;
	}
	
	public WebDriver getChromeDriver(ChromeOptions caps) {
		if (System.getProperty("os.name").contains("Windows")) {
			 System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/resources/chrome.exe"));
			 return new ChromeDriver(caps);
		} else if(System.getProperty("os.name").contains("Mac")) {
			 System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/resources/chrome"));
			 return new ChromeDriver(caps);
		}
		return null;
		
	}

}
