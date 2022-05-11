package com.bruno.pocopenfeign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.pocopenfeign.dto.JsonPlaceholderRequestDTO;
import com.bruno.pocopenfeign.dto.JsonPlaceholderResponseDTO;
import com.bruno.pocopenfeign.dto.ViaCepResponseDTO;
import com.bruno.pocopenfeign.exception.ClientException;
import com.bruno.pocopenfeign.service.JsonPlaceholderService;
import com.bruno.pocopenfeign.service.ViaCepService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ExampleController {
	
	private ViaCepService viaCepService;
	
	private JsonPlaceholderService jsonPlaceholderService;
	
	@Autowired
	public ExampleController(ViaCepService viaCepService, JsonPlaceholderService jsonPlaceholderService) {
		this.viaCepService = viaCepService;
		this.jsonPlaceholderService = jsonPlaceholderService;
	}

    @ApiOperation(value = "Rota para obter dados sobre um determinado CEP, utilizando a API ViaCEP.")
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successo."),
    })
	@GetMapping("/busca-cep/{cep}")
	@ResponseStatus(value = HttpStatus.OK)
	public ViaCepResponseDTO buscarCep(@PathVariable String cep) throws ClientException {
		String msgLog = "ExampleController - buscaCep";
		
		log.info("{} - Chamando Serviço ViaCEP", msgLog);
		var dto = viaCepService.buscarCep(cep);
		log.info("{} - Serviço respondeu com sucesso", msgLog);
		
		return dto;
	}
	
    @ApiOperation(value = "Rota para criar um Post fake na API JsonPlaceholder.")
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successo."),
    })	
	@PostMapping("/criar-post")
	@ResponseStatus(value = HttpStatus.OK)
	public JsonPlaceholderResponseDTO criarPost(@RequestBody JsonPlaceholderRequestDTO requestDto) throws ClientException {
		String msgLog = "ExampleController - buscaCep";
		
		log.info("{} - Chamando Serviço JsonPlaceholder - Post", msgLog);
		var dto = jsonPlaceholderService.post(requestDto);
		log.info("{} - Serviço respondeu com sucesso", msgLog);
		
		return dto;
	}
	
}
