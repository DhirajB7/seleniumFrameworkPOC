package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import seleniumRelated.SeleniumOperations;

public class SignOnPage extends SeleniumOperations {

	Logger log = LogManager.getLogger(SignOnPage.class.getName());

	public SignOnPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "userName")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "login")
	WebElement loginButton;

	/**
	 * Log in using user name and password .Test data in Testng.xml
	 *
	 */
	
	@Test
	public void signOnPageSignOn() {
		username.sendKeys(loadTestDataProperties().getProperty("userNameString"));
		log.info("user name filled");

		password.sendKeys(loadTestDataProperties().getProperty("passWordString"));
		log.info("password filled");

		loginButton.click();
		log.info("log in button clicked");
	}
}
