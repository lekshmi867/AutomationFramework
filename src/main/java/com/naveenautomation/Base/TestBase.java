package com.naveenautomation.Base;
import com.naveenautomation.Browsers.Browsers;
import com.naveenautomation.Listeners.WebdriverEvents;

//import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Actions action;
	public Browsers DEFAULT_BROWSER = Browsers.GOOGLE_CHROME;
	public static WebDriverWait wait;
	public static WebdriverEvents events=new WebdriverEvents();
	public EventFiringWebDriver eventFiringWebDriver;
	
	
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
		eventFiringWebDriver=new EventFiringWebDriver(driver);
		eventFiringWebDriver.register(events);
		driver=eventFiringWebDriver;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Launch a page
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

		

	}

	public void quitBrowser() {
		// closing the browser
		driver.quit();
	}
}
