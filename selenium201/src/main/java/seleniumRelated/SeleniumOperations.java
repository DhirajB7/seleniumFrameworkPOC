package seleniumRelated;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import propertiesRelated.PropertiesOperations;

public class SeleniumOperations extends PropertiesOperations {

	static Logger log = LogManager.getLogger(SeleniumOperations.class.getName());

	protected static WebDriver driver = getDriver();

	/**
	 * Selects Driver based on input in properties file
	 * 
	 * @return required driver
	 */
	public static WebDriver getDriver() {
		String browserName = loadProperties().getProperty("browser");
		log.info("method name:getDriver" + "browser name " + browserName);
		if (browserName.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", loadProperties().getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", loadProperties().getProperty("geckoDriverPath"));
			driver = new FirefoxDriver();
		}
		log.info("driver is set");
		driver.manage().window().maximize();
		log.info("maximizing the browser");
		driver.manage().timeouts().implicitlyWait(
				Integer.valueOf(loadProperties().getProperty("implicitTimeOutInSecond")), TimeUnit.SECONDS);
		log.info("timeout in seconds is :" + loadProperties().getProperty("implicitTimeOutInSecond"));
		driver.manage().timeouts().pageLoadTimeout(
				Integer.valueOf(loadProperties().getProperty("pageLoadTimeOutInSecond")), TimeUnit.SECONDS);
		log.info("timeout in seconds is :" + loadProperties().getProperty("pageLoadTimeOutInSecond"));
		return driver;
	}

	/**
	 * takes screen shot for every failure test case
	 * 
	 * @param methodName
	 */
	public void screenShotOnFailure(String methodName) {
		try {
			File srcImage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcImage,
					new File(loadProperties().getProperty("screenShootPath") + methodName + ".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
