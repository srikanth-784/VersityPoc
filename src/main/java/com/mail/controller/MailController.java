package com.mail.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.exception.InvalidMailDetails;
import com.mail.mailservice.MailService;
import com.mail.request.MailRequest;
import com.mail.response.ErrorResponse;

@RestController
@RequestMapping("/mail")
public class MailController {
	
	@Autowired
	private MailService mailService;
	Logger logger = Logger.getLogger(MailController.class);

	ErrorResponse error = new ErrorResponse();
	
	@PostMapping("/sendMail")
	public ResponseEntity<Object> sendMail(@RequestBody MailRequest mailRequest) {
		logger.debug("Incoming request : " + mailRequest);
		try {

			if (mailRequest == null || mailRequest.getNotificationType() == null
					|| mailRequest.getNotificationType().isEmpty()) {
				logger.error("Invalid request");
				error.setStatusCode("422");
				error.setMessage("Invalid Request");
				throw new InvalidMailDetails("Mail details should not be empty or null");
			}

			return mailService.sendMail(mailRequest);

		} catch (InvalidMailDetails e) {

			logger.error("Exception caught : " + e.getMessage());
			error.setStatusCode("409");
			error.setMessage("Exception caught!");
			error.setStatusMessage(e.getMessage());
		}
		return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
		
	}

}
