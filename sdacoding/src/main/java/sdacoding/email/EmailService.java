
package sdacoding2.email;

import com.sun.net.ssl.internal.ssl.Provider;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.security.Security;
import java.time.Instant;
import java.util.Date;
import java.util.Properties;

public class EmailService {
	
	private static void sendEmail() {
		
		Security.addProvider(new Provider());
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.host", "smtp.gmail.com");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.socketFactory.fallback", "false");
		prop.setProperty("mail.smtp.quitwait", "false");
		
		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("youremail", "yourpassword");
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			InternetAddress[] receiverAddresses = InternetAddress.parse("@gmail.com");
			
			message.setRecipients(Message.RecipientType.TO, receiverAddresses);
			message.setSubject("Test email");
			message.setSentDate(Date.from(Instant.now()));
			
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent("Appliance Result", "text/html");
			
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			attachmentBodyPart.attachFile(new File("candidati-acceptati.json"));
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			multipart.addBodyPart(attachmentBodyPart);
			
			message.setContent(multipart);
			
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Mail could not be sent.");
		}
	}
	
	public static void main(String[] args) {
		sendEmail();
	}
}
