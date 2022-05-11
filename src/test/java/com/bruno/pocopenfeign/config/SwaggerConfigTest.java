package com.bruno.pocopenfeign.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import springfox.documentation.spring.web.plugins.Docket;

class SwaggerConfigTest {

	private final SwaggerConfig config = new SwaggerConfig();

	@Test
	void shouldCreateCircuitBreakerComponentBean() {
		Docket bean = config.docket();
		assertNotNull(bean, "Validator must not be null!");
	}

}
