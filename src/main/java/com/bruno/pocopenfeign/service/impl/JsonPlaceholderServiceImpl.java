package com.bruno.pocopenfeign.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.pocopenfeign.client.JsonPlaceholderClient;
import com.bruno.pocopenfeign.dto.JsonPlaceholderRequestDTO;
import com.bruno.pocopenfeign.dto.JsonPlaceholderResponseDTO;
import com.bruno.pocopenfeign.exception.ClientException;
import com.bruno.pocopenfeign.service.JsonPlaceholderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JsonPlaceholderServiceImpl implements JsonPlaceholderService {
	
	private JsonPlaceholderClient client;
	
	@Autowired
	public JsonPlaceholderServiceImpl(JsonPlaceholderClient client) {
		this.client = client;
	}

	@Override
	public JsonPlaceholderResponseDTO post(JsonPlaceholderRequestDTO requestDto) throws ClientException {
		String msgLog = "JsonPlaceholderServiceImpl - post";
		
		try {			
			log.info("{} - chamando Client", msgLog);
			var dto = client.post(requestDto);
			log.info("{} - Client respondeu com sucesso", msgLog);
			log.info("{} - Retorno Client: {}", msgLog, dto.toString());
			
			return dto;
		}
		catch (Exception e) {
			throw new ClientException(e.getMessage());
		}
	}

}
