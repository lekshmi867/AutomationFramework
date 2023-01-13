package com.naveenaAutomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class StorePage extends TestBase{


	public StorePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= "a[title='My Account']")
	private WebElement myaccount;
	
	@FindBy(css="ul.dropdown-menu li:first-of-type a")
	private WebElement register;
	
	@FindBy(css="ul.dropdown-menu li:last-of-type a")
	private WebElement login;
	
	
	private void clickMyAccountDropDown() {
		myaccount.click();
	}
	
	public RegisterAccountPage clickRegisterLink() {
		clickMyAccountDropDown();
		register.click();
		return new RegisterAccountPage();
	}
	
	public AccountLoginPage clickLoginLink() {
		clickMyAccountDropDown();
		login.click();
		return new AccountLoginPage();
	}

}
