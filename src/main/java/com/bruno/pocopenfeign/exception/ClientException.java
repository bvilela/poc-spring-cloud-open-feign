package com.bruno.pocopenfeign.exception;

public class ClientException extends Exception {

	private static final long serialVersionUID = 6148766310507726598L;
	
	public ClientException() {
		super();
	}
	
	public ClientException(String message) {
		super(message);
	}

}
