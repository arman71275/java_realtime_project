
package com.registraion.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender javaMailSender;

	public boolean sendEmail(String fromEmail, String toEMail, String subject, String body) {
		boolean isSent = false;
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(fromEmail);
			mailMessage.setTo(toEMail);
			mailMessage.setSubject(subject);
			mailMessage.setText(body);
			
			javaMailSender.send(mailMessage);
			System.out.println("Email sent successfully!::" );
			//mailMessage.isSent = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
	}

}
