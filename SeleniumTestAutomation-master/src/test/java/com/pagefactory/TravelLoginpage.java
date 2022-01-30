package com.pagefactory;

import com.AdvancePlus.DriverPlus.DriverIXMethods;
import helper.CrazyLogger;
import helper.PropertiesLoader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelLoginpage {
	JavascriptExecutor jsDriver;
	WebDriver driver;
	WebDriverWait wait;
	CrazyLogger logger;
	Actions action;
	DriverIXMethods dIXMethods;
	PropertiesLoader properties;

	@FindBy(name = "email")
	public WebElement email;

	@FindBy(name = "password")
	public WebElement pass;

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	public WebElement loginButton;

	/**
	 * Class constructor: a driver of type WebDriver and wait of type
	 * WebDriverWait must be passed as arguments
	 *
	 * @param driver
	 * @param wait
	 */
	public TravelLoginpage(WebDriver driver, WebDriverWait wait, JavascriptExecutor jsDriver, CrazyLogger logger,
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
	 * This method will get the username and password from the conf. properties
	 * and login automatically
	 * @throws Exception 
	 */
	public void login(String tester) throws Exception {
		properties = new PropertiesLoader(tester);
		String username = properties.fetchProperty("admin.user");
		System.out.println("This is the user name " + username);
		String password = properties.fetchProperty("admin.pass");
		System.out.println("This is the password " + password);
		dIXMethods.driverIXSendKeys(email, username);
		dIXMethods.driverIXSendKeys(pass, password);
		dIXMethods.driverIXClick(loginButton);
		Thread.sleep(100);
	}
}
