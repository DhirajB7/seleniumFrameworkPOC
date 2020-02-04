package seleniumRelated;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import propertiesRelated.PropertiesOperations;

public class SeleniumOperations extends PropertiesOperations {

	
	WebDriver driver;

	public WebDriver getDriver() {
		String browserName = loadProperties().getProperty("browser");
		if (browserName.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", loadProperties().getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", loadProperties().getProperty("geckoDriverPath"));
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("EDGE")) {
			System.setProperty("webdriver.edge.driver", loadProperties().getProperty("microsoftWebDriverPath"));
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(
				Integer.valueOf(loadProperties().getProperty("implicitTimeOutInSecond")), TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(
				Integer.valueOf(loadProperties().getProperty("pageLoadTimeOutInSecond")), TimeUnit.SECONDS);

		return driver;
	}

}
