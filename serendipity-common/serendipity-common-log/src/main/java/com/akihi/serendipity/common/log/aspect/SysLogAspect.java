
package com.akihi.serendipity.common.log.aspect;

import com.akihi.serendipity.common.core.util.SpringContextHolder;
import com.akihi.serendipity.common.log.annotation.SysLog;
import com.akihi.serendipity.common.log.event.SysLogEvent;
import com.akihi.serendipity.common.log.event.SysLogEventSource;
import com.akihi.serendipity.common.log.util.LogTypeEnum;
import com.akihi.serendipity.common.log.util.SysLogUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.EvaluationContext;
import org.springframework.util.StringUtils;

/**
 * 操作日志使用spring event异步入库
 *
 * @author L.cm
 */
@Aspect
public class SysLogAspect {

    private final Logger log = LoggerFactory.getLogger(SysLogAspect.class);

    @Around("@annotation(sysLog)")
    public Object around(ProceedingJoinPoint point, SysLog sysLog) {
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        log.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);
        String value = sysLog.value();
        String expression = sysLog.expression();
        // 当前表达式存在 SPEL，会覆盖 value 的值
        if (StringUtils.hasText(expression)) {
            // 解析SPEL
            MethodSignature signature = (MethodSignature) point.getSignature();
            EvaluationContext context = SysLogUtils.getContext(point.getArgs(), signature.getMethod());
            try {
                value = SysLogUtils.getValue(context, expression, String.class);
            } catch (Exception e) {
                // SPEL 表达式异常，获取 value 的值
                log.error("@SysLog 解析SPEL {} 异常", expression);
            }
        }

        SysLogEventSource logVo = SysLogUtils.getSysLog();
        logVo.setId("1111");
        logVo.setTitle(value);
        // 获取请求body参数
        if (StringUtils.hasText(logVo.getParams())) {
            logVo.setBody(point.getArgs());
        }
        // 发送异步日志事件
        Long startTime = System.currentTimeMillis();
        Object obj = null;

        try {
            obj = point.proceed();
        } catch (Throwable e) {
            log.error("{}-{} 执行 {} 异常", strClassName, strMethodName, e.getMessage());
            logVo.setLogType(LogTypeEnum.ERROR.getType());
            logVo.setException(e.getMessage());
        }
        Long endTime = System.currentTimeMillis();
        logVo.setExecuteTime(endTime - startTime);
        SpringContextHolder.publishEvent(new SysLogEvent(logVo));

        return obj;
    }

}
