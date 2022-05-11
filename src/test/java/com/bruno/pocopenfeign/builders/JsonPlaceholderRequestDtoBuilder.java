package com.bruno.pocopenfeign.builders;

import org.apache.commons.lang3.RandomStringUtils;

import com.bruno.pocopenfeign.dto.JsonPlaceholderRequestDTO;

public class JsonPlaceholderRequestDtoBuilder {
    
    private JsonPlaceholderRequestDTO target;

    public JsonPlaceholderRequestDtoBuilder() {
        this.target = new JsonPlaceholderRequestDTO();
    }

    public static JsonPlaceholderRequestDtoBuilder create() {
        return new JsonPlaceholderRequestDtoBuilder();
    }

    public JsonPlaceholderRequestDTO build() {
        return target;
    }
    
	public JsonPlaceholderRequestDtoBuilder withRandomData() {
        this.withTitle(RandomStringUtils.randomAlphabetic(10));
        this.withBody(RandomStringUtils.randomAlphabetic(10));
        this.withUserID(Integer.parseInt(RandomStringUtils.randomNumeric(4)));
        return this;
	}

    private JsonPlaceholderRequestDtoBuilder withTitle(String title){
        this.target.setTitle(title);
        return this;
    }

    
    private JsonPlaceholderRequestDtoBuilder withBody(String body){
        this.target.setBody(body);
        return this;
    }
    
    private JsonPlaceholderRequestDtoBuilder withUserID(int userId){
        this.target.setUserId(userId);
        return this;
    }
	
}
