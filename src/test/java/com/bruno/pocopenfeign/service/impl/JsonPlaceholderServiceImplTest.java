package com.bruno.pocopenfeign.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bruno.pocopenfeign.builders.JsonPlaceholderRequestDtoBuilder;
import com.bruno.pocopenfeign.builders.JsonPlaceholderResponseDtoBuilder;
import com.bruno.pocopenfeign.client.JsonPlaceholderClient;
import com.bruno.pocopenfeign.dto.JsonPlaceholderRequestDTO;
import com.bruno.pocopenfeign.exception.ClientException;

class JsonPlaceholderServiceImplTest {

	@Mock
	private JsonPlaceholderClient client;

    @InjectMocks
    private JsonPlaceholderServiceImpl service;
    
    private JsonPlaceholderRequestDTO dtoResquest;
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        service = new JsonPlaceholderServiceImpl(client);
        dtoResquest = JsonPlaceholderRequestDtoBuilder.create().withRandomData().build();
    }
    
    @Test
    void shouldPostSuccess() throws ClientException {
    	var dtoResponse = JsonPlaceholderResponseDtoBuilder.withRandomData();
        when(client.post(any(JsonPlaceholderRequestDTO.class))).thenReturn(dtoResponse);
        var dto = service.post(dtoResquest);
        assertEquals(dtoResponse, dto);
    }
    
    @Test
    void shouldPostException() throws ClientException {
    	when(client.post(any(JsonPlaceholderRequestDTO.class))).thenThrow(new RuntimeException("test"));
        var ex = assertThrows(ClientException.class, () -> service.post(dtoResquest));
        assertEquals("test", ex.getMessage());
    }
}
