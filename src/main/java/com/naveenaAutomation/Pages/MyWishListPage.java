package com.naveenaAutomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomation.Base.TestBase;

public class MyWishListPage extends TestBase{
	
	public MyWishListPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="tbody tr:nth-of-type(3) td:nth-of-type(6) a")
	WebElement deleteIcon;
	

	@FindBy(css="div.alert-success")
	WebElement successBanner;
	
	public WebElement getElementFromTheTable(String productName, WishList column) {

		int columnIndex = getIndexForColumn(column);
		//System.out.println(columnIndex);

		List<WebElement> rowsInTable = driver
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] tbody tr "));
		//System.out.println(rowsInTable);
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
	
	public String getTitleFromPage() {
		wait.until(ExpectedConditions.titleIs("My Wish List"));
		return driver.getTitle();
	}
	
	public int getIndexForColumn(WishList column) {
		List<WebElement> headers = driver
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] thead tr td"));

		for (WebElement webElement : headers) {
			String headerText = webElement.getText();
			if (headerText.equals(column.getName())) {
				return headers.indexOf(webElement);
			}

		}
		System.out.println("Column does not exist.....");
		return -1;
	}
	
	public void clickDeleteIcon() {
		deleteIcon.click();
	}
	
	public String getSuccessBannerText() {
		//wait.until(ExpectedConditions.textToBePresentInElement(successBanner, text));
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
