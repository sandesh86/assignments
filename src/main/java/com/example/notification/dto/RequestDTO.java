package com.example.notification.dto;

public class RequestDTO {

	private String subject;
	private String from;
	private String to;
	private String message;
	private String channel;

	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "RequestDTO [subject=" + subject + ", from=" + from + ", to=" + to + ", message=" + message
				+ ", channel=" + channel + "]";
	}
}
