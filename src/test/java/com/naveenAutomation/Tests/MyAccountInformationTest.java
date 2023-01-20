package com.naveenAutomation.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenaAutomation.Pages.AccountLoginPage;
import com.naveenaAutomation.Pages.MyAccountInformationPage;
import com.naveenaAutomation.Pages.MyAccountPage;
import com.naveenaAutomation.Pages.StorePage;
import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Utils.ExcelUtils;

public class MyAccountInformationTest extends TestBase {

	StorePage storePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	SoftAssert sf = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		storePage = new StorePage(driver,true).get();
		}

	@Test(dataProvider = "LoginDataProvider")
	public void verifyAccountInfoIsPreFilledonTheEditAccountInfo(String userName, String password, String firstName, String lastName, String email, String phoneNumber ) {
		accountLoginPage =storePage.clickLoginLink();
		myAccountPage = accountLoginPage.login(userName, password);
		MyAccountInformationPage myAccountInformationPage= myAccountPage.clickEditYourAccountInfo();
		sf.assertEquals(myAccountInformationPage.getFirstName(), firstName,"Incorrect first name");
		sf.assertEquals(myAccountInformationPage.getLastName(), lastName, "Incorrect last name");
		sf.assertEquals(myAccountInformationPage.getEmail(), email, "Incorrect email");
		sf.assertEquals(myAccountInformationPage.getPhoneNumber(), phoneNumber, "Incorrect phone number");
		sf.assertAll();
	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] provideLoginData() throws IOException {
		String filePath = "./Test Data\\Details.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);
		String[][] data = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return data;

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
