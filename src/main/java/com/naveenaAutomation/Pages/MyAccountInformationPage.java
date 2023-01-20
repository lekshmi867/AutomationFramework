package com.naveenaAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class MyAccountInformationPage extends Page {

	
	private static final String PAGE_URL="account/edit";
	public MyAccountInformationPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	private static final By firstNameField=By.cssSelector("#input-firstname");
	
	private static final By lastNameField=By.cssSelector("#input-lastname");
	
	private static final By emailField=By.cssSelector("#input-email");
	
	private static final By phoneNumberField=By.cssSelector("#input-telephone");
	
	private static final By continueBtn=By.xpath( "//input[@value='Continue']");
	
	public void changePhoneNumber(String number) {
		((ProxyDriver)wd).clear(phoneNumberField);
		((ProxyDriver)wd).sendKeys(phoneNumberField, number);
	}
	
	public String getFirstName() {
		return ((ProxyDriver)wd).getAttribute(firstNameField, "value");
	}
	
	public String getLastName() {
		return ((ProxyDriver)wd).getAttribute(lastNameField, "value");
	}
	
	public String getEmail() {
		return ((ProxyDriver)wd).getAttribute(emailField, "value");
	}
	
	public String getPhoneNumber() {
		return ((ProxyDriver)wd).getAttribute(phoneNumberField, "value");
	}
	public MyAccountPage clickContinueBtn() {
		((ProxyDriver)wd).click(continueBtn);
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
	
}
