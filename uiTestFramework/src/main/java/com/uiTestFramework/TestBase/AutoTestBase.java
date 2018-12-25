package com.uiTestFramework.TestBase;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiTestFramework.util.ExtentManager;

public class AutoTestBase {
	//private Logger log = LoggerHelper.getLogger(AutoTestBase.class);
	public static ExtentReports extent;
	public static ExtentTest test;
	static {
	
		  
	}
  
  @BeforeMethod
  public void beforeMethod(Method method) {
	 test.log(Status.INFO, method.getName()+" test started");
  }

  @AfterMethod
  public void afterMethod(ITestResult result) {
	  if (result.getStatus()==ITestResult.SUCCESS) {
		test.log(Status.PASS,result.getTestName()+" is pass");
	  } else if(result.getStatus()==ITestResult.FAILURE) {
		test.log(Status.FAIL, result.getThrowable());
	  }else if(result.getStatus()==ITestResult.SKIP) {
		test.log(Status.SKIP, result.getThrowable());
	  }
	  System.out.println("extent value:"+extent);
	  
	  extent.flush();
	 
  }
  @BeforeClass  
  public void beforeclass() {
	  test=extent.createTest("sample testing extent report");//getClass().getName()
  }	

  @BeforeSuite
  public void beforeSuite() {
		extent=ExtentManager.getInstance();
	  
  }
  



}
