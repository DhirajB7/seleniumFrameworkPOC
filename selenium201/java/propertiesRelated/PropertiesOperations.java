package propertiesRelated;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesOperations {

	String propertiesFilePath = System.getProperty("user.dir")
			+ "\\resources\\constantsParameters.properties";
	Properties propertiesRelated;

	public Properties loadProperties() {
		try {
			this.propertiesRelated = new Properties();
			FileInputStream fis = new FileInputStream(propertiesFilePath);
			propertiesRelated.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return propertiesRelated;

	}

}
