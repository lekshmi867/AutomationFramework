package com.naveenautomation.Base;
import com.naveenautomation.Browsers.Browsers;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Actions action;
	public Browsers DEFAULT_BROWSER = Browsers.GOOGLE_CHROME;
	public static WebDriverWait wait;
	
	
	public void launchBrowser() {
		switch (DEFAULT_BROWSER) {
		case GOOGLE_CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			

		default:
			System.out.println("Not a valid browser");
			break;
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		// Launch a page
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public void quitBrowser() {
		// closing the browser
		driver.quit();
	}
}
