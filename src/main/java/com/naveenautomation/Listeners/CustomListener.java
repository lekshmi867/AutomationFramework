package com.naveenautomation.Listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Utils.Log;
import com.naveenautomation.Utils.Utils;

public class CustomListener extends TestBase implements ITestListener {

	Logger log = Log.getLoggerData(this.getClass().getName());
	

	@Override
	public void onTestStart(ITestResult result) {
		log.info("Test execution has started for : " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Test execution has passed for : " + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.error("Test execution failed and taking screen shot: " + result.getName());
		Utils.takeScreenShot(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("Test execution has skipped for : " + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
}