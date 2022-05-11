package com.bruno.pocopenfeign.config.feign;

import static feign.Util.valuesOrEmpty;

import java.util.List;

import feign.Logger;
import feign.Request;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeignCustomRequestLogging extends Logger {
	
	private final List<String> sensitiveInfoList = List.of("token");

	@Override
	protected void logRequest(String configKey, Level logLevel, Request request) {
		log(configKey, "---> %s %s HTTP/1.1", request.httpMethod().name(), request.url());
		if (logLevel.ordinal() >= Level.HEADERS.ordinal()) {

			for (String field : request.headers().keySet()) {
				for (String value : valuesOrEmpty(request.headers(), field)) {
					
					if (sensitiveInfoList.contains(field)) {
						var regex = ".";
						var valueMasquerade = value.replaceAll(regex, "*");
						log(configKey, "%s: %s", field, valueMasquerade);
					} else {
						log(configKey, "%s: %s", field, value);
					}
				}
			}

			int bodyLength = 0;
			if (request.body() != null) {
				bodyLength = request.length();
				if (logLevel.ordinal() >= Level.FULL.ordinal()) {
					String bodyText = request.charset() != null ? new String(request.body(), request.charset()) : null;
					log(configKey, "");
					log(configKey, "%s", bodyText != null ? bodyText : "Binary data");
				}
			}
			log(configKey, "---> END HTTP (%s-byte body)", bodyLength);
		}
	}
	
	@Override
	protected void log(String configKey, String format, Object... args) {
		log.info(format(configKey, format, args));
	}

	protected String format(String configKey, String format, Object... args) {
		return String.format(methodTag(configKey) + format, args);
	}
}
