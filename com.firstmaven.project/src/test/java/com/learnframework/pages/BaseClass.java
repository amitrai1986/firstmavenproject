package com.learnframework.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnframework.utility.BrowserFactory;
import com.learnframework.utility.ConfigDataProvider;
import com.learnframework.utility.ExcelDataProvider;
import com.learnframework.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setUpSuit(){
		config = new ConfigDataProvider();
		excel = new ExcelDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Reports/extentreport"+Helper.currentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@Parameters({"systembrowser", "urlTobeTested"})
	@BeforeClass
	public void setup(String browser, String url){
		Reporter.log("Brrowsers setup completed", true);
		/*driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());*/
		driver=BrowserFactory.startApplication(driver, browser, url);
	}
	
	@AfterMethod
	public void screenonFailure(ITestResult result) throws Exception{
		if(ITestResult.FAILURE==result.getStatus()){
			logger.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver, result.getName())).build());
		}
		else if(ITestResult.SUCCESS==result.getStatus()){
			logger.pass("Test Case Passed");
		}
		report.flush();
	}
	
	@AfterClass
	public void teardown(){
		BrowserFactory.closeBrowser(driver);
	}

}
