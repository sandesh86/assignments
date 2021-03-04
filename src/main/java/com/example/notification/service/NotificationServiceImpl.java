package com.example.notification.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.notification.dto.RequestDTO;
import com.example.notification.utils.ChannelFactory;

@Service
public class NotificationServiceImpl implements NotificationServiceIntf {
	
	private ConcurrentMap<String, ChannelResource> resource = new ConcurrentHashMap<>();
		
	@Autowired
	private ChannelFactory channelFactory;
	
	@Value("${channel.support}")
	private String channelSupports;

	@PostConstruct
	private void startConsumers() {
		String[] channels = channelSupports.split(",");
		for (String channel: channels) {
			resource.computeIfAbsent(channel, key -> new ChannelResource(channelFactory.getChannel(channel)));
		}
	}
	
	@Override
	public String sendNotification(RequestDTO request) {
		System.out.println("Input Request: " + request);
		if (resource.containsKey(request.getChannel())) {
			resource.get(request.getChannel()).submitTask(request);
		}
		else {
			System.out.println("Channel not available");
			return "fail";
		}		
		System.out.println("Message pushed successfully");
		return "success";
	}
	
	@PreDestroy
	private void destroy() {
		resource.forEach((k, v) -> {
			v.getThreadPool().shutdown();
		});
	}
}