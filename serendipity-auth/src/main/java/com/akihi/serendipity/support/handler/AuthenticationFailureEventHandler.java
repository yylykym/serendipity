package com.akihi.serendipity.support.handler;

import com.akihi.serendipity.common.core.util.R;
import com.akihi.serendipity.common.core.contant.SecurityConstants;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class AuthenticationFailureEventHandler implements AuthenticationFailureHandler {

    private final MappingJackson2HttpMessageConverter errorHttpResponseConverter = new MappingJackson2HttpMessageConverter();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter(OAuth2ParameterNames.USERNAME);

//        log.info("用户：{} 登录失败，异常：{}", username, exception.getLocalizedMessage());
//        SysLog logVo = SysLogUtils.getSysLog();
//        logVo.setTitle("登录失败");
//        logVo.setLogType(LogTypeEnum.ERROR.getType());
//        logVo.setException(exception.getLocalizedMessage());
//        // 发送异步日志事件
//        String startTimeStr = request.getHeader(CommonConstants.REQUEST_START_TIME);
//        if (StrUtil.isNotBlank(startTimeStr)) {
//            Long startTime = Long.parseLong(startTimeStr);
//            Long endTime = System.currentTimeMillis();
//            logVo.setTime(endTime - startTime);
//        }
//        logVo.setCreateBy(username);
//        SpringContextHolder.publishEvent(new SysLogEvent(logVo));
        // 写出错误信息
        sendErrorResponse(request, response, exception);
    }
    private void sendErrorResponse(HttpServletRequest request, HttpServletResponse response,
                                   AuthenticationException exception) throws IOException {
        ServletServerHttpResponse httpResponse = new ServletServerHttpResponse(response);
        httpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
        String errorMessage;

        if (exception instanceof OAuth2AuthenticationException authorizationException) {
            errorMessage = !StringUtils.hasLength(authorizationException.getError().getDescription())
                    ? authorizationException.getError().getErrorCode()
                    : authorizationException.getError().getDescription();
        }
        else {
            errorMessage = exception.getLocalizedMessage();
        }

        // 手机号登录
        String grantType = request.getParameter(OAuth2ParameterNames.GRANT_TYPE);
        if (SecurityConstants.MOBILE.equals(grantType)) {
//            errorMessage = MsgUtils.getSecurityMessage("AbstractUserDetailsAuthenticationProvider.smsBadCredentials");
        }
        this.errorHttpResponseConverter.write(R.failed(errorMessage), MediaType.APPLICATION_JSON, httpResponse);
    }

}
