/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.akihi.serendipity.common.log.util;

import com.akihi.serendipity.common.core.SpringContextHolder;
import com.akihi.serendipity.common.core.contant.SecurityConstants;
import com.akihi.serendipity.common.log.config.LogProperties;
import com.akihi.serendipity.common.log.event.SysLogEventSource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

/**
 * 系统日志工具类
 *
 * @author L.cm
 */

public class SysLogUtils {

	public static SysLogEventSource getSysLog() {
		HttpServletRequest request = ((ServletRequestAttributes) Objects
				.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
		SysLogEventSource sysLog = new SysLogEventSource();
		sysLog.setLogType(LogTypeEnum.NORMAL.getType());
		sysLog.setRequestUri(request.getRequestURI());
		sysLog.setMethod(request.getMethod());
		sysLog.setRemoteAddr(request.getRemoteAddr());
		sysLog.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
		sysLog.setCreateBy(getUsername());
		sysLog.setServiceId(getClientId());

		// get 参数脱敏
//		LogProperties logProperties = SpringContextHolder.getBean(LogProperties.class);
//		Maps.
//		Map<String, String[]> paramsMap = MapUtil.removeAny(request.getParameterMap(),
//				ArrayUtils.toArray(logProperties.getExcludeFields(), String.class));
		sysLog.setParams(request.getParameterMap().toString());
		return sysLog;
	}

	/**
	 * 获取用户名称
	 * @return username
	 */
	private static String getUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}
		return authentication.getName();
	}

	/**
	 * 获取spel 定义的参数值
	 * @param context 参数容器
	 * @param key key
	 * @param clazz 需要返回的类型
	 * @param <T> 返回泛型
	 * @return 参数值
	 */
	public static <T> T getValue(EvaluationContext context, String key, Class<T> clazz) {
		SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
		Expression expression = spelExpressionParser.parseExpression(key);
		return expression.getValue(context, clazz);
	}

	/**
	 * 获取参数容器
	 * @param arguments 方法的参数列表
	 * @param signatureMethod 被执行的方法体
	 * @return 装载参数的容器
	 */
	public static EvaluationContext getContext(Object[] arguments, Method signatureMethod) {
		String[] parameterNames = new StandardReflectionParameterNameDiscoverer().getParameterNames(signatureMethod);
		EvaluationContext context = new StandardEvaluationContext();
		if (parameterNames == null) {
			return context;
		}
		for (int i = 0; i < arguments.length; i++) {
			context.setVariable(parameterNames[i], arguments[i]);
		}
		return context;
	}

	/**
	 * 获取客户端
	 * @return clientId
	 */
	private static String getClientId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}

		Object principal = authentication.getPrincipal();
		if (principal instanceof OAuth2AuthenticatedPrincipal auth2Authentication) {
			return auth2Authentication.getAttributes().get(SecurityConstants.CLIENT_ID).toString();
		}
		return null;
	}

}
