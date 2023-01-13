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
	private WebElement myAccountText;
	
	@FindBy(xpath = "//a[text()='Edit your account information']")
	private WebElement editYourAccountInfo;
	
	@FindBy(css = "div.alert-success")
	private WebElement accountUpdateSuccessBanner;
	
	@FindBy(xpath="//a[contains(text(),'Subscribe')]")
	private WebElement subscribeNewsletterLink;
	
	@FindBy(css="div.list-group a:last-of-type")
	private WebElement logoutLink;
	
	@FindBy(xpath="//a[text()='Laptops & Notebooks']")
	private WebElement laptopMousehover;
	
	@FindBy(xpath="//a[text()='Show All Laptops & Notebooks']")
	private WebElement showAllLaptopLink;
	
	@FindBy(css="div.list-group a:nth-of-type(4)")
	private WebElement addressHistoryIcon;
	
	
	public LaptopNotebookPage clickShowAllLaptopLink() {
		action.moveToElement(laptopMousehover).perform();
		showAllLaptopLink.click();
		return new LaptopNotebookPage();
		}

	public String getMyAccountText() {
		return myAccountText.getText();
	}
	
	public MyAccountInformationPage clickEditYourAccountInfo() {
		editYourAccountInfo.click();
		return new MyAccountInformationPage();
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
	
	public AddressBookPage clickAddressHistory() {
		addressHistoryIcon.click();
		return new AddressBookPage();	
	}
	
	
}
