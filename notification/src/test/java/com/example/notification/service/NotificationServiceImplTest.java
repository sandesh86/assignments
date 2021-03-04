package com.example.notification.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ActiveProfiles;

import com.example.notification.dto.RequestDTO;

@ActiveProfiles("test")
@SpringBootTest
class NotificationServiceImplTest {

	@Autowired
	private NotificationServiceIntf notificationService;
	
	@InjectMocks
	private EmailChannel emailChannel;
	
	@Autowired
	private SMSChannel smsChannel;
	
	@Mock
	private JavaMailSender mailSender;
	
	@Test
	void testSendNotification() {
		RequestDTO request = new RequestDTO();
		request.setChannel("test");
		request.setFrom("sandesh@abc.com");
		request.setTo("new@abc.com");
		request.setSubject("Test Mail");
		request.setMessage("Hello World!");
		String response = notificationService.sendNotification(request);
		Assertions.assertEquals("fail", response);		
	}
	
	@Test
	void testSendNotificationSMS() {
		RequestDTO request = new RequestDTO();
		request.setChannel("sms");
		request.setFrom("sandesh@abc.com");
		request.setTo("new@abc.com");
		request.setSubject("Test Mail");
		request.setMessage("Hello World!");
		String response = notificationService.sendNotification(request);
		Assertions.assertEquals("success", response);
		Assertions.assertTrue(smsChannel.getSmsCount() > 0);
	}

	@Test
	void testSendNotificationEmail() {
		RequestDTO request = new RequestDTO();
		request.setChannel("email");
		request.setFrom("sandesh@abc.com");
		request.setTo("new@abc.com");
		request.setSubject("Test Mail");
		request.setMessage("Hello World!");
		String response = notificationService.sendNotification(request);
		Assertions.assertEquals("success", response);
	}
}
