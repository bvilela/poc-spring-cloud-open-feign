package com.bruno.pocopenfeign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.pocopenfeign.dto.ViaCepDTO;
import com.bruno.pocopenfeign.exception.ClientException;
import com.bruno.pocopenfeign.service.ViaCepService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ViaCepController {
	
	private ViaCepService service;
	
	@Autowired
	public ViaCepController(ViaCepService service) {
		this.service = service;		
	}

	@GetMapping("/busca-cep/{cep}")
	@ResponseStatus( value = HttpStatus.OK)
	public ViaCepDTO buscaCep(@PathVariable String cep) throws ClientException {
		
		String msgLog = "ViaCepController - buscaCep";
		log.info("{} - chamando Service", msgLog);
		var dto = service.buscaCep(cep);
		log.info("{} - Service respondeu com sucesso", msgLog);
		
		return dto;
	}
	
}
