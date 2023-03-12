package com.manin.in28minutes.rest.webservice.socialrestwebservice;

import java.time.LocalDateTime;

public class ErrorDetail {
	public ErrorDetail(LocalDateTime timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	private LocalDateTime timestamp;
	private String message;
	private String details;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
}
