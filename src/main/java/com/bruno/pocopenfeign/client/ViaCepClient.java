package com.bruno.pocopenfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bruno.pocopenfeign.dto.ViaCepDTO;

@FeignClient(url = "${viaCepClient.url}", name = "viaCepClient")
public interface ViaCepClient {

	@GetMapping(value = "/{cep}/json/", produces = "application/json")
	public ViaCepDTO buscaCep(@PathVariable("cep") String cep);
	
}
