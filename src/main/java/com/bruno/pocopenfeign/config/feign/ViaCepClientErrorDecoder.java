package com.bruno.pocopenfeign.config.feign;

import com.bruno.pocopenfeign.exception.ClientException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class ViaCepClientErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String msg, Response response) {
		
		return new ClientException("Client Retornou Erro.");

//        try (Reader reader = response.body().asReader(Charset.defaultCharset())) {
//            String jsonString = CharStreams.toString(reader);
//            CredentialEcClientError obj = new Gson().fromJson(jsonString, CredentialEcClientError.class);
//            return new CredentialEcClientException(obj);
//            
//        } catch (Exception e) {
//        	return new CredentialEcClientException(e.getMessage());
//        }
	}

}
