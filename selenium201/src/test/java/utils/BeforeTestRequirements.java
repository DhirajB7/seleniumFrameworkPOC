package utils;

import org.testng.annotations.BeforeSuite;

import CustomeOutputRelated.OutputOperations;
import seleniumRelated.SeleniumOperations;

public class BeforeTestRequirements extends SeleniumOperations {

	
	@BeforeSuite
	public void createOutputFile() {
		OutputOperations.createTextFile();
		OutputOperations.writeToHTMLFile("<html>\r\n" + 
				"<head>\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"body {background-color:C7E9F3}\r\n" + 
				"#testcase {box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);transition: 0.3s;background-color:FFFFFF}\r\n" + 
				"#testcase:hover {box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);}\r\n" + 
				"#container {padding: 2px 16px;}\r\n" + 
				"tr,td {border:1px solid #009;padding:.25em .5em;font-size:25px;font-family:Arial, Helvetica, sans-serif}\r\n" + 
				"#pass {color:006400}\r\n" + 
				"#fail {color:DC143C}\r\n" + 
				"#skip {color:BDB76B}\r\n" + 
				"#testcase {color:000000}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<h1  align = 'center'>SELENIUM 201 TEST RESULT</h1>");
	}
	
}
