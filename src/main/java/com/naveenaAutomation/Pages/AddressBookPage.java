package com.naveenaAutomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomation.Base.TestBase;

public class AddressBookPage extends TestBase {
	public AddressBookPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.alert-success")
	WebElement successBanner;

	@FindBy(css = "#input-company")
	WebElement companyField;

	@FindBy(css = "input[type='Submit']")
	WebElement continueButton;
	
	@FindBy(css = "#input-country")
	WebElement countryDropDownMenu;
	
	@FindBy(css = "#input-zone")
	WebElement stateDropDownMenu;

	private WebElement getElementFromTheTable(String key) {

		List<WebElement> rowsInTable = driver
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
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='New Address']"))));
		getElementFromTheTable(key).findElement(locator).click();
	}
	
	public void fieldToBeDeleted(String key, By locator) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='New Address']"))));
		getElementFromTheTable(key).findElement(locator).click();
		acceptAlert();
	}

	private void clickContinueBtn() {
		continueButton.submit();
	}

	public void changeCompany(String address) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='submit']")));
		companyField.clear();
		companyField.sendKeys(address);
		clickContinueBtn();
	}
	
	private void selectByVisibleText(String text, WebElement element) {
		Select sc = new Select(element);
		sc.selectByVisibleText(text);
	}
	
	public void changeCountry(String text) {
		selectByVisibleText(text, countryDropDownMenu);
	}

	public void changeState(String text) {
		selectByVisibleText(text, stateDropDownMenu);
	}
	
	private void acceptAlert() {
		driver.switchTo().alert().accept();;
	}

	public String getSuccessBannerText() {
		return successBanner.getText();
	}

}
