package com.naveenaAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomation.Base.TestBase;

public class LaptopNotebookPage extends TestBase {
	public LaptopNotebookPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Laptops & Notebooks']")
	WebElement laptopNotebookText;

	@FindBy(css = "#input-sort")
	WebElement selectFromDropDownMenu;

	@FindBy(css = "#content div.row:nth-of-type(4)>div:first-of-type div:nth-of-type(2) div:nth-of-type(2) button:nth-of-type(2)")
	WebElement sonyVaioWishlistIcon;

	@FindBy(css = "#content div.row:nth-of-type(4)>div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(2) button:nth-of-type(2) i")
	WebElement MacBookProWishlistIcon;

	@FindBy(css = "#content div.row:nth-of-type(4)>div:nth-of-type(3) div:nth-of-type(2) div:nth-of-type(2) button:nth-of-type(2)")
	WebElement MacBookAirWishlistIcon;

	@FindBy(css = "#wishlist-total")
	WebElement wishlistLink;

	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	WebElement successBanner;

	public String getLaptopNotebbokText() {
		return laptopNotebookText.getText();

	}

	public void selectByVisibleText(String text) {
		Select sc = new Select(selectFromDropDownMenu);
		sc.selectByVisibleText(text);
	}

	public void addSonyVaioToWishlist() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content div.row:nth-of-type(4)>div:first-of-type div:nth-of-type(2) div:nth-of-type(2) button:nth-of-type(2)")));
		sonyVaioWishlistIcon.click();
	}

	public void addMacBookProToWishlist() {

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(MacBookProWishlistIcon));
		MacBookProWishlistIcon.click();
	}

	public void addMacBookAirToWishlist() {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content div.row:nth-of-type(4)>div:nth-of-type(3) div:nth-of-type(2) div:nth-of-type(2) button:nth-of-type(2)")));		
		MacBookAirWishlistIcon.click();
	}

	public String getSuccessBannerText() {
		wait.until(ExpectedConditions.visibilityOf(successBanner));
		return successBanner.getText();
	}

	
	public MyWishListPage clickWishList() {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#wishlist-total")));
		wishlistLink.click();
		return new MyWishListPage();
	}
}
