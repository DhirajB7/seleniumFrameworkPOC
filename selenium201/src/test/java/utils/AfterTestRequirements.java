package utils;

import org.testng.annotations.AfterSuite;

import CustomeOutputRelated.EmailRelated;
import CustomeOutputRelated.OutputOperations;
import seleniumRelated.SeleniumOperations;

public class AfterTestRequirements extends SeleniumOperations {

	

	/**
	 * Close all browsers
	 */
	@AfterSuite
	public void closeAllBrowser() {
		driver.quit();
		OutputOperations.writeToHTMLFile("</body>\r\n" + "</html>");
		OutputOperations.closeFiles();
		EmailRelated.sendHtmlReportAsEmail();
	}
	
	
}
