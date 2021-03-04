package com.example.notification.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.example.notification.dto.RequestDTO;

@Component("smsChannel")
public class SMSChannel implements Channel {

	private AtomicInteger smsCount = new AtomicInteger();
	
	@Override
	public boolean validateRequest(RequestDTO request) throws IllegalArgumentException {
		return true;
	}

	@Override
	public void sendMessage(RequestDTO request) {
		smsCount.incrementAndGet();
		System.out.println("SMS Sent Successfully");
	}
	
	public int getSmsCount() {
		return smsCount.intValue();
	}

}
