package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumRelated.SeleniumOperations;

public class RegisterPage extends SeleniumOperations {

	Logger log = LogManager.getLogger(RegisterPage.class.getName());

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstName")
	WebElement firstName;

	@FindBy(name = "lastName")
	WebElement lastName;

	@FindBy(name = "phone")
	WebElement phone;

	@FindBy(name = "userName")
	WebElement email;

	@FindBy(name = "address1")
	WebElement address1;

	@FindBy(name = "address2")
	WebElement address2;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "postalCode")
	WebElement postalCode;

	@FindBy(name = "country")
	WebElement country;

	@FindBy(name = "email")
	WebElement userNameEmail;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "confirmPassword")
	WebElement confirmPassword;

	@FindBy(name = "register")
	WebElement registerButton;

	@FindBy(xpath = "//p/font/b")
	WebElement nameCheckInSuccessPage;

	@FindBy(xpath = "//a/font/b")
	WebElement userNameInSuccessPage;

	@FindBy(xpath = "//a[contains(text(),'sign-in')]")
	WebElement signInLinkInRegisterSuccessPage;

	/**
	 * Assert is used to check register page is opened or not
	 * 
	 */
	
	@Test
	public void registerPageVerifyRegisterPage() {
		Assert.assertEquals(driver.getTitle(), loadTestDataProperties().getProperty("registerPageTitle"));
		log.info("Register page title is verified and title is :" + driver.getTitle());
	}

	/**
	 * Fills Contact information of register page
	 * 
	 */

	@Test
	public void registerPageFillContactInformation() {
		firstName.sendKeys(loadTestDataProperties().getProperty("firstNameString"));
		log.info("first name Filled");

		lastName.sendKeys(loadTestDataProperties().getProperty("lastNameString"));
		log.info("last name Filled");

		phone.sendKeys(loadTestDataProperties().getProperty("phoneString"));
		log.info("phone number Filled");

		email.sendKeys(loadTestDataProperties().getProperty("emailString"));
		log.info("email Filled");
	}

	/**
	 * Fills Mailing Information in register page
	 * 
	 */

	@Test
	public void registerPageFillMailingInformation() {
		address1.sendKeys(loadTestDataProperties().getProperty("addressLine1"));
		log.info("Address line 1 filled");

		address2.sendKeys(loadTestDataProperties().getProperty("addressLine2"));
		log.info("Address line 2 filled");

		city.sendKeys(loadTestDataProperties().getProperty("cityName"));
		log.info("cityName filled");

		postalCode.sendKeys(loadTestDataProperties().getProperty("pinCode"));
		log.info("postal code filled");

		state.sendKeys(loadTestDataProperties().getProperty("stateName"));
		log.info("state name selected");

		Select sel = new Select(country);
		sel.selectByVisibleText(loadTestDataProperties().getProperty("countryName").trim());
		log.info("country selected from dropdown");

	}

	/**
	 * Fills User information and submits the registration
	 */
	
	@Test
	public void registerPageFillUserInformationAndClickSubmitButton() {
		userNameEmail.sendKeys(loadTestDataProperties().getProperty("userNameString"));
		log.info("user name filled");

		password.sendKeys(loadTestDataProperties().getProperty("passWordString"));
		log.info("password filled");

		confirmPassword.sendKeys(loadTestDataProperties().getProperty("passWordString"));
		log.info("confirm password filled");

		registerButton.click();
		log.info("Submit Button clicked");
	}

	/**
	 * Verifies Registration success process using TestNg Asserts
	 */
	
	@Test
	public void registerPageVerifyRegistered() {

		Assert.assertEquals(driver.getCurrentUrl(), loadTestDataProperties().getProperty("registerPageUrl"));
		log.info("Title is verified and it is : " + driver.getCurrentUrl());

		Assert.assertTrue(nameCheckInSuccessPage.getText().contains(loadTestDataProperties().getProperty("firstNameString")));
		log.info("First Name is verified");

		Assert.assertTrue(nameCheckInSuccessPage.getText().contains(loadTestDataProperties().getProperty("lastNameString")));
		log.info("Last Name is verified");

		Assert.assertTrue(userNameInSuccessPage.getText().contains(loadTestDataProperties().getProperty("userNameString")));
		log.info("User Name is verified");

	}

	/**
	 * sign-in link is clicked
	 * 
	 */
	
	@Test
	public void registerPageClickOnSignInLink() {
		signInLinkInRegisterSuccessPage.click();
		log.info("clicked on Sign-in link");

		Assert.assertEquals(driver.getCurrentUrl(), loadTestDataProperties().getProperty("signOnPageUrl"));
		log.info("User is in Sign-in page, and URL is " + driver.getCurrentUrl());
	}
}
