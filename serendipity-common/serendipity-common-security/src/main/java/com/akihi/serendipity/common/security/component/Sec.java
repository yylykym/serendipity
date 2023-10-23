package com.akihi.serendipity.common.security.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.authorization.InMemoryOAuth2AuthorizationService;

@Configuration
public class Sec {
    @Bean
    public InMemoryOAuth2AuthorizationService inMemoryOAuth2AuthorizationService() {
        return new InMemoryOAuth2AuthorizationService();
    }
}
