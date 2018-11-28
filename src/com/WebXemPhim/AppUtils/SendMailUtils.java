package com.WebXemPhim.AppUtils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.WebXemPhim.Paramaters.paramaters;

public class SendMailUtils {
	static Properties p = new Properties();
	static {
		init();
	}
	public SendMailUtils() {
		// TODO Auto-generated constructor stub
	}
	static void init()
	{
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", 587);
		Session s = Session.getInstance(p,
				 new javax.mail.Authenticator() {
				 protected PasswordAuthentication getPasswordAuthentication() {
				   return new PasswordAuthentication(paramaters.accountMail, paramaters.pass);
				 }
				});
		Message msg = new MimeMessage(s);
		/*msg.setFrom(new InternetAddress(from));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		msg.setSubject(subject);
		msg.setText(body);*/
	}
	

}
