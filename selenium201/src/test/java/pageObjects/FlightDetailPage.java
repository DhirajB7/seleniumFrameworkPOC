package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import seleniumRelated.SeleniumOperations;

public class FlightDetailPage extends SeleniumOperations {

	Logger log = LogManager.getLogger(FlightDetailPage.class.getName());

	public FlightDetailPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='outFlight' and contains(@value,'Blue Skies Airlines$360') ]")
	WebElement fromAirlineBlueSkies360;

	@FindBy(xpath = "//input[@name='outFlight' and contains(@value,'Blue Skies Airlines$361') ]")
	WebElement fromAirlineBlueSkies361;

	@FindBy(xpath = "//input[@name='outFlight' and contains(@value,'Pangea Airlines$362') ]")
	WebElement fromAirlinePangea362;

	@FindBy(xpath = "//input[@name='outFlight' and contains(@value,'Unified Airlines$363') ]")
	WebElement fromAirlineUnified363;

	@FindBy(xpath = "//input[@name='inFlight' and contains(@value,'Blue Skies Airlines$630') ]")
	WebElement toAirlineBlueSkies630;

	@FindBy(xpath = "//input[@name='inFlight' and contains(@value,'Blue Skies Airlines$631') ]")
	WebElement toAirlineBlueSkies631;

	@FindBy(xpath = "//input[@name='inFlight' and contains(@value,'Pangea Airlines$632') ]")
	WebElement toAirlinePangea632;

	@FindBy(xpath = "//input[@name='inFlight' and contains(@value,'Unified Airlines$633') ]")
	WebElement toAirlineUnified633;

	@FindBy(xpath = "//input[@name = 'reserveFlights']")
	WebElement continueButton;

	@Test
	public void flighDetailPageOneWay() {

		String flightName = loadTestDataProperties().getProperty("airlinePrefernce");

		if (flightName.equalsIgnoreCase("Blue Skies Airlines")) {
			log.info("Blue skies airline 361 will be selected");
			fromAirlineBlueSkies361.click();

		} else if (flightName.equalsIgnoreCase("Pangaea Airlines")) {
			log.info("Pangaea Airlines 362 will be selected");
			fromAirlinePangea362.click();

		} else if (flightName.equalsIgnoreCase("Unified Airlines")) {
			log.info("Unified Airlines 363 will be selected");
			fromAirlineUnified363.click();

		} else {
			log.info("Blue skies airline 360 will be selected");
			fromAirlineBlueSkies360.click();
		}

	}

	@Test
	public void flighDetailPageOtherWay() {

		String flightNameOtherWay = loadTestDataProperties().getProperty("airlinePrefernce");

		if (flightNameOtherWay.equalsIgnoreCase("Blue Skies Airlines")) {
			log.info("Blue skies airline 631 will be selected");
			toAirlineBlueSkies631.click();

		} else if (flightNameOtherWay.equalsIgnoreCase("Pangaea Airlines")) {
			log.info("Pangaea Airlines 632 will be selected");
			toAirlinePangea632.click();

		} else if (flightNameOtherWay.equalsIgnoreCase("Unified Airlines")) {
			log.info("Unified Airlines 633 will be selected");
			toAirlineUnified633.click();

		} else {
			log.info("Blue skies airline 630 will be selected");
			toAirlineBlueSkies630.click();
		}

	}
	
	@Test
	public void flightDetailPageClickOnContinue() {
		continueButton.click();
		log.info("Continue Button is clicked and will be navigated to next page");
	}

}
