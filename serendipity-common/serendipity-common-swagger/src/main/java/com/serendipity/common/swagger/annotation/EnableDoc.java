package com.serendipity.common.swagger.annotation;

import com.serendipity.common.swagger.config.OpenAPIDefinitionImportSelector;
import com.serendipity.common.swagger.support.SwaggerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableConfigurationProperties(SwaggerProperties.class)
@Import(OpenAPIDefinitionImportSelector.class)
public @interface EnableDoc {

    /**
     * 网关路由前缀
     * @return String
     */
    String value();

    /**
     * 是否是微服务架构
     * @return true
     */
    boolean isMicro() default true;

}
