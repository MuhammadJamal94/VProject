package com.AdvancePlus.Test;

import com.AdvancePlus.DriverPlus.DriverIXMethods;
import com.AdvancePlus.DriverPlus.DriverIXSetup;
import com.pagefactory.TravelAdminpage;
import com.pagefactory.TravelHomepage;
import com.pagefactory.TravelLoginpage;
import com.paulhammant.ngwebdriver.NgWebDriver;
import helper.CrazyLogger;
import helper.PropertiesLoader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PHPT_T2 {
	private WebDriver driver;
	private DriverIXSetup xDriver;
	private Actions action;
	private AssertionError assertionMessage;
	private Exception exceptionMessage;
	private CrazyLogger logger;
	private JavascriptExecutor jsDriver;
	private NgWebDriver ngDriver;
	private WebDriverWait wait;
	private TravelHomepage homepage;
	private TravelLoginpage loginpage;
	private TravelAdminpage adminPage;
	private DriverIXMethods dIXMethods;
	private PropertiesLoader properties;

	@BeforeMethod
	@Parameters({ "browser", "state", "URL" , "tester"})
	public void setup(String browser, String state, String URL, String tester) throws Exception {
		xDriver = new DriverIXSetup(driver, browser, URL);
		driver = xDriver.setup(driver, browser);
		jsDriver = (JavascriptExecutor) driver;
		ngDriver = new NgWebDriver(jsDriver);
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		logger = new CrazyLogger(this.getClass().getSimpleName(), driver, browser, state, tester);
		logger.prepareTest(this.getClass().getSimpleName());
		action = new Actions(driver);
		homepage = new TravelHomepage(driver, wait, jsDriver, logger, action);
		loginpage = new TravelLoginpage(driver, wait, jsDriver, logger, action);
		adminPage = new TravelAdminpage(driver, wait, jsDriver, logger, action);
		dIXMethods = new DriverIXMethods(driver, wait, jsDriver, logger, action);
		properties = new PropertiesLoader(tester);
	}

	@Test
	@Parameters({"URL","tester"})
	public void test(String URL, String tester) throws Exception {
		try {
			dIXMethods.getURL(URL);
			ngDriver.waitForAngularRequestsToFinish();

			String newEmail = properties.fetchProperty("newA.user");
			System.out.println("This is the user name " + newEmail);
			String newPassword = properties.fetchProperty("newA.pass");
			System.out.println("This is the password " + newPassword);

			logger.step("Navigate to phptravels.net/api/admin");
			//Already loaded in the lines above

			logger.step("Enter the email for the test account");
			dIXMethods.driverIXSendKeys(loginpage.email, newEmail);

			logger.step("Enter the correct password related to the registered test account email");
			dIXMethods.driverIXSendKeys(loginpage.pass, newPassword);

			logger.step("Click on the login button");
			dIXMethods.driverIXClick(loginpage.loginButton);
			logger.step("Validate that the user logged in successfully");
			WebElement usernameElmnt = 	wait.until(ExpectedConditions.visibilityOf(homepage.DashboardText));
			Assert.assertEquals(true, usernameElmnt.isDisplayed());

			// logger.step("Click on the modules tab (BY PASS AN ISSUE)");
			// homepage.clickModu	lesOnLeftRail();

			logger.step("Click on locations tab");
			homepage.clickLocationsOnLeftRail();
		}

		catch (AssertionError e) {
			assertionMessage = e;
			throw e;
		}

		catch (Exception e) {
			exceptionMessage = e;
			throw e;
		}

	}

	@AfterMethod(alwaysRun = true)
	@Parameters({"executionCycle" , "browser"})
	public void cleanup(ITestResult testResult, String executionCycle, String browser) throws Exception {
		logger.logResult(testResult, this.getClass().getSimpleName(),executionCycle, assertionMessage, exceptionMessage, browser);
		driver.quit();
	}

}