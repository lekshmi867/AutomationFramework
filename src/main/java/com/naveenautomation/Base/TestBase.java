package com.naveenautomation.Base;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.naveenautomation.Browsers.Browsers;
import com.naveenautomation.Browsers.ProxyDriver;
import com.naveenautomation.Listeners.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public Browsers DEFAULT_BROWSER = Browsers.GOOGLE_CHROME;
	public static WebdriverEvents events=new WebdriverEvents();
	public EventFiringWebDriver eventFiringWebDriver;

	public void launchBrowser() {

		switch (DEFAULT_BROWSER) {
		case GOOGLE_CHROME:
			driver = new ProxyDriver(WebDriverManager.chromedriver().create());
			break;

		case EDGE:
			driver = new ProxyDriver(WebDriverManager.edgedriver().create());
			break;

		case FIREFOX:
			driver = new ProxyDriver(WebDriverManager.firefoxdriver().create());
			break;

		default:
			System.out.println("Not a valid browser");
			break;
		}
		
		 eventFiringWebDriver=new EventFiringWebDriver(driver);
		 eventFiringWebDriver.register(events); 
		 //driver=eventFiringWebDriver;
		 

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		// Manage the page load timeout
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Manage the script load timeout
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}

	public void quitBrowser() {
		// closing the browser
		driver.close();
	}

}