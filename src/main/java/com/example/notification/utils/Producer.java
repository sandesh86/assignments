package com.example.notification.utils;

import java.util.concurrent.BlockingQueue;

import com.example.notification.dto.RequestDTO;

public class Producer implements Runnable {

	BlockingQueue<RequestDTO> queue;
	RequestDTO request;

	public Producer(BlockingQueue<RequestDTO> queue, RequestDTO request) {
		this.queue = queue;
		this.request = request;
	}

	@Override
	public void run() {
		try {
			queue.put(request);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
