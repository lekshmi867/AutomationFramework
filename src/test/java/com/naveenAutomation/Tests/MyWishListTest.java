package com.naveenAutomation.Tests;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenaAutomation.Pages.AccountLoginPage;
import com.naveenaAutomation.Pages.LaptopNotebookPage;
import com.naveenaAutomation.Pages.MyAccountPage;
import com.naveenaAutomation.Pages.MyWishListPage;
import com.naveenaAutomation.Pages.MyWishListPage.WishList;
import com.naveenaAutomation.Pages.StorePage;
import com.naveenautomation.Base.TestBase;

public class MyWishListTest extends TestBase {

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
	public void VerifyUserIsAbleToSignUpSuccessFully() {
		LaptopNotebookPage laptopNotebbokPage = myAccountPage.clickShowAllLaptopLink();
		sf.assertEquals(driver.getTitle(),"Laptops & Notebooks","Page not valid");
		sf.assertEquals(laptopNotebbokPage.getLaptopNotebbokText(), "Laptops & Notebooks", "text is incorrect");
		laptopNotebbokPage.selectByVisibleText("Rating (Highest)");
		laptopNotebbokPage.addSonyVaioToWishlist();
		sf.assertEquals(laptopNotebbokPage.getSuccessBannerText(), "Success: You have added Sony VAIO to your wish list!\n×","Message not valid");
		laptopNotebbokPage.addMacBookProToWishlist();
		sf.assertEquals(laptopNotebbokPage.getSuccessBannerText(),"Success: You have added MacBook Pro to your wish list!\n×", "Message Not Valid");
		laptopNotebbokPage.addMacBookAirToWishlist();
		sf.assertEquals(laptopNotebbokPage.getSuccessBannerText(),"Success: You have added MacBook Air to your wish list!\n×", "Message Not Valid");
		MyWishListPage myWishListPage = laptopNotebbokPage.clickWishList();
		sf.assertEquals(myWishListPage.getTitleFromPage(),"My Wish List", "Page not valid");
		WebElement sonyPriceElement=myWishListPage.getElementFromTheTable("Sony VAIO", WishList.UNITPRICE);
		sf.assertEquals(sonyPriceElement.getText(),"$1,202.00", "Price not matching");
		WebElement macProPriceElement=myWishListPage.getElementFromTheTable("MacBook Pro", WishList.UNITPRICE);
		sf.assertEquals(macProPriceElement.getText(),"$2,000.00", "Price not matching");
		WebElement macAirPriceElement=myWishListPage.getElementFromTheTable("MacBook Air", WishList.UNITPRICE);
		sf.assertEquals(macAirPriceElement.getText(),"$1,202.00", "Price not matching");
		WebElement elementToBeDeleted =myWishListPage.getElementFromTheTable("Sony VAIO", WishList.ACTION);
		myWishListPage.clickItemToBeDeletedFromwishList(elementToBeDeleted);
		sf.assertEquals(myWishListPage.getSuccessBannerText(),"Success: You have modified your wish list!\n×", "Invalid success message");
		sf.assertAll();
		
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
