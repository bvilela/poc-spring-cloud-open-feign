package com.bruno.pocopenfeign.exception.errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {

	private HttpStatus status;
	
	private String message;
	
	@JsonInclude(Include.NON_EMPTY)
	private List<String> errors = new ArrayList<>();

	public ApiError(HttpStatus status, String message, final List<String> errors) {
		this.setStatus(status);
		this.setMessage(message);
		this.getErrors().addAll(errors);
	}
	
}
