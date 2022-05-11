package com.bruno.pocopenfeign.config.feign;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.bruno.pocopenfeign.builders.FeignRequestBuilder;

import feign.Logger.Level;

class FeignCustomRequestLoggingTest {

	@Mock
	private FeignCustomRequestLogging customLogging;
	
	@BeforeEach
	public void setup() {
		customLogging = new FeignCustomRequestLogging();
	}
	
	@Test
	void shouldFeignCustomRequestLogging() {
		var headers = new HashMap<String, Collection<String>>();
		headers.put("header1", List.of("valorHeader1"));
		headers.put("header2", List.of("valorHeader2"));
		headers.put("token", List.of("valorToken"));
		var request = FeignRequestBuilder.create().withHttpGetAndHeaders(headers).build();
		
		customLogging.logRequest("teste(", Level.FULL, request);
		var stringLog = customLogging.format("teste1(", "teste2", ""); 
		assertEquals("[teste1] teste2", stringLog);
	}
	
}
