package com.naveenaAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class NewsLetterSubscriptionPage extends Page {

	private static final String PAGE_URL="account/newsletter";
	
	public NewsLetterSubscriptionPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		
	}


	private static final By subscribeYesRadioBtn=By.xpath("//input[@value='1']");
	
	private static final By subscribeNoRadioBtn=By.xpath("//input[@value='0']");
	
	private static final By continueBtn=By.xpath("//input[@value='Continue']");
	
	public void clickSubscribeOption(String option) {
		if(option.equalsIgnoreCase("yes")){
			((ProxyDriver)wd).click(subscribeYesRadioBtn);
		}
		else {
			((ProxyDriver)wd).click(subscribeNoRadioBtn);
		}
		
	}
	
	public MyAccountPage clickContinueBtn() {
		((ProxyDriver)wd).click(continueBtn);
		return new MyAccountPage(wd, true);
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
