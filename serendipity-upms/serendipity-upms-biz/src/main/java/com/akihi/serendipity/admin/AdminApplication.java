package com.akihi.serendipity.admin;

import com.akihi.serendipity.common.swagger.annotation.EnableDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableDoc("admin")
@SpringBootApplication
@EnableFeignClients(basePackages = "com.akihi.*")
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
