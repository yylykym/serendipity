package com.akihi.serendipity.gateway.config;

import com.akihi.serendipity.gateway.hanlde.GlobalExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
//@EnableConfigurationProperties(GatewayConfigProperties.class)
public class GatewayConfiguration {
    @Bean
    public GlobalExceptionHandler globalExceptionHandler(ObjectMapper objectMapper) {
        return new GlobalExceptionHandler(objectMapper);
    }
}
