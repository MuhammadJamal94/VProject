package com.pagefactory;

import com.AdvancePlus.DriverPlus.DriverIXMethods;
import helper.CrazyLogger;
import helper.PropertiesLoader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelLocationspage {
	JavascriptExecutor jsDriver;
	WebDriver driver;
	WebDriverWait wait;
	CrazyLogger logger;
	Actions action;
	DriverIXMethods dIXMethods;
	PropertiesLoader properties;

	@FindBy(css = "button[type='submit']")
	public WebElement addLocationBTN;

	@FindBy(css = "div[id='s2id_autogen1']")
	public WebElement Country;

	@FindBy(name = "city")
	public WebElement City;

	@FindBy(name = "longitude")
	public WebElement CityLong;

	@FindBy(name = "latitude")
	public WebElement CityLat;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]")
	public WebElement cityTD;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[4]")
	public WebElement countryTD;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]")
	public WebElement latTD;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[6]")
	public WebElement longTD;

	@FindBy(xpath = "//tbody/tr[1]/td[8]/span[1]/a[1]/i[1]")
	public WebElement editBTN;


	/**
	 * Class constructor: a driver of type WebDriver and wait of type
	 * WebDriverWait must be passed as arguments
	 *
	 * @param driver
	 * @param wait
	 */
	public TravelLocationspage(WebDriver driver, WebDriverWait wait, JavascriptExecutor jsDriver, CrazyLogger logger,
                               Actions action) {

		this.jsDriver = jsDriver;
		this.wait = wait;
		this.driver = driver;
		this.logger = logger;
		this.action = action;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);
		dIXMethods = new DriverIXMethods(driver, wait, jsDriver, logger, action);

	}

	public void clickNewBTN() throws InterruptedException {
		Thread.sleep(100);
		dIXMethods.driverIXClick(addLocationBTN);
		Thread.sleep(100);
	}

	/**
	 * Chooses a certain country
	 * @throws InterruptedException
	 */
	public void selectCountry(String countryText) throws InterruptedException {
		dIXMethods.driverIXClick(Country);
		action.sendKeys(countryText).build().perform();
		Thread.sleep(100);
		action.sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(100);
	}

	/**
	 * Enter city
	 * @throws InterruptedException
	 */
	public void enterCity(String cityText) throws InterruptedException {
		dIXMethods.driverIXSendKeys(City, cityText);
		Thread.sleep(100);
	}

	/**
	 * Enter city latitude
	 * @throws InterruptedException
	 */
	public void enterLatitude(String latText) throws InterruptedException {
		dIXMethods.driverIXSendKeys(CityLat, latText);
		Thread.sleep(100);
	}

	/**
	 * Enter city longitude
	 * @throws InterruptedException
	 */
	public void enterLongitude(String longText) throws InterruptedException {
		dIXMethods.driverIXSendKeys(CityLong, longText);
		Thread.sleep(100);
	}

	public void clickEditBTN() throws InterruptedException {
		Thread.sleep(100);
		dIXMethods.driverIXClick(editBTN);
		Thread.sleep(100);
	}
}
