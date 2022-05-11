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

import com.bruno.pocopenfeign.builders.ViaCepResponseDtoBuilder;
import com.bruno.pocopenfeign.client.ViaCepClient;
import com.bruno.pocopenfeign.exception.ClientException;

class ViaCepServiceImplTest {

	@Mock
	private ViaCepClient client;

    @InjectMocks
    private ViaCepServiceImpl service;
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        service = new ViaCepServiceImpl(client);
    }
    
    @Test
    void shouldBuscarCEPSuccess() throws ClientException {
    	var dtoMock = ViaCepResponseDtoBuilder.withRandomData();
        when(client.buscarCep(any(String.class), any(String.class))).thenReturn(dtoMock);
        var dto = service.buscarCep("123456");
        assertEquals(dtoMock, dto);
    }
    
    @Test
    void shouldBuscarCEPException() throws ClientException {
        when(client.buscarCep(any(String.class), any(String.class))).thenThrow(new RuntimeException("test"));
        var ex = assertThrows(ClientException.class, () -> service.buscarCep("123456"));
        assertEquals("test", ex.getMessage());
    }
}
