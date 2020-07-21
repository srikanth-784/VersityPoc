package com.mail.mailservice;

import org.springframework.http.ResponseEntity;

import com.mail.request.MailRequest;

public interface MailService {

	public ResponseEntity<Object> sendMail(MailRequest mailRequest);
}
