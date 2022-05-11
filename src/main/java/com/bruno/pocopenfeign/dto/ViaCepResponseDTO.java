package com.bruno.pocopenfeign.dto;

public record ViaCepResponseDTO(
		String cep, String logradouro, String complemento, String bairro,
		String localidade, String uf, String ibge) {
}
