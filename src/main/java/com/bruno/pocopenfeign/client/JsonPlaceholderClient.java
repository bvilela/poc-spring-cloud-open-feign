package com.bruno.pocopenfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bruno.pocopenfeign.dto.JsonPlaceholderRequestDTO;
import com.bruno.pocopenfeign.dto.JsonPlaceholderResponseDTO;

@FeignClient(url = "${jsonPlaceholderClient.url}", name = "jsonPlaceholderClient")
public interface JsonPlaceholderClient {

	@PostMapping(value = "/posts", produces = "application/json", consumes = "application/json")
	public JsonPlaceholderResponseDTO post(@RequestBody JsonPlaceholderRequestDTO dto);
}
