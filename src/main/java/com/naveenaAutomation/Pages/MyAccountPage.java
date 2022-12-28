package com.naveenaAutomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class MyAccountPage extends TestBase {
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccountText;
	
	@FindBy(xpath = "//a[text()='Edit your account information']")
	WebElement editYourAccountInfo;
	
	@FindBy(css = "div.alert-success")
	WebElement accountUpdateSuccessBanner;
	
	@FindBy(xpath="//a[contains(text(),'Subscribe')]")
	WebElement subscribeNewsletterLink;
	
	@FindBy(css="div.list-group a:last-of-type")
	WebElement logoutLink;

	public String getMyAccountText() {
		return myAccountText.getText();
	}
	
	public MyAcccountInformationPage clickEditYourAccountInfo() {
		editYourAccountInfo.click();
		return new MyAcccountInformationPage();
	}
	
	public String getAccountUpdateeSuccessMessage() {
		return accountUpdateSuccessBanner.getText();
	}
	
	public NewsLetterSubscriptionPage clickSubscribeNewsLetterLink() {
		subscribeNewsletterLink.click();
		return new NewsLetterSubscriptionPage();
	}
	
	public AccountLogoutPage clickLogoutLink() {
		logoutLink.click();
		return new AccountLogoutPage();
	}

	
}
