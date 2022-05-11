package com.bruno.pocopenfeign.config.feign;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class FeignConfigLocalTest {
	
	@Mock
	private FeignConfigLocal feignConfigLocal;
	
	@BeforeEach
	void setup() {
		feignConfigLocal = new FeignConfigLocal();
	}
	
	@Test
	void shouldFeignClient() {
		assertNotNull(feignConfigLocal.feignClient());
	}

}
