package com.mail.mailserviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.mail.mailservice.MailService;
import com.mail.request.MailRequest;
import com.mail.response.SuccessResponse;

@Service
public class MailServiceImpl implements MailService {


	@Autowired
	private JavaMailSenderImpl javaMailSender;
	
	@Autowired
	private Environment environment;

	@Override
	public ResponseEntity<Object> sendMail(MailRequest mailRequest) {

		if (mailRequest.getNotificationType().equalsIgnoreCase("mail")) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(environment.getProperty("spring.mail.username"));
			mailMessage.setTo(mailRequest.getMail().getToMail());
			mailMessage.setText("your OTP :" + mailRequest.getMail().getOtp());
			mailMessage.setSubject("OTP Verification");

			javaMailSender.send(mailMessage);
		}
		SuccessResponse success = new SuccessResponse();
		success.setMessage("OTP sent successfully");
		success.setStatusCode("200");
		return new ResponseEntity<Object>(success, HttpStatus.OK);
	}
}
