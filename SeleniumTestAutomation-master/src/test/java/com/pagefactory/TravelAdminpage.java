package com.pagefactory;

import com.AdvancePlus.DriverPlus.DriverIXMethods;
import helper.CrazyLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelAdminpage {
	JavascriptExecutor jsDriver;
	WebDriver driver;
	WebDriverWait wait;
	String instance;
	CrazyLogger logger;
	Actions action;
	DriverIXMethods dIXMethods;

	@FindBy(xpath = "//header/div[1]/div[1]/div[2]/form[1]/button[1]")
	public WebElement AddBTN;

	@FindBy(name = "fname")
	public WebElement FirstName;

	@FindBy(name = "lname")
	public WebElement LastName;

	@FindBy(name = "email")
	public WebElement EmailAddress;

	@FindBy(name = "password")
	public WebElement Password;

	@FindBy(name = "mobile")
	public WebElement MobileNumber;

	@FindBy(css = "input[value='editlocationsRentals']")
	public WebElement EditLocations;

	@FindBy(css = "input[value='addlocationsRentals']")
	public WebElement ADDLocations;

	@FindBy(css = "div[id='s2id_autogen1']")
	public WebElement Country;

	@FindBy(xpath = "//body/div[@id='layoutDrawer']/div[@id='layoutDrawer_content']/main[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[4]/button[1]")
	public WebElement SaveBTN;

	/**
	 * Class constructor: takes a driver of type WebDriver, a wait of type
	 * WebDriverWait and a javascript executor of type JavascriptExecutor
	 *
	 * @param driver
	 * @param wait
	 * @param jse
	 */
	public TravelAdminpage(WebDriver driver, WebDriverWait wait, JavascriptExecutor jsDriver, CrazyLogger logger,
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

	/**
	 * Enter new admin name
	 * @throws InterruptedException
	 */
	public void addNewAccountName(String aName) throws InterruptedException {
		Thread.sleep(100);
		dIXMethods.driverIXSendKeys(FirstName, aName);
		Thread.sleep(100);
	}

	/**
	 * Enter new admin email
	 * @throws InterruptedException
	 */
	public void addNewAccountEmail(String newEmail) throws InterruptedException {
		dIXMethods.driverIXSendKeys(EmailAddress, newEmail);
		Thread.sleep(100);
	}

	/**
	 * Enter new admin password
	 * @throws InterruptedException
	 */
	public void addNewAccountPassword(String newPassword) throws InterruptedException {
		dIXMethods.driverIXSendKeys(Password, newPassword);
		Thread.sleep(100);
	}
	public void addNewAccountData() throws InterruptedException {
		dIXMethods.driverIXSendKeys(LastName, "Johns");
		Thread.sleep(100);
		dIXMethods.driverIXSendKeys(MobileNumber, "12223455698");
		Thread.sleep(100);
		dIXMethods.driverIXClick(ADDLocations);
		Thread.sleep(100);
		dIXMethods.driverIXClick(EditLocations);
		Thread.sleep(100);
	}

	public void selectCountry(String countryText) throws InterruptedException {
		dIXMethods.driverIXClick(Country);
		action.sendKeys(countryText).build().perform();
		Thread.sleep(100);
		action.sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(100);
	}

	/**
	 * Clicks on the add account tab on the left menu after successful login
	 * @throws InterruptedException
	 */
	public void clickAddBTN() throws InterruptedException {
		dIXMethods.driverIXClick(AddBTN);
		Thread.sleep(100);
	}

	public void clickSaveBTN() throws InterruptedException {
		dIXMethods.driverIXClick(SaveBTN);
		Thread.sleep(100);
	}

	/**
	 * Navigate through 1 elements sequentially
	 * 
	 * @param element1
	 * @throws InterruptedException
	 */
	public void navigateTo(WebElement element1) throws InterruptedException {
		dIXMethods.driverIXClick(element1);
		Thread.sleep(100);
	}
}
