package com.uiTestFramework.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.uiTestFramework.Helper.LoggerHelper;

public class Retry implements IRetryAnalyzer {
	private int retryCount=0;
	private int maxRetryCount=3;
	//private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(Retry.class);
	public boolean retry(ITestResult result) {
		if (retryCount<maxRetryCount) {
			log.info("retrying test "+result.getName()+" with status "+getResultStatus(result.getStatus())+" for "+(retryCount+1));
			retryCount++;
			return true;
		}
		return false;
	}
	
	public String getResultStatus(int status) {
		String resultName=null;
		if(status==1) {
			resultName="SUCCESS";
		}
		if(status==2) {
			resultName="FAILURE";
		}
		if(status==3) {
			resultName="SKIP";
		}
		return resultName;
	}

}
