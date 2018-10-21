package com.uiTestFramework.Helper;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class VerificationHelper {

	private WebDriver driver;

	private static Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	public VerificationHelper(WebDriver driver) {
		this.driver = driver;
	}

public static void verifyText(String s1,String s2) {
	Assert.assertEquals(s1, s2);
}

public static void verifyTrue() {
	log.info("making script pass...");
	Assert.assertTrue(true);
}
public static void verifyFalse() {
	log.info("making script fail...");
	Assert.assertTrue(false);
}
}
