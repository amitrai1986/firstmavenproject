package com.learnframework.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnframework.pages.BaseClass;
import com.learnframework.pages.LoginPage;

public class LoginCRM extends BaseClass {
	
	@Test
	public void validLlogin() throws Exception{
		logger = report.createTest("Login to CRM");
	
		LoginPage loginpage = new LoginPage(driver);
		logger.info("Starting Apllication");
		Reporter.log("Login screen is open", true);
		loginpage.login(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));
		Thread.sleep(3000);
		Reporter.log("Checking pagetitle");
		Assert.assertEquals(driver.getTitle(), "Gogle", "Failed");

		

	}

}
