package com.naveenAutomation.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenaAutomation.Pages.AccountCreatedPage;
import com.naveenaAutomation.Pages.RegisterAccountPage;
import com.naveenaAutomation.Pages.StorePage;
import com.naveenautomation.Base.TestBase;

public class AccountCreatedTest extends TestBase {


	StorePage storePage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		storePage = new StorePage(driver,true).get();
	}

	@Test
	public void VerifyUserIsAbleToSignUpSuccessFully() {
		RegisterAccountPage registerAccountPage = storePage.clickRegisterLink();

		AccountCreatedPage accountCreated = registerAccountPage.signUp("lekshmi", "vijay", "lekshmiv12345@gmail.com",
				"675674888", "Password1", "Password1");

		Assert.assertEquals(accountCreated.getSuccessAccountCreatedTxt(), "Your Account Has Been Created!",
				"Account not created");

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
