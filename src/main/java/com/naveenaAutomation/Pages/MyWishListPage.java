package com.naveenaAutomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.Browsers.ProxyDriver;



public class MyWishListPage extends Page{
	private static final String PAGE_URL="account/wishlist";
	

	public MyWishListPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		
	}

	private static final By successBanner=By.cssSelector("div.alert-success");
	
	public WebElement getElementFromTheTable(String productName, WishList column) {

		int columnIndex = getIndexForColumn(column);

		List<WebElement> rowsInTable = wd
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] tbody tr "));
		for (int i = 0; i < rowsInTable.size(); i++) {
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));

			String productNameText = cells.get(1).getText();
			if (productNameText.equals(productName)) {
				return cells.get(columnIndex);
			}

		}
		
		System.out.println("Column name was not found!!!");
		return null;
	}
	
	public void clickItemToBeDeletedFromwishList(WebElement elementToBeDeleted) {
	
		elementToBeDeleted.findElement(By.cssSelector("a")).click();
	
		
		
	}
	
	public String getTitleFromPage() {
		//wait.until(ExpectedConditions.titleIs("My Wish List"));
		return ((ProxyDriver)wd).getTitle();
	}
	
	
	private int getIndexForColumn(WishList column) {
		List<WebElement> headers = wd
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] thead tr td"));
		
		
		int columnIndex =  headers.stream()
				.filter(h->h.getText()
				.equals(column.getName()))
				.findAny()
				.map(h->headers.indexOf(h)).orElse(-1);
		return columnIndex;
		
	}
	
	
	public String getSuccessBannerText() {
		return ((ProxyDriver)wd).getText(successBanner);
	}

	public enum WishList {

		IMAGE("Image"), 
		PRODUCTNAME("Product Name"), 
		NOOFPRODUCTS("No. of Products"), 
		MODEL("Model"), 
		STOCK("Stock"),
		UNITPRICE("Unit Price"),
		ACTION("Action");

		String name;

		private WishList(String name) {
			
			this.name = name;
		}



		public String getName() {
			return name;
		}
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
