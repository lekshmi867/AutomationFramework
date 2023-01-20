package com.naveenaAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Browsers.ProxyDriver;

public class AccountLoginPage extends Page {

	private static final String PAGE_URL="account/login";
	
	public AccountLoginPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		
	}

	private static final By emailInputField=By.cssSelector("form div.form-group:first-of-type input");

	private static final By passwordInputField=By.cssSelector("form div.form-group:last-of-type input");

	private static final By loginBtn=By.cssSelector("input[type='submit']");
	
	private void enterEmailInputField(String email) {
		((ProxyDriver) wd).sendKeys(emailInputField, email);
	}

	private void enterPasswordInputField(String password) {
		((ProxyDriver) wd).sendKeys(passwordInputField, password);
	}

	public MyAccountPage login(String email, String password) {
		enterEmailInputField(email);
		enterPasswordInputField(password);
		((ProxyDriver)wd).submit(loginBtn);
		return new MyAccountPage(wd,true);

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
	public AccountLoginPage get() {
		return (AccountLoginPage)super.get();
	}
}
