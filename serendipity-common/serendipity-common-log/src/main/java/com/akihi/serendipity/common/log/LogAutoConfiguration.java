package com.akihi.serendipity.common.log;

import com.akihi.serendipity.admin.api.feign.RemoteLogService;
import com.akihi.serendipity.common.log.aspect.SysLogAspect;
import com.akihi.serendipity.common.log.config.LogProperties;
import com.akihi.serendipity.common.log.event.SysLogListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration(proxyBeanMethods = false)
@EnableFeignClients
@EnableConfigurationProperties(LogProperties.class)
public class LogAutoConfiguration {
    @Bean
    public SysLogListener sysLogListener(LogProperties logProperties, RemoteLogService remoteLogService, ObjectMapper objectMapper) {
        return new SysLogListener(logProperties, remoteLogService, objectMapper);
    }
    @Bean
    public SysLogAspect sysLogAspect() {
        return new SysLogAspect();
    }
}
