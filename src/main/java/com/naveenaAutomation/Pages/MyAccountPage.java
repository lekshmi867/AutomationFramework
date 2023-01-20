package com.naveenaAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.naveenautomation.Browsers.ProxyDriver;

public class MyAccountPage extends Page {
	private static final String PAGE_URL="account/account";
	public MyAccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final By myAccountText = By.xpath("//h2[text()='My Account']");

	private static final By editYourAccountInfo = By.xpath("//a[text()='Edit your account information']");

	private static final By accountUpdateSuccessBanner = By.cssSelector("div.alert-success");

	private static final By subscribeNewsletterLink = By.xpath("//a[contains(text(),'Subscribe')]");

	private static final By logoutLink = By.cssSelector("div.list-group a:last-of-type");

	private static final By laptopMousehover = By.xpath("//a[text()='Laptops & Notebooks']");

	private static final By showAllLaptopLink = By.xpath("//a[text()='Show All Laptops & Notebooks']");

	private static final By addressHistoryIcon = By.cssSelector("div.list-group a:nth-of-type(4)");

	public LaptopNotebookPage clickShowAllLaptopLink() {
		((ProxyDriver) wd).mouseHoverAction(wd.findElement(laptopMousehover));
		((ProxyDriver) wd).click(showAllLaptopLink);
		return new LaptopNotebookPage(wd, true);
	}

	public String getMyAccountText() {
		return ((ProxyDriver) wd).getText(myAccountText);
	}

	public MyAccountInformationPage clickEditYourAccountInfo() {
		((ProxyDriver) wd).click(editYourAccountInfo);
		return new MyAccountInformationPage(wd, true);
	}

	public String getAccountUpdateeSuccessMessage() {
		return ((ProxyDriver) wd).getText(accountUpdateSuccessBanner);
	}

	public NewsLetterSubscriptionPage clickSubscribeNewsLetterLink() {
		((ProxyDriver) wd).click(subscribeNewsletterLink);
		return new NewsLetterSubscriptionPage(wd, true);
	}

	public AccountLogoutPage clickLogoutLink() {
		((ProxyDriver) wd).click(logoutLink);
		return new AccountLogoutPage(wd, true);
	}

	public AddressBookPage clickAddressHistory() {
		((ProxyDriver) wd).click(addressHistoryIcon);
		return new AddressBookPage(wd, true);
	}

	@Override
	protected void isLoaded() {

		if(!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}
	
	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}
}
