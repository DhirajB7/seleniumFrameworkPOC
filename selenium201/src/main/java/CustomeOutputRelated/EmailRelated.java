package CustomeOutputRelated;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class EmailRelated extends OutputOperations{
	
	static Logger log = LogManager.getLogger(EmailRelated.class.getName());
	
	public static void sendHtmlReportAsEmail(){

		log.info("mail activity started");
		
		try {
				String	path = System.getProperty("user.dir")+loadProperties().getProperty("outputFolderPathName")+"//"+writerHtmlName;
				
				log.info("path is :"+path);
				
				EmailAttachment attachment = new EmailAttachment();
				attachment.setPath(path);
				attachment.setDisposition(EmailAttachment.ATTACHMENT);
				attachment.setDescription("Trial Attachment");
				attachment.setName("report attachment");

				

				// Create the email message

				

				MultiPartEmail email = new MultiPartEmail();
				email.setHostName(loadProperties().getProperty("mailHostName"));
				email.setSmtpPort(Integer.valueOf(loadProperties().getProperty("mailPort")));
				email.setAuthenticator(new DefaultAuthenticator(loadProperties().getProperty("fromMailUsername"), loadProperties().getProperty("fromMailPassword")));
				email.setFrom(loadProperties().getProperty("fromMailId"));
				email.addTo(loadProperties().getProperty("toMailId"));
				email.setSubject("The Report");
				email.setMsg("Here is the Report you wanted");

				

				// add the attachment
				email.attach(attachment);
				
				log.info("attachment attached");

				// send the email
				email.send();
				
				log.info("email sent");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
