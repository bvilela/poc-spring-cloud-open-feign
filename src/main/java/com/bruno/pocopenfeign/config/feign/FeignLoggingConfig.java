package com.bruno.pocopenfeign.config.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLoggingConfig {

    @Bean
    public FeignCustomRequestLogging feignCustomRequestLogging() {
        return new FeignCustomRequestLogging();
    }
    
}
