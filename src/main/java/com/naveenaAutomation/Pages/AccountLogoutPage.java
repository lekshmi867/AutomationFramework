package com.naveenaAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class AccountLogoutPage extends Page {

	private static final String PAGE_URL="account/logout";
	
	public AccountLogoutPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By accountLogoutText=By.xpath("//h1[text()='Account Logout']");
	
	private static final By continueBtn=By.xpath("//a[text()='Continue']");
	

	public String getAccountLogoutText() {
		return ((ProxyDriver)wd).getText(accountLogoutText);
	}
	
	public StorePage clickContinuebtn() {
		((ProxyDriver)wd).click(continueBtn);
		return new StorePage(wd,true);
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
