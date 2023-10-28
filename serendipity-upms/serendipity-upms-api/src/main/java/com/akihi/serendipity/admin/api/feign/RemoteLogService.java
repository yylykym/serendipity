package com.akihi.serendipity.admin.api.feign;

import com.akihi.serendipity.admin.api.domain.SysLog;
import com.akihi.serendipity.common.core.R;
import com.akihi.serendipity.common.core.contant.SecurityConstants;
import com.akihi.serendipity.common.core.contant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(contextId = "remoteLogService", value = ServiceNameConstants.UMPS_SERVICE)
public interface RemoteLogService {

    /**
     * 保存日志
     * @param sysLog 日志实体
     * @param from 是否内部调用
     * @return succes、false
     */
    @PostMapping("/resource")
    R<Boolean> saveLog(@RequestBody SysLog sysLog, @RequestHeader(SecurityConstants.FROM) String from);

}
