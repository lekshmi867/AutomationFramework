package com.naveenAutomation.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenaAutomation.Pages.AccountLoginPage;
import com.naveenaAutomation.Pages.MyAcccountInformationPage;
import com.naveenaAutomation.Pages.MyAccountPage;
import com.naveenaAutomation.Pages.NewsLetterSubscriptionPage;
import com.naveenaAutomation.Pages.StorePage;
import com.naveenautomation.Base.TestBase;

public class MyAccountTest extends TestBase {
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	StorePage storePage;
	MyAcccountInformationPage myAccountInformationPage;
	NewsLetterSubscriptionPage newsLetterSubscriptionPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		storePage = new StorePage();
		}

	@Test
	public void verifyUserLogin() {
		verifyLogin();
		Assert.assertEquals(myAccountPage.getMyAccountText(), "My Account", "Login Failed");
	}
	
	@Test
	public void verifyPhoneNumberUpdate() {
		verifyLogin();
		myAccountInformationPage =myAccountPage.clickEditYourAccountInfo();
		myAccountInformationPage.changePhoneNumber("678912345");
		myAccountPage = myAccountInformationPage.clickContinueBtn();
		Assert.assertEquals(myAccountPage.getAccountUpdateeSuccessMessage(),"Success: Your account has been successfully updated.","Phone Number Not Updated");

	}
	
	@Test
	public void verifyNewsLetterSubscription() {
		verifyLogin();
		newsLetterSubscriptionPage = myAccountPage.clickSubscribeNewsLetterLink();
		newsLetterSubscriptionPage.clickSubscribeOption("no");
		myAccountPage=newsLetterSubscriptionPage.clickContinueBtn();
		Assert.assertEquals(myAccountPage.getAccountUpdateeSuccessMessage(),"Success: Your newsletter subscription has been successfully updated!");

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
	void verifyLogin() {
		accountLoginPage =storePage.clickLoginLink();
		myAccountPage = accountLoginPage.login("lekshmiv123@gmail.com", "Password1");	
	}
}
