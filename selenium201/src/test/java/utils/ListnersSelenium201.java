package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import CustomeOutputRelated.OutputOperations;
import seleniumRelated.SeleniumOperations;

public class ListnersSelenium201 implements ITestListener {
	
	Logger log = LogManager.getLogger(ListnersSelenium201.class.getName());

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info(result.getName() +" IS STARTING");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info(result.getName() +" IS PASS");
		OutputOperations.writeToFile("PASS  ",result.getName());
		OutputOperations.writeToHTMLFile("<li><p id = 'pass'>"+result.getName()+"</p></li>");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		SeleniumOperations seleniumOperations = new SeleniumOperations();
		seleniumOperations.screenShotOnFailure(result.getName());
		log.error(result.getThrowable().toString());
		log.error(result.getName() +" FAILED, CHECK SCREENSHOT BY NAME "+result.getName()+".PNG");
		OutputOperations.writeToFile("FAIL  ",result.getName());
		OutputOperations.writeToHTMLFile("<li><p id = 'fail'>"+result.getName()+"</p></li>");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		log.warn(result.getName() +" HAS BEEN SKIPPED");
		OutputOperations.writeToHTMLFile("<li><p id = 'skip'>"+result.getName()+"</p></li>");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		log.info(context.getName()+" IS STARTED");
		OutputOperations.writeToFile("START ", context.getName());
		OutputOperations.writeToHTMLFile("<div id = 'testcase'>\r\n" + 
				"<div id = 'container'>\r\n" + 
				"<h3>\r\n" + 
				"<u>"+context.getName()+"</u>\r\n" + 
				"</h3>"+
				"<ol>");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		log.info(context.getName()+" IS FINISHED");
		OutputOperations.writeToFile("END   ", context.getName());
		OutputOperations.writeToHTMLFile("</ol>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"<br>");
	}

}
