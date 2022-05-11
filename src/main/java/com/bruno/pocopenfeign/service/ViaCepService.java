package com.bruno.pocopenfeign.service;

import com.bruno.pocopenfeign.dto.ViaCepResponseDTO;
import com.bruno.pocopenfeign.exception.ClientException;

public interface ViaCepService {

	public ViaCepResponseDTO buscarCep(String cep) throws ClientException;
	
}
