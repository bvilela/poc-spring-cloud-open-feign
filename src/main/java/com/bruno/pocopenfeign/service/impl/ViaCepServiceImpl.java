package com.bruno.pocopenfeign.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.pocopenfeign.client.ViaCepClient;
import com.bruno.pocopenfeign.dto.ViaCepDTO;
import com.bruno.pocopenfeign.exception.ClientException;
import com.bruno.pocopenfeign.service.ViaCepService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ViaCepServiceImpl implements ViaCepService {
	
	private ViaCepClient client;
	
	@Autowired
	public ViaCepServiceImpl(ViaCepClient client) {
		this.client = client;
	}

	@Override
	public ViaCepDTO buscaCep(String cep) throws ClientException {
		
		try {
			String msgLog = "ViaCepServiceImpl - buscaCep";
			log.info("{} - chamando Client", msgLog);
			var dto = client.buscaCep(cep);
			log.info("{} - Client respondeu com sucesso", msgLog);
			log.info("{} - Retorno Client: {}", msgLog, dto.toString());
			
			return dto;
		}
		catch (Exception e) {
			throw new ClientException(e.getMessage());
		}
	}

}
