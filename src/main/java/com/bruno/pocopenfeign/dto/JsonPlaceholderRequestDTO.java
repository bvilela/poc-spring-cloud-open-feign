package com.bruno.pocopenfeign.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class JsonPlaceholderRequestDTO {

	private String title;
	private String body;
	private int userId;
	
}
