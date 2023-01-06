package com.naveenAutomation.Tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenaAutomation.Pages.AccountLoginPage;
import com.naveenaAutomation.Pages.AddressBookPage;
import com.naveenaAutomation.Pages.MyAccountPage;
import com.naveenaAutomation.Pages.StorePage;
import com.naveenautomation.Base.TestBase;

public class AddressBookTest extends TestBase {
	StorePage storePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	SoftAssert sf = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		storePage = new StorePage();
		accountLoginPage =storePage.clickLoginLink();
		myAccountPage = accountLoginPage.login("lekshmiv123@gmail.com", "Password1");	
	}

	@Test
	public void VerifyUserIsAbleToDeleteAddressFromAddressHistory() {
		AddressBookPage addressHistoryBook= myAccountPage.clickAddressHistory();
		addressHistoryBook.fieldToBeEdited("L6W3C7",By.cssSelector("a"));
		addressHistoryBook.changeCountry("Canada");
		addressHistoryBook.changeState("Alberta");
		addressHistoryBook.changeCompany("infosys");
		sf.assertEquals(addressHistoryBook.getSuccessBannerText(),"Your address has been successfully updated", "Message Not Valid");
		addressHistoryBook.fieldToBeDeleted("L6W5T1",By.cssSelector("a:last-of-type"));
		sf.assertEquals(addressHistoryBook.getSuccessBannerText(),"Your address has been successfully deleted", "Message Not Valid");
		sf.assertAll();
	}

	@AfterMethod
	public void teardown() {
		//quitBrowser();
	}
}
