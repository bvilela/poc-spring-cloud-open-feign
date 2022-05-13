package com.bruno.pocopenfeign.config.feign;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.bruno.pocopenfeign.builders.FeignRequestBuilder;
import com.bruno.pocopenfeign.exception.ClientException;

import feign.Response;

class ViaCepClientErrorDecoderTest {
	
	private static final String DEFAULT_ERROR_MESSAGE = "Client Retornou Erro.";

	@Mock
	private ViaCepClientErrorDecoder decoder;
	
	private Response responseBadRequest;
	
	@BeforeEach
	void setup() {
		decoder = new ViaCepClientErrorDecoder();
		var request = FeignRequestBuilder.create().withHttpGet().build();
		responseBadRequest = Response.builder().status(400).body("", StandardCharsets.UTF_8).request(request).build();
	}
	
	@Test
	void shouldClientExceptionBadRequest() {		
		baseClientException(responseBadRequest);
	}

	private void baseClientException(Response response) {
		var exception = (ClientException) decoder.decode("", response);
		assertEquals(DEFAULT_ERROR_MESSAGE, exception.getMessage());
	}
}
