package com.saucedemo.TestBase;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.BeforeClass;

import com.saucedemo.Browsers.Browsers;
import com.saucedemo.Listeners.WebDriverEvents;

public class TestBase {

	private Browsers DEFAULT_BROWSER = Browsers.CHROME;
	public static WebDriver driver;
	public static Logger logger;
	private final String URL = "https://www.saucedemo.com/";

	public void initailise() {

		initialiseWebDriver();

		WebDriverListener listener = new WebDriverEvents();
		driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);

		driver.get(URL);
	}

	@BeforeClass
	public void setupLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);

	}

	private void initialiseWebDriver() {
		switch (DEFAULT_BROWSER) {
		case CHROME:
			driver = new ChromeDriver();
			break;

		case FIREFOX:
			driver = new FirefoxDriver();
			break;

		default:
			throw new IllegalArgumentException("Incorrect browser :" + DEFAULT_BROWSER);

		}
	}
	
	public void tearDown() {
		driver.quit();
	}

}
