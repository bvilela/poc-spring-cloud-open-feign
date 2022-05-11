package com.bruno.pocopenfeign.service;

import com.bruno.pocopenfeign.dto.JsonPlaceholderRequestDTO;
import com.bruno.pocopenfeign.dto.JsonPlaceholderResponseDTO;
import com.bruno.pocopenfeign.exception.ClientException;

public interface JsonPlaceholderService {

	public JsonPlaceholderResponseDTO post(JsonPlaceholderRequestDTO requestDto) throws ClientException;
	
}
