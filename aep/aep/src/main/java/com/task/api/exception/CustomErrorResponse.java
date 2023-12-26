package com.task.api.exception;

public class CustomErrorResponse {

	private String message;
	
	

	public CustomErrorResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
