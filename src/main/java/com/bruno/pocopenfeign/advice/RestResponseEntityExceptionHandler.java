package com.bruno.pocopenfeign.advice;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bruno.pocopenfeign.exception.ClientException;
import com.bruno.pocopenfeign.exception.errors.ApiError;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final String DEFAULT_MESSAGE_ERROR_500 = "An error has occurred. Please try again later.";
	private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;
	
	protected ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return ResponseEntity.status(apiError.getStatus()).contentType(MediaType.APPLICATION_JSON).body(apiError);
	}
	
	@ExceptionHandler(ClientException.class)
	public ResponseEntity<Object> handleClientException(ClientException ex) {
		log.error(ExceptionUtils.getMessage(ex));
		return buildResponseEntity(new ApiError(DEFAULT_HTTP_STATUS, DEFAULT_MESSAGE_ERROR_500, List.of(ex.getMessage())));
	}

}
