package com.naveenautomation.Base;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;

	public void launchBrowser() {
		
		String browserForTesting="chrome";
		
		switch (browserForTesting.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			

		default:
			System.out.println("Not a valid browser");
			break;
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Launch a page
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}

	public void quitBrowser() {
		// closing the browser
		driver.close();
	}
}