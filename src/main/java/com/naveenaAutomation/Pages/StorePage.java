package com.naveenaAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class StorePage extends Page{
	
	public static final String PAGE_URL="common/home";

	public StorePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final By myaccount=By.cssSelector("a[title='My Account']");
	
	private static final By register=By.cssSelector("ul.dropdown-menu li:first-of-type a");
	
	private static final By login=By.cssSelector("ul.dropdown-menu li:last-of-type a");
	
	
	private void clickMyAccountDropDown() {
		((ProxyDriver)wd).click(myaccount);
	}
	
	public RegisterAccountPage clickRegisterLink() {
		clickMyAccountDropDown();
		((ProxyDriver)wd).click(register);
		return new RegisterAccountPage(wd,true);
	}
	
	public AccountLoginPage clickLoginLink() {
		clickMyAccountDropDown();
		((ProxyDriver)wd).click(login);
		return new AccountLoginPage(wd,true);
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
	
	@Override
	public StorePage get() {
		return (StorePage)super.get();
	}

}
