package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumRelated.SeleniumOperations;

public class HomePage extends SeleniumOperations {

	Logger log = LogManager.getLogger(HomePage.class.getName());

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Featured Destination: Aruba']")
	WebElement imageOnlyInHomePage;

	@FindBy(xpath = "//a[contains(text(),'REGISTER')]")
	WebElement registerLink;

	/**
	 * Login to URl
	 */
	@Test
	public void homePageLogin() {
		driver.get(loadProperties().getProperty("url"));
		log.info("logged in to " + driver.getCurrentUrl());
	}

	/**
	 * verifies login to home page via testNG assert
	 */
	@Test
	public void homePageVerifyHomePage() {
		Assert.assertEquals(driver.getTitle(), loadTestDataProperties().getProperty("homePageTitle"));
		log.info("Home page title verified and title is : " + driver.getTitle());
		Assert.assertTrue(imageOnlyInHomePage.isDisplayed());
		log.info("Image present only in homepage is verified");
	}

	/**
	 * Click on register link
	 */
	@Test
	public void homePageClickOnRegister() {
		registerLink.click();
		log.info("Register link is clicked");
	}

}
