package com.example.notification;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.notification.controller.NotificationController;
import com.example.notification.dto.RequestDTO;
import com.example.notification.service.NotificationServiceIntf;

@SpringBootTest
class NotificationApplicationTests {

	@InjectMocks
	private NotificationController controller;
	
	@Mock
	private NotificationServiceIntf noticationService;
	
	@Test
	void testController() {
		RequestDTO request = new RequestDTO();
		controller.sendNotication(request);
		Mockito.verify(noticationService, Mockito.atLeastOnce()).sendNotification(request);
	}

}
