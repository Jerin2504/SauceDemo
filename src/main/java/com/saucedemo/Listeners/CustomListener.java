package com.saucedemo.Listeners;


import org.testng.ITestListener;
import org.testng.ITestResult;

import com.saucedemo.TestBase.TestBase;
import com.saucedemo.Utils.CommonUtils;

public class CustomListener extends TestBase implements ITestListener{
	public void onTestStart(ITestResult result) {
		logger.info("Test Started: " + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Test Passed: " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		logger.info("Test Failed: " + result.getMethod().getMethodName());
		logger.info("Test Failed, Taking screenshot!!!!!");
		CommonUtils.takeFailedTestScreenShot(result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Test Skipped: " + result.getMethod().getMethodName());
	}
}