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
	public void VerifyUserIsAbleToEditAddressFromAddressBook() {
		AddressBookPage addressBookPage= myAccountPage.clickAddressHistory();
		addressBookPage.fieldToBeEdited("L6W3C7",By.cssSelector("a"));
		addressBookPage.changeCountry("Canada");
		addressBookPage.changeState("Alberta");
		addressBookPage.changeCompany("infosys");
		sf.assertEquals(addressBookPage.getSuccessBannerText(),"Your address has been successfully updated", "Message Not Valid");
		sf.assertAll();
	}
	
	public void VerifyUserIsAbleToDeleteAddressFromAddressBook() {
		AddressBookPage addressBookPage= myAccountPage.clickAddressHistory();
		addressBookPage.fieldToBeDeleted("L6W5T1",By.cssSelector("a:last-of-type"));
		sf.assertEquals(addressBookPage.getSuccessBannerText(),"Your address has been successfully deleted", "Message Not Valid");
		sf.assertAll();
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
