package com.bruno.pocopenfeign.builders;

import org.apache.commons.lang3.RandomStringUtils;

import com.bruno.pocopenfeign.dto.ViaCepResponseDTO;

public class ViaCepResponseDtoBuilder {
    
	public static ViaCepResponseDTO withRandomData() {
		return new ViaCepResponseDTO(RandomStringUtils.randomNumeric(8), RandomStringUtils.randomAlphabetic(20), 
				RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomAlphabetic(15), RandomStringUtils.randomAlphabetic(10), 
				RandomStringUtils.randomAlphabetic(2), RandomStringUtils.randomAlphabetic(5));
	}
	
}
