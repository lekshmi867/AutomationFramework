package com.naveenaAutomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class MyAccountInformationPage extends TestBase {

	public MyAccountInformationPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#input-firstname")
	WebElement firstNameField;
	
	@FindBy(css="#input-lastname")
	WebElement lastNameField;
	
	@FindBy(css="#input-email")
	WebElement emailField;
	
	@FindBy(css="#input-telephone")
	WebElement phoneNumberField;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueBtn;
	
	public void changePhoneNumber(String number) {
		phoneNumberField.clear();
		phoneNumberField.sendKeys(number);
	}
	
	public String getFirstName() {
		return firstNameField.getAttribute("value");
	}
	
	public String getLastName() {
		return lastNameField.getAttribute("value");
	}
	
	public String getEmail() {
		return emailField.getAttribute("value");
	}
	
	public String getPhoneNumber() {
		return phoneNumberField.getAttribute("value");
	}
	public MyAccountPage clickContinueBtn() {
		continueBtn.click();
		return new MyAccountPage();
	}
	
}
