package com.bruno.pocopenfeign.service;

import com.bruno.pocopenfeign.dto.ViaCepDTO;
import com.bruno.pocopenfeign.exception.ClientException;

public interface ViaCepService {

	public ViaCepDTO buscaCep(String cep) throws ClientException;
	
}
