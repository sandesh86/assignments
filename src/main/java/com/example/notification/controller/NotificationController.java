package com.example.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.notification.dto.RequestDTO;
import com.example.notification.service.NotificationServiceIntf;

@RestController
public class NotificationController {

	@Autowired
	NotificationServiceIntf noticationService;
	
	@PostMapping("/message")
	public ResponseEntity<String> sendNotication(@RequestBody RequestDTO request) {
		noticationService.sendNotification(request);
		return new ResponseEntity<>("Sending Notification", HttpStatus.OK);
	}
}
