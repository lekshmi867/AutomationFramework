package com.naveenaAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class LaptopNotebookPage extends Page {

	private static final String PAGE_URL="product/category&path=18";
	public LaptopNotebookPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}


	private static final By laptopNotebookText=By.xpath("//h2[text()='Laptops & Notebooks']");

	private static final By selectFromDropDownMenu=By.cssSelector("#input-sort");

	private static final By sonyVaioWishlistIcon=By.cssSelector("#content div.row:nth-of-type(4)>div:first-of-type div:nth-of-type(2) div:nth-of-type(2) button:nth-of-type(2)");

	private static final By MacBookProWishlistIcon=By.cssSelector("#content div.row:nth-of-type(4)>div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(2) button:nth-of-type(2) i");

	private static final By MacBookAirWishlistIcon=By.cssSelector("#content div.row:nth-of-type(4)>div:nth-of-type(3) div:nth-of-type(2) div:nth-of-type(2) button:nth-of-type(2)");

	private static final By wishlistLink=By.cssSelector("#wishlist-total");

	private static final By successBanner=By.cssSelector("div.alert.alert-success.alert-dismissible");

	public String getLaptopNotebbokText() {
		return ((ProxyDriver)wd).getText(laptopNotebookText);

	}

	public void selectByVisibleText(String text) {
		//WebElement element =wd.findElement(selectFromDropDownMenu);
		((ProxyDriver)wd).selectFromDropDown(selectFromDropDownMenu, text);
	}

	public void addSonyVaioToWishlist() {
		((ProxyDriver)wd).click(sonyVaioWishlistIcon);
	}

	public void addMacBookProToWishlist() {
		((ProxyDriver)wd).navigate().refresh();
		((ProxyDriver)wd).click(MacBookProWishlistIcon);
	}

	public void addMacBookAirToWishlist() {
		((ProxyDriver)wd).navigate().refresh();
		((ProxyDriver)wd).click(MacBookAirWishlistIcon);
	}

	public String getSuccessBannerText() {
		return ((ProxyDriver)wd).getText(successBanner);
	}

	
	public MyWishListPage clickWishList() {
		((ProxyDriver)wd).navigate().refresh();
		((ProxyDriver)wd).click(wishlistLink);
		return new MyWishListPage(wd,true);
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
