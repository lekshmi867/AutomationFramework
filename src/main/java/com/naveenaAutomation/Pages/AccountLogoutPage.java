package com.naveenaAutomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class AccountLogoutPage extends TestBase {

	public AccountLogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Account Logout']")
	WebElement accountLogoutText;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement continueBtn;

	public String getAccountLogoutText() {
		return accountLogoutText.getText();
	}
	
	public StorePage clickContinuebtn() {
		continueBtn.click();
		return new StorePage();
	}
	
}
