package com.naveenaAutomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomation.Base.TestBase;



public class MyWishListPage extends TestBase{
	
	public MyWishListPage() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(css="div.alert-success")
	private WebElement successBanner;
	
	public WebElement getElementFromTheTable(String productName, WishList column) {

		int columnIndex = getIndexForColumn(column);

		List<WebElement> rowsInTable = driver
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
		wait.until(ExpectedConditions.titleIs("My Wish List"));
		return driver.getTitle();
	}
	
	
	private int getIndexForColumn(WishList column) {
		List<WebElement> headers = driver
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] thead tr td"));
		
		
		int columnIndex =  headers.stream()
				.filter(h->h.getText()
				.equals(column.getName()))
				.findAny()
				.map(h->headers.indexOf(h)).orElse(-1);
		return columnIndex;
		
	}
	
	
	public String getSuccessBannerText() {
		return successBanner.getText();
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
}
