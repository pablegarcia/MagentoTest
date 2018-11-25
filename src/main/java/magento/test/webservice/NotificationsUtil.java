package magento.test.webservice;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class NotificationsUtil {

	public static void SendMail(String content) {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "localhost");

		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress("pablegarcia@gmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("pablegarcia@gmail.com"));
			message.setSubject("Magento Test");
			message.setText(content);

			// Send message
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
