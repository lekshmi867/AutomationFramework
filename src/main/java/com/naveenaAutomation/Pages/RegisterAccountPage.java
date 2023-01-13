package com.naveenaAutomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class RegisterAccountPage extends TestBase {
	public RegisterAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement fName;

	@FindBy(id = "input-lastname")
	private WebElement lName;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-telephone")
	private WebElement telephone;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement privacyPolicyCheckBox;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueBtn;

	private void enterFirstName(String fname) {
		fName.sendKeys(fname);
	}

	private void enterLastName(String lname) {
		lName.sendKeys(lname);
	}

	private void enterEmail(String emailInput) {
		email.sendKeys(emailInput);
	}

	private void enterPhoneNumber(String phone) {
		telephone.sendKeys(phone);
	}

	private void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	private void enterConfirmPwd(String cPwd) {
		confirmPassword.sendKeys(cPwd);
	}

	private void clickPrivacyPolicy() {
		privacyPolicyCheckBox.click();
	}

	public AccountCreatedPage signUp(String fname, String lname, String emailInput, String phone, String pwd, String cPwd) {
		enterFirstName(fname);
		enterLastName(lname);
		enterEmail(emailInput);
		enterPhoneNumber(phone);
		enterPassword(pwd);
		enterConfirmPwd(cPwd);
		clickPrivacyPolicy();
		continueBtn.click();
		return new AccountCreatedPage();
	}
}
