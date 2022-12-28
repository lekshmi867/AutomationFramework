package com.naveenaAutomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class MyAcccountInformationPage extends TestBase {

	public MyAcccountInformationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="#input-telephone")
	WebElement phoneNumberField;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueBtn;
	
	public void changePhoneNumber(String number) {
		phoneNumberField.clear();
		phoneNumberField.sendKeys(number);
	}
	
	public MyAccountPage clickContinueBtn() {
		continueBtn.click();
		return new MyAccountPage();
	}
	
}
