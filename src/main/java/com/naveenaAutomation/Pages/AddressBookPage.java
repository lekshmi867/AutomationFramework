package com.naveenaAutomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.Browsers.ProxyDriver;

public class AddressBookPage extends Page {

	private static final String PAGE_URL="account/address";
	public AddressBookPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By successBanner = By.cssSelector("div.alert-success");

	private static final By companyField = By.cssSelector("#input-company");

	private static final By continueButton = By.cssSelector("input[type='Submit']");

	private static final By countryDropDownMenu = By.cssSelector("#input-country");

	private static final By stateDropDownMenu = By.cssSelector("#input-zone");

	private WebElement getElementFromTheTable(String key) {

		List<WebElement> rowsInTable = wd
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] tbody tr "));
		for (int i = 0; i < rowsInTable.size(); i++) {
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));

			String[] addressArray = cells.get(0).getText().split(" |\n");
			for (int j = 0; j < addressArray.length; j++) {
				if (addressArray[j].equalsIgnoreCase(key)) {
					return cells.get(1);
				}
			}
		}
		System.out.println("Column name was not found!!!");
		return null;
	}

	public void fieldToBeEdited(String key, By locator) {
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='New
		// Address']"))));
		// getElementFromTheTable(key).findElement(locator).click();
		((ProxyDriver) wd).click(getElementFromTheTable(key).findElement(locator));

	}

	public void fieldToBeDeleted(String key, By locator) {
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='New
		// Address']"))));
		// getElementFromTheTable(key).findElement(locator).click();
		((ProxyDriver) wd).click(getElementFromTheTable(key).findElement(locator));
		((ProxyDriver) wd).acceptAlert();
	}

	private void clickContinueBtn() {
		((ProxyDriver) wd).submit(continueButton);
	}

	public void changeCompany(String address) {
		((ProxyDriver) wd).clear(companyField);
		((ProxyDriver) wd).sendKeys(companyField, address);
		clickContinueBtn();
	}

	public void changeCountry(String text) {
		((ProxyDriver) wd).selectFromDropDown(countryDropDownMenu, text);
	}

	public void changeState(String text) {
		((ProxyDriver) wd).selectFromDropDown(stateDropDownMenu, text);
	}


	public String getSuccessBannerText() {
		return ((ProxyDriver) wd).getText(successBanner);
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
