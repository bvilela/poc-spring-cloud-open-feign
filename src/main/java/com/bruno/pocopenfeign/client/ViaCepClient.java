package com.bruno.pocopenfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.bruno.pocopenfeign.dto.ViaCepResponseDTO;

@FeignClient(url = "${viaCepClient.url}", name = "viaCepClient")
public interface ViaCepClient {

	@GetMapping(value = "/{cep}/json/", produces = "application/json")
	public ViaCepResponseDTO buscarCep(@RequestHeader("token") String token, @PathVariable("cep") String cep);
	
}
