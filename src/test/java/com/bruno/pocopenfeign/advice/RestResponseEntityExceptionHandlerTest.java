package com.bruno.pocopenfeign.advice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bruno.pocopenfeign.exception.ClientException;
import com.bruno.pocopenfeign.exception.errors.ApiError;

class RestResponseEntityExceptionHandlerTest {
	
	private static final String DEFAULT_MESSAGE_ERROR_500 = "An error has occurred. Please try again later.";
	
	private RestResponseEntityExceptionHandler restResponseEntityExceptionHandler;
	
	@BeforeEach
	public void setUp() throws Exception {
		restResponseEntityExceptionHandler = new RestResponseEntityExceptionHandler();
	}
	
	
	@Test
	void errorHandleClientException() {
		ResponseEntity<Object> response = restResponseEntityExceptionHandler.handleClientException(new ClientException());
		ApiError convertResponse = convertResponse(response);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, convertResponse.getStatus());
		assertEquals(DEFAULT_MESSAGE_ERROR_500, convertResponse.getMessage());
		assertEquals(List.of("An error has occurred in Client"), convertResponse.getErrors());
	}
	
	@Test
	void errorHandleClientExceptionWithListErrors() {
		ResponseEntity<Object> response = restResponseEntityExceptionHandler.handleClientException(new ClientException("error message"));
		ApiError convertResponse = convertResponse(response);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, convertResponse.getStatus());
		assertEquals(DEFAULT_MESSAGE_ERROR_500, convertResponse.getMessage());
		assertEquals(List.of("error message"), convertResponse.getErrors());
	}
	
	private ApiError convertResponse(ResponseEntity<?> response) {
		return (ApiError) response.getBody();
	}

}
