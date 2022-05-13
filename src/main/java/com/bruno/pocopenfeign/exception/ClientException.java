package com.bruno.pocopenfeign.exception;

public class ClientException extends RuntimeException {

	private static final long serialVersionUID = 6148766310507726598L;
	
	private static final String DEFAULT_MESSAGE = "An error has occurred in Client";
	
	public ClientException() {
		super(DEFAULT_MESSAGE);
	}
	
	public ClientException(String message) {
		super(message);
	}

}
