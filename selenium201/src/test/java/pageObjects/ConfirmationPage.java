package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumRelated.SeleniumOperations;

public class ConfirmationPage extends SeleniumOperations  {

	Logger log = LogManager.getLogger(ConfirmationPage.class.getName());

	public ConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='/images/printit.gif']")
	WebElement printButton;
	
	@FindBy(xpath = "//img[@src='/images/forms/backtoflights.gif']")
	WebElement backToFlightButton;
	
	@FindBy(xpath = "//img[@src='/images/forms/home.gif']")
	WebElement backToHomeButton;
	
	@FindBy(xpath = "//img[@src='/images/forms/Logout.gif']")
	WebElement logOutButton;
	
	@Test
	public void conformationPageVerifyPage() {
		Assert.assertEquals(driver.getCurrentUrl(), loadTestDataProperties().getProperty("conformationPageUrl"));
		log.info("Paymet page is verified ");
	}
	
	@Test
	public void conformationPagePrintTicket() {
		printButton.click();
		log.info("Ticket has been printed");
	}
	
	@Test
	public void conformtionPageLogOut() {
		logOutButton.click();
	}
	
	
	
	
	
	
}
