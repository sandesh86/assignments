package com.example.notification.utils;

import java.util.concurrent.BlockingQueue;

import com.example.notification.dto.RequestDTO;
import com.example.notification.service.Channel;

public class Consumer implements Runnable {

	BlockingQueue<RequestDTO> queue;
	private Channel channel;

	private volatile boolean run = true;

	public Consumer(BlockingQueue<RequestDTO> queue, Channel channel) {
		this.queue = queue;
		this.channel = channel;
	}

	@Override
	public void run() {
		while (run) {
			RequestDTO request;
			try {
				request = queue.take();
				channel.validateRequest(request);
				channel.sendMessage(request);
			} catch (InterruptedException | IllegalArgumentException e) {
				//Error Handling
				e.printStackTrace();
			}
			
		}
	}

	public void destroy() {
		run = false;
	}
}
