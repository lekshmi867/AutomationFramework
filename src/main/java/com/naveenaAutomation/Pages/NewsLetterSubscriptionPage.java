package com.naveenaAutomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class NewsLetterSubscriptionPage extends TestBase {

	public NewsLetterSubscriptionPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='1']")
	WebElement subscribeYesRadioBtn;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement subscribeNoRadioBtn;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueBtn;
	
	public void clickSubscribeOption(String option) {
		if(option.equalsIgnoreCase("yes")){
			subscribeYesRadioBtn.click();
		}
		else {
			subscribeNoRadioBtn.click();
		}
		
	}
	
	public MyAccountPage clickContinueBtn() {
		continueBtn.click();
		return new MyAccountPage();
	}

}
