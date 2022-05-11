package com.bruno.pocopenfeign.builders;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;

import feign.Request;
import feign.Request.HttpMethod;

public class FeignRequestBuilder {

    private Request target;

    public FeignRequestBuilder() {
        this.target = null;
    }

    public static FeignRequestBuilder create() {
        return new FeignRequestBuilder();
    }

    public Request build() {
        return target;
    }
    
    public FeignRequestBuilder withHttpGet() {
    	var headers = new HashMap<String, Collection<String>>();
        return baseRequest(Request.HttpMethod.GET, headers);
	}
    
    public FeignRequestBuilder withHttpGetAndHeaders(HashMap<String, Collection<String>> headers) {
        return baseRequest(Request.HttpMethod.GET, headers);
	}
    
    private FeignRequestBuilder baseRequest(HttpMethod httpMethod, HashMap<String, Collection<String>> headers) {
		byte[] myBytes = "Any String you want".getBytes();
		this.target = Request.create(httpMethod, "", headers, myBytes, StandardCharsets.UTF_8, null);
        return this;
    }
	
}
