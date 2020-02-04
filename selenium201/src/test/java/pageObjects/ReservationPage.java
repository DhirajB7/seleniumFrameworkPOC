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

public class ReservationPage extends SeleniumOperations {

	Logger log = LogManager.getLogger(ReservationPage.class.getName());

	public ReservationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='roundtrip']")
	WebElement roundTripRadioButton;
	
	@FindBy(xpath = "//input[@value='oneway']")
	WebElement onewayTripRadioButton;
	
	@FindBy(name = "passCount")
	WebElement passengerCount;
	
	@FindBy(name = "fromPort")
	WebElement fromCity;
	
	@FindBy(name = "fromMonth")
	WebElement fromMonth;
	
	@FindBy(name = "fromDay")
	WebElement fromDay;
	
	@FindBy(name = "toPort")
	WebElement toCity;
	
	@FindBy(name = "toMonth")
	WebElement toMonth;
	
	@FindBy(name = "toDay")
	WebElement toDay;
	
	@FindBy(xpath = "//input[@value='Coach']")
	WebElement economyClass;
	
	@FindBy(xpath = "//input[@value='Business']")
	WebElement bussinessClass;
	
	@FindBy(xpath = "//input[@value='First']")
	WebElement firstClass;
	
	@FindBy(name = "airline")
	WebElement airline;
	
	@FindBy(xpath = "//input[@name='findFlights']")
	WebElement continueButton;
	
	@FindBy(xpath = "//a[contains(text(),'SIGN-OFF')]")
	WebElement signOffButton;

	/**
	 * Assert is used to verify if sign on has happened
	 */

	@Test
	public void reservationPageVerifySignIn() {
		Assert.assertEquals(driver.getCurrentUrl(), loadTestDataProperties().getProperty("reservationPageUrl"));
		log.info("URL verified and ReservationPage URL is : " + driver.getCurrentUrl());
	}
	
	@Test
	public void reservationPageOnewayTrip() {
		
		String passengersCount=loadTestDataProperties().getProperty("passengersCount");
		String departingFrom=loadTestDataProperties().getProperty("departingFrom");
		String departingMonth=loadTestDataProperties().getProperty("departingMonth");
		String departingDate=loadTestDataProperties().getProperty("departingDate");
		String arrivingTo=loadTestDataProperties().getProperty("arrivingTo");
		String serviceClass=loadTestDataProperties().getProperty("serviceClass");
		String airlinePrefernce=loadTestDataProperties().getProperty("airlinePrefernce");
		
		onewayTripRadioButton.click();
		log.info("clicking on radio button - one Way ");
		
		Select passengerCountSelect = new Select(passengerCount);
		passengerCountSelect.selectByValue(passengersCount);
		log.info("passengers are selected and count is "+passengersCount);
		
		Select fromCitySelect = new Select(fromCity);
		fromCitySelect.selectByValue(departingFrom);
		log.info("Departing from : "+departingFrom);
		
		Select fromMonthSelect = new Select(fromMonth);
		fromMonthSelect.selectByValue(departingMonth);
		log.info("Departing month : "+departingMonth);
		
		Select fromDaySelect = new Select(fromDay);
		fromDaySelect.selectByValue(departingDate);
		log.info("Departing date : "+fromDaySelect);
		
		Select toCitySelect = new Select(toCity);
		toCitySelect.selectByValue(arrivingTo);
		log.info("Arrving to : "+arrivingTo);
		
		if(serviceClass.equalsIgnoreCase("Economy")) {
			
			economyClass.click();
			log.info("Economy class is selected");
			
		}else if (serviceClass.equalsIgnoreCase("First")) {
			
			firstClass.click();
			log.info("First class is selected");
			
		}else if(serviceClass.equalsIgnoreCase("Business")) {
			
			bussinessClass.click();
			log.info("Bussiness class is selected");
			
		}
		
		Select airlineSelect = new Select(airline);
		airlineSelect.selectByVisibleText(airlinePrefernce);
		log.info("Airline Prefernce is "+airlinePrefernce);
		
		continueButton.click();
		log.info("Continue Button is Clicked");
		
	}

	@Test
	public void reservationPageRoundwayTrip() {
		
		String passengersCount=loadTestDataProperties().getProperty("passengersCount");
		String departingFrom=loadTestDataProperties().getProperty("departingFrom");
		String departingMonth=loadTestDataProperties().getProperty("departingMonth");
		String departingDate=loadTestDataProperties().getProperty("departingDate");
		String arrivingTo=loadTestDataProperties().getProperty("arrivingTo");
		String returningMonth=loadTestDataProperties().getProperty("returningMonth");
		String returningDay=loadTestDataProperties().getProperty("returningDay");
		String serviceClass=loadTestDataProperties().getProperty("serviceClass");
		String airlinePrefernce=loadTestDataProperties().getProperty("airlinePrefernce");
		
		roundTripRadioButton.click();
		log.info("clicking on radio button - round trip ");
		
		Select passengerCountSelect = new Select(passengerCount);
		passengerCountSelect.selectByValue(passengersCount);
		log.info("passengers are selected and count is "+passengersCount);
		
		Select fromCitySelect = new Select(fromCity);
		fromCitySelect.selectByValue(departingFrom);
		log.info("Departing from : "+departingFrom);
		
		Select fromMonthSelect = new Select(fromMonth);
		fromMonthSelect.selectByValue(departingMonth);
		log.info("Departing month : "+departingMonth);
		
		Select fromDaySelect = new Select(fromDay);
		fromDaySelect.selectByValue(departingDate);
		log.info("Departing date : "+fromDaySelect);
		
		Select toCitySelect = new Select(toCity);
		toCitySelect.selectByValue(arrivingTo);
		log.info("Arrving to : "+arrivingTo);
		
		Select returningMonthSelect = new Select(toMonth);
		returningMonthSelect.selectByValue(returningMonth);
		log.info("Arrving month : "+returningMonth);
		
		Select retruningDaySelect = new Select(toDay);
		retruningDaySelect.selectByValue(returningDay);
		log.info("Arrving day : "+returningDay);
		
		if(serviceClass.equalsIgnoreCase("Economy")) {
			
			economyClass.click();
			log.info("Economy class is selected");
			
		}else if (serviceClass.equalsIgnoreCase("First")) {
			
			firstClass.click();
			log.info("First class is selected");
			
		}else if(serviceClass.equalsIgnoreCase("Business")) {
			
			bussinessClass.click();
			log.info("Bussiness class is selected");
			
		}
		
		Select airlineSelect = new Select(airline);
		airlineSelect.selectByVisibleText(airlinePrefernce);
		log.info("Airline Prefernce is "+airlinePrefernce);
		
		continueButton.click();
		log.info("Continue Button is Clicked");
	}
	
}
