package com.bruno.pocopenfeign.config.feign;

import java.io.Reader;
import java.nio.charset.Charset;

import com.bruno.pocopenfeign.exception.ClientException;
import com.google.common.io.CharStreams;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ViaCepClientErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String msg, Response response) {
		
        try (Reader reader = response.body().asReader(Charset.defaultCharset())) {
            String value = CharStreams.toString(reader);
            log.error("Erro no Client ViaCEP: {}", value);
            return new ClientException("Client Retornou Erro.");
            
        } catch (Exception e) {
        	return new ClientException(e.getMessage());
        }
	}

}
