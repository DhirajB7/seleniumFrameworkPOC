package pageObjects;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumRelated.SeleniumOperations;

public class PaymentPage extends SeleniumOperations {
	
	Logger log = LogManager.getLogger(PaymentPage.class.getName());

	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "((//tr)[24]/td/b/font)[1]")
	WebElement getOneWaySourceDesitinationDetails;
	
	@FindBy (xpath = "((//tr)[24]/td/b/font)[2]")
	WebElement getOneWayDateDetails;
	
	@FindBy (xpath = "(//tr)[26]/td[3]/font")
	WebElement getOneWayFlightPriceDetails;
	
	@FindBy(xpath = "(//tr)[31]/td[2]/font")
	WebElement getTaxDetails;
	
	@FindBy(xpath = "(//tr)[30]/td[2]/font")
	WebElement getPasengerCount;
	
	@FindBy (xpath = "((//tr)[27]/td/b/font)[1]")
	WebElement getRoundWaySourceDesitinationDetails;
	
	@FindBy (xpath = "((//tr)[27]/td/b/font)[2]")
	WebElement getRoundWayDateDetails;
	
	@FindBy (xpath = "(//tr)[29]/td[3]/font")
	WebElement getRoundWayFlightPriceDetails;
	
	@FindBy(xpath = "(//tr)[32]/td[2]/font/b")
	WebElement getTotalPrice;
	
	@FindBy(xpath = "//input[@name='passFirst0']")
	WebElement firstName1;
	
	@FindBy(xpath = "//input[@name='passLast0']")
	WebElement lastName1;
	
	@FindBy(xpath = "//input[@name='passFirst1']")
	WebElement firstName2;
	
	@FindBy(xpath = "//input[@name='passLast1']")
	WebElement lastName2;
	
	@FindBy(xpath = "//input[@name='passFirst2']")
	WebElement firstName3;
	
	@FindBy(xpath = "//input[@name='passLast2']")
	WebElement lastName3;
	
	@FindBy(xpath = "//select[@name='creditCard']")
	WebElement creditCard;
	
	@FindBy(xpath = "//input[@name='creditnumber']")
	WebElement creditNumber;
	
	@FindBy(xpath = "//input[@name='cc_frst_name']")
	WebElement ccFirstName;
	
	@FindBy(xpath = "//input[@name='cc_mid_name']")
	WebElement ccMidName;
	
	@FindBy(xpath = "//input[@name='cc_last_name']")
	WebElement ccLastName;
	
	@FindBy(xpath = "//input[@name='billAddress1']")
	WebElement billAddress1;
	
	@FindBy(xpath = "//input[@name='billAddress2']")
	WebElement billAddress2;
	
	@FindBy(xpath = "//input[@name='billCity']")
	WebElement billCity;
	
	@FindBy(xpath = "//input[@name='billState']")
	WebElement billState;
	
	@FindBy(xpath = "//input[@name='billZip']")
	WebElement billZip;
	
	@FindBy(xpath = "//select[@name='billCountry']")
	WebElement billCountry;
	
	@FindBy(xpath = "(//input[@name='ticketLess'])[2]")
	WebElement deleveryAddressCheckBox;
	
	@FindBy(xpath = "//input[@name='buyFlights']")
	WebElement secrurePurchase;
	
	@Test
	public void pamentPageVerifyPaymentPage() {
		Assert.assertEquals(driver.getCurrentUrl(), loadTestDataProperties().getProperty("paymentPageUrl"));
		log.info("Paymet page is verified ");
	}
	
	@Test
	public void paymentPageVerifySourceDestinationDateNumberOFPassengerPriceOneWay() {
		
		Assert.assertTrue(getOneWaySourceDesitinationDetails.getText().trim().equals(loadTestDataProperties().getProperty("departingFrom")+" to "+loadTestDataProperties().getProperty("arrivingTo")));
		log.info("Source and destination is verified");
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		Assert.assertTrue(getOneWayDateDetails.getText().trim().equals(loadTestDataProperties().getProperty("departingMonth")+"/"+loadTestDataProperties().getProperty("departingDate")+"/"+String.valueOf(year)));
		log.info("Date is verified");
		
		Assert.assertTrue(getPasengerCount.getText().trim().equals(loadTestDataProperties().getProperty("passengersCount")));
		log.info("Passengers Count verified");
		
		int priceForAllPassengers = Integer.valueOf(getOneWayFlightPriceDetails.getText().trim())*Integer.valueOf(loadTestDataProperties().getProperty("passengersCount"));
		int tax = Integer.valueOf(getTaxDetails.getText().replace("$", " ").trim());
		int totalPrice = Integer.valueOf(getTotalPrice.getText().replace("$", " ").trim());
		
		Assert.assertTrue(totalPrice > priceForAllPassengers+tax);
		log.info("Price is verified");
	}
	
	@Test
	public void paymentPageVerifySourceDestinationDateNumberOFPassengerPriceRoundWay() {
		
		Assert.assertTrue(getOneWaySourceDesitinationDetails.getText().trim().equals(loadTestDataProperties().getProperty("departingFrom")+" to "+loadTestDataProperties().getProperty("arrivingTo")));
		log.info("one side : Source and destination is verified");
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		Assert.assertTrue(getOneWayDateDetails.getText().trim().equals(loadTestDataProperties().getProperty("departingMonth")+"/"+loadTestDataProperties().getProperty("departingDate")+"/"+String.valueOf(year)));
		log.info("one side : Date is verified");
		
		Assert.assertTrue(getRoundWaySourceDesitinationDetails.getText().trim().equals(loadTestDataProperties().getProperty("arrivingTo")+" to "+loadTestDataProperties().getProperty("departingFrom")));
		log.info("round side : Source and destination is verified");
		
		Assert.assertTrue(getRoundWayDateDetails.getText().trim().equals(loadTestDataProperties().getProperty("returningMonth")+"/"+loadTestDataProperties().getProperty("returningDay")+"/"+String.valueOf(year)));
		log.info("round side : Date is verified");
		
		Assert.assertTrue(getPasengerCount.getText().trim().equals(loadTestDataProperties().getProperty("passengersCount")));
		log.info("Passengers Count verified");
		
		int priceForAllPassengers = (Integer.valueOf(getOneWayFlightPriceDetails.getText().trim())+Integer.valueOf(getRoundWayFlightPriceDetails.getText().trim()))*Integer.valueOf(loadTestDataProperties().getProperty("passengersCount"));
		int tax = Integer.valueOf(getTaxDetails.getText().replace("$", " ").trim());
		int totalPrice = Integer.valueOf(getTotalPrice.getText().replace("$", " ").trim());
		
		Assert.assertTrue(totalPrice == priceForAllPassengers+tax);
		log.info("Price is verified");
	}
	
	@Test
	public void paymentPageFillPassengerDetailCardDetailAndPay() {
		
		int passengerCount = Integer.valueOf(loadTestDataProperties().getProperty("passengersCount"));
		
		if(passengerCount==1) {
			log.info("Passenger Count is 1");
			
			firstName1.sendKeys(loadTestDataProperties().getProperty("firstName1"));
			lastName1.sendKeys(loadTestDataProperties().getProperty("lastName1"));
			
		}else if(passengerCount==2) {
			log.info("Passenger Count is 2");
			
			firstName1.sendKeys(loadTestDataProperties().getProperty("firstName1"));
			lastName1.sendKeys(loadTestDataProperties().getProperty("lastName1"));
			
			firstName2.sendKeys(loadTestDataProperties().getProperty("firstName2"));
			lastName2.sendKeys(loadTestDataProperties().getProperty("lastName2"));
			
		}else if(passengerCount==3) {
			log.info("Passenger Count is 3");
			
			firstName1.sendKeys(loadTestDataProperties().getProperty("firstName1"));
			lastName1.sendKeys(loadTestDataProperties().getProperty("lastName1"));
			
			firstName2.sendKeys(loadTestDataProperties().getProperty("firstName2"));
			lastName2.sendKeys(loadTestDataProperties().getProperty("lastName2"));
			
			firstName3.sendKeys(loadTestDataProperties().getProperty("firstName3"));
			lastName3.sendKeys(loadTestDataProperties().getProperty("lastName3"));
		}
		
		Select cardSelect = new Select(creditCard);
		cardSelect.selectByVisibleText(loadTestDataProperties().getProperty("cardType"));
		log.info("Credit card selected");
		
		creditNumber.sendKeys(loadTestDataProperties().getProperty("cardNumber"));
		log.info("Card number entered");
		
		ccFirstName.sendKeys(loadTestDataProperties().getProperty("firstNameCard"));
		ccMidName.sendKeys(loadTestDataProperties().getProperty("middleNameCard"));
		ccLastName.sendKeys(loadTestDataProperties().getProperty("lastNameCard"));
		
		log.info("card details filled");
		
		billAddress1.clear();
		billAddress1.sendKeys(loadTestDataProperties().getProperty("addressLine1"));
		billAddress2.sendKeys(loadTestDataProperties().getProperty("addressLine2"));
		billCity.clear();
		billCity.sendKeys(loadTestDataProperties().getProperty("cityName"));
		billState.clear();
		billState.sendKeys(loadTestDataProperties().getProperty("stateName"));
		billZip.clear();
		billZip.sendKeys(loadTestDataProperties().getProperty("pinCode"));
		
		Select billCountrySelect = new Select(billCountry);
		billCountrySelect.selectByVisibleText(loadTestDataProperties().getProperty("countryName"));
		
		log.info("card details filled");
		
		deleveryAddressCheckBox.click();
		log.info("deliver to same address is checked");
		
		secrurePurchase.click();
		log.info("Secrure Purchase button is clicked");
		
	}
	
	
	
}
