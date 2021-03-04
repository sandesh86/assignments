package com.example.notification.service;

import com.example.notification.dto.RequestDTO;

public interface Channel {

	boolean validateRequest(RequestDTO request) throws IllegalArgumentException ;
	
	void sendMessage(RequestDTO request);
}
