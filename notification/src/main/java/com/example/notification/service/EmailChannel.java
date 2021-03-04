package com.example.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.notification.dto.RequestDTO;

@Component("emailChannel")
public class EmailChannel implements Channel {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public boolean validateRequest(RequestDTO request) throws IllegalArgumentException {
		return true;
	}
	
	@Override
	public void sendMessage(RequestDTO request) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setSubject(request.getSubject());
		message.setFrom(request.getFrom());
		message.setTo(request.getTo());
		message.setText(request.getMessage());
		mailSender.send(message);
		System.out.println("Email sent successfully");
	}

}
