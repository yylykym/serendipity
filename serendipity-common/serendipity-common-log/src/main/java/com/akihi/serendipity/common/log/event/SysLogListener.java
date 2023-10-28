package com.akihi.serendipity.common.log.event;

import com.akihi.serendipity.admin.api.domain.SysLog;
import com.akihi.serendipity.common.core.contant.SecurityConstants;
import com.akihi.serendipity.admin.api.feign.RemoteLogService;
import com.akihi.serendipity.common.log.config.LogProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

import java.util.Objects;

public class SysLogListener implements InitializingBean {

    private final Logger log = LoggerFactory.getLogger(SysLogListener.class);

    private final RemoteLogService remoteLogService;

    private final LogProperties logProperties;

    private final ObjectMapper objectMapper;


    public SysLogListener(LogProperties logProperties, RemoteLogService remoteLogService, ObjectMapper objectMapper) {
        this.remoteLogService = remoteLogService;
        this.logProperties = logProperties;
        this.objectMapper = objectMapper;
    }

    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) throws JsonProcessingException {
        SysLogEventSource source = (SysLogEventSource) event.getSource();
        SysLog sysLog = new SysLog();
        BeanUtils.copyProperties(source, sysLog);

        // json 格式刷参数放在异步中处理，提升性能
        if (Objects.nonNull(source.getBody())) {
            String params = objectMapper.writeValueAsString(source.getBody());
            sysLog.setParams(params);
        }

        remoteLogService.saveLog(sysLog, SecurityConstants.FROM_IN);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
