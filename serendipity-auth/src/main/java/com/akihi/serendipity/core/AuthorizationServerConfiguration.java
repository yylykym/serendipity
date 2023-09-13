package com.akihi.serendipity.core;

import com.akihi.serendipity.support.handler.AuthenticationFailureEventHandler;
import com.akihi.serendipity.support.handler.AuthenticationSuccessEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.security.oauth2.server.authorization.web.authentication.*;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.time.Duration;
import java.util.Arrays;
import java.util.UUID;

@Configuration
public class AuthorizationServerConfiguration {

    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        // ---------- 1、检查当前客户端是否已注册
        // 操作数据库对象

        /*
         客户端在数据库中记录的区别
         ------------------------------------------
         id：仅表示客户端在数据库中的这个记录
         client_id：唯一标示客户端；请求token时，以此作为客户端的账号
         client_name：客户端的名称，可以省略
         client_secret：密码
         */
        String clientId_1 = "my_client";
        String clientId_2 = "micro_service";

        // ---------- 2、添加客户端
        // 数据库中没有
//        if (registeredClient_1 == null) {
//            registeredClient_1 = this.createRegisteredClientAuthorizationCode(clientId_1);
//            registeredClientRepository.save(registeredClient_1);
//        }
        // 数据库中没有
        InMemoryRegisteredClientRepository registeredClientRepository = new InMemoryRegisteredClientRepository(this.createRegisteredClient(clientId_2));


        // ---------- 3、返回客户端仓库
        return registeredClientRepository;
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {

        OAuth2AuthorizationServerConfigurer authorizationServerConfigurer = new OAuth2AuthorizationServerConfigurer();

        http.apply(authorizationServerConfigurer.tokenEndpoint(tokenEndpoint -> {// 个性化认证授权端点
                    tokenEndpoint.accessTokenRequestConverter(accessTokenRequestConverter()) // 注入自定义的授权认证Converter
                            .accessTokenResponseHandler(new AuthenticationSuccessEventHandler()) // 登录成功处理器
                            .errorResponseHandler(new AuthenticationFailureEventHandler());// 登录失败处理器
                }).clientAuthentication(oAuth2ClientAuthenticationConfigurer -> // 个性化客户端认证
                        oAuth2ClientAuthenticationConfigurer.errorResponseHandler(new AuthenticationFailureEventHandler()))// 处理客户端认证异常
                .authorizationEndpoint(authorizationEndpoint -> authorizationEndpoint// 授权码端点个性化confirm页面
                        .consentPage("")));

        AntPathRequestMatcher[] requestMatchers = new AntPathRequestMatcher[] {
                AntPathRequestMatcher.antMatcher("/token/**"), AntPathRequestMatcher.antMatcher("/actuator/**"),
                AntPathRequestMatcher.antMatcher("/css/**"), AntPathRequestMatcher.antMatcher("/error") };

        http.authorizeHttpRequests(authorizeRequests -> {
                    // 自定义接口、端点暴露
                    authorizeRequests.requestMatchers("/**").permitAll();
                    authorizeRequests.anyRequest().authenticated();
                });
//                .apply(authorizationServerConfigurer.authorizationService(authorizationService)// redis存储token的实现
//                        .authorizationServerSettings(
//                                AuthorizationServerSettings.builder().issuer(SecurityConstants.PROJECT_LICENSE).build())
//                               );
//        http.apply(new FormIdentityLoginConfigurer());
//        DefaultSecurityFilterChain securityFilterChain = http.build();

        // 注入自定义授权模式实现
//        addCustomOAuth2GrantAuthenticationProvider(http);


        return http.build();
    }

    private AuthenticationConverter accessTokenRequestConverter() {
        return new DelegatingAuthenticationConverter(Arrays.asList(
//                new OAuth2ResourceOwnerPasswordAuthenticationConverter(),
//                new OAuth2ResourceOwnerSmsAuthenticationConverter(),
                new OAuth2RefreshTokenAuthenticationConverter(),
                new OAuth2ClientCredentialsAuthenticationConverter(),
                new OAuth2AuthorizationCodeAuthenticationConverter(),
                new OAuth2AuthorizationCodeRequestAuthenticationConverter()));
    }

    private RegisteredClient createRegisteredClient(final String clientId) {
        // JWT（Json Web Token）的配置项：TTL、是否复用refrechToken等等
        TokenSettings tokenSettings = TokenSettings.builder()
                // 令牌存活时间：1年
                .accessTokenTimeToLive(Duration.ofDays(365))
                // 令牌不可以刷新
                //.reuseRefreshTokens(false)
                .build();
        // 客户端相关配置
        ClientSettings clientSettings = ClientSettings.builder()
                // 是否需要用户授权确认
                .requireAuthorizationConsent(false)
                .build();

        return RegisteredClient
                // 客户端ID和密码
                .withId(UUID.randomUUID().toString())
                //.withId(id)
                .clientId(clientId)
                //.clientSecret("{noop}123456")
                .clientSecret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"))
                // 客户端名称：可省略
                .clientName("micro_service")
                // 授权方法
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                // 授权模式
                // ---- 【客户端模式】
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                // 客户端模式直接返回token；不需要回调地址
                //.redirectUri("...")
                // 授权范围（当前客户端的角色）
                .scope("all")
                // JWT（Json Web Token）配置项
                .tokenSettings(tokenSettings)
                // 客户端配置项
                .clientSettings(clientSettings)
                .build();
    }

}
