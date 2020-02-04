package CustomeOutputRelated;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import propertiesRelated.PropertiesOperations;

public class OutputOperations extends PropertiesOperations{
	
	 static PrintWriter writer;
	 static PrintWriter writerHtml;
	 static String writerName;
	 static String writerHtmlName;
	 
	/**
	 * Simple get Date and time
	 * @return date and Time as String
	 */
	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return (dateFormat.format(date).toString());
	}
	
	
	/**
	 * Creates File 
	 * @return
	 * @throws Exception
	 */
	public static void createTextFile() {
		try {
			File file = new File(System.getProperty("user.dir")+loadProperties().getProperty("outputFolderPathName"));
			file.mkdir();
			writerName = getDateTime().toString().replace("/", "_").replace(":", "_")+".txt";
			writerHtmlName = getDateTime().toString().replace("/", "_").replace(":", "_")+" emailable report.html";
			writer =  new PrintWriter(new File(System.getProperty("user.dir")+loadProperties().getProperty("outputFolderPathName")+"//"+writerName));
			writerHtml =  new PrintWriter(new File(System.getProperty("user.dir")+loadProperties().getProperty("outputFolderPathName")+"//"+writerHtmlName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes to file
	 * @param status
	 * @param message
	 */
	public static void writeToFile(String status,String message) {
		if(status.trim().equalsIgnoreCase("END")) {
			writer.println(getDateTime()+" : "+status+" : "+message);
			writer.println(" ");
		}else {
			writer.println(getDateTime()+" : "+status+" : "+message);
		}
		writer.flush();
	}
	
	/**
	 * Writes to HTML file
	 * @param status
	 * @param message
	 */
	public static void writeToHTMLFile(String message) {
		if(message.contains("finalWriteToHtml")) {
			writerHtml.flush();
		}else {
			writerHtml.println(message);
			
			writerHtml.flush();
		}
		
	}
	/**
	 * closes text file
	 */
	public static void closeFiles() {
		writer.close();
		writerHtml.close();
	}
}
