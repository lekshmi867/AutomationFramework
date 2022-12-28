package com.naveenAutomation.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenaAutomation.Pages.AccountLoginPage;
import com.naveenaAutomation.Pages.AccountLogoutPage;
import com.naveenaAutomation.Pages.MyAccountPage;
import com.naveenaAutomation.Pages.StorePage;
import com.naveenautomation.Base.TestBase;

public class StorePageTest extends TestBase {
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	StorePage storePage;
	AccountLogoutPage accountLogoutPage;
	

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		storePage = new StorePage();
		}

	@Test
	public void verifyLogout() {
		accountLoginPage =storePage.clickLoginLink();
		myAccountPage = accountLoginPage.login("lekshmiv123@gmail.com", "Password1");
		accountLogoutPage=myAccountPage.clickLogoutLink();
		Assert.assertEquals(driver.getTitle(),"Account Logout", "Page not valid");
		Assert.assertEquals(accountLogoutPage.getAccountLogoutText(),"Account Logout", "Page not valid");
		storePage=accountLogoutPage.clickContinuebtn();
		Assert.assertEquals(driver.getTitle(),"Your Store","Page Not valid");
			
	}
	

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
