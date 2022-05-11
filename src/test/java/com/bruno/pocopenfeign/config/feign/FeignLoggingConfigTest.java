package com.bruno.pocopenfeign.config.feign;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class FeignLoggingConfigTest {

	@Mock
	private FeignLoggingConfig feignLoggingConfig;
	
	@BeforeEach
	void setup() {
		feignLoggingConfig = new FeignLoggingConfig();
	}
	
	@Test
	void shouldFeignCustomRequestLogging() {
		assertNotNull(feignLoggingConfig.feignCustomRequestLogging());
	}
	
}
