package propertiesRelated;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesOperations {

	static String propertiesFilePath = System.getProperty("user.dir") + "\\resources\\constantsParameters.properties";
	static Properties propertiesRelated;
	
	static String dataPropertiesFilePath = System.getProperty("user.dir") + "\\testcase\\Z_last_testData.properties";
	static Properties dataPropertiesRelated;

	/**
	 * Loads Property File and returns same
	 * 
	 * @return propertiesRelated
	 */
	public static Properties loadProperties() {
		try {
			propertiesRelated = new Properties();
			FileInputStream fis = new FileInputStream(propertiesFilePath);
			propertiesRelated.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return propertiesRelated;

	}

	/**
	 * Loads TEST DATA from Property File and returns same
	 * 
	 * @return propertiesRelated
	 */
	public static Properties loadTestDataProperties() {
		try {
			dataPropertiesRelated = new Properties();
			FileInputStream fis = new FileInputStream(dataPropertiesFilePath);
			dataPropertiesRelated.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataPropertiesRelated;

	}
}
