package com.bruno.pocopenfeign.builders;

import org.apache.commons.lang3.RandomStringUtils;

import com.bruno.pocopenfeign.dto.JsonPlaceholderResponseDTO;

public class JsonPlaceholderResponseDtoBuilder {
    
	public static JsonPlaceholderResponseDTO withRandomData() {
		
		int id = Integer.valueOf(RandomStringUtils.randomNumeric(5));
		String title = RandomStringUtils.randomAlphabetic(25);
		String body = RandomStringUtils.randomAlphabetic(50);
		int userId = Integer.valueOf(RandomStringUtils.randomNumeric(5));
		
		return new JsonPlaceholderResponseDTO(id, title, body, userId);
	}
	
}
