package com.pagefactory;

import com.AdvancePlus.DriverPlus.DriverIXMethods;
import helper.CrazyLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelHomepage {
	JavascriptExecutor jsDriver;
	WebDriver driver;
	WebDriverWait wait;
	String instance;
	CrazyLogger logger;
	Actions action;
	DriverIXMethods dIXMethods;

	@FindBy(xpath = "//div[contains(text(),'Sales overview & summary')]")
	public WebElement DashboardText;

	@FindBy(xpath = "//body/div[@id='layoutDrawer']/div[@id='layoutDrawer_nav']/nav[@id='drawerAccordion']/div[1]/div[1]/a[6]")
	public WebElement AccountsButton;

	@FindBy(xpath = "//body/div[@id='layoutDrawer']/div[@id='layoutDrawer_nav']/nav[@id='drawerAccordion']/div[1]/div[1]/a[4]")
	public WebElement ModulesButton;

	@FindBy(xpath = "//a[contains(text(),'Admins')]")
	public WebElement AdminsButton;

	@FindBy(xpath = "//div[@aria-label='Edit Profile' and @role='button']")
	public WebElement EditProfileButton;

	@FindBy(xpath = "//div[@aria-label='Edit profile' and @role='dialog']")
	public WebElement EditProfileDialog;

	@FindBy(xpath = "//header/div[1]/div[1]/div[2]/form[1]/button[1]")
	public WebElement AddBTN;

	@FindBy(css = "a[data-bs-target = '#Locations']")
	public WebElement LocationsBTN;

	@FindBy(xpath = "//a[contains(text(),'Locations')]")
	public WebElement LocationsLink;


	/**
	 * Class constructor: takes a driver of type WebDriver, a wait of type
	 * WebDriverWait and a javascript executor of type JavascriptExecutor
	 *
	 * @param driver
	 * @param wait
	 * @param jse
	 */
	public TravelHomepage(WebDriver driver, WebDriverWait wait, JavascriptExecutor jsDriver, CrazyLogger logger,
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
	 * Clicks on the accounts tab on the left menu after successful login
	 * @throws InterruptedException
	 */
	public void clickAccountsOnLeftRail() throws InterruptedException {
		dIXMethods.driverIXClick(AccountsButton);
		Thread.sleep(100);
	}

	/**
	 * Clicks on the modules tab on the left menu after successful login
	 * @throws InterruptedException
	 */
	public void clickModulesOnLeftRail() throws InterruptedException {
		dIXMethods.driverIXClick(ModulesButton);
		Thread.sleep(100);
	}

	/**
	 * Clicks on the admins tab on the left menu after successful login
	 * @throws InterruptedException
	 */
	public void clickAdminsOnLeftRail() throws InterruptedException {
		dIXMethods.driverIXClick(AdminsButton);
		Thread.sleep(100);
	}

	/**
	 * Clicks on the admins tab on the left menu after successful login
	 * @throws InterruptedException
	 */
	public void clickLocationsOnLeftRail() throws InterruptedException {
		dIXMethods.driverIXClick(LocationsBTN);
		Thread.sleep(100);
		dIXMethods.driverIXClick(LocationsLink);
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
