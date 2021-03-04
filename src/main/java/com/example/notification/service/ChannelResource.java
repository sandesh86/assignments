package com.example.notification.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

import com.example.notification.dto.RequestDTO;
import com.example.notification.utils.Consumer;
import com.example.notification.utils.Producer;

public class ChannelResource {

	private BlockingQueue<RequestDTO> requestQueue = new LinkedBlockingDeque<>();
	
	private ExecutorService threadPool = Executors.newFixedThreadPool(20);
	
	public ChannelResource(Channel channel) {
		for (int i = 0; i < 5; i++) {
			threadPool.submit(new Consumer(requestQueue, channel));
		}	
	}
	
	public BlockingQueue<RequestDTO> getRequestQueue() {
		return requestQueue;
	}

	public ExecutorService getThreadPool() {
		return threadPool;
	}
	
	public void submitTask(RequestDTO request) {
		threadPool.submit(new Producer(requestQueue, request));
	}
	
}
