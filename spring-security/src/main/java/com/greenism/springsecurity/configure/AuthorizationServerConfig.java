package com.greenism.springsecurity.configure;

import com.greenism.springsecurity.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig  extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired(required = false)
    private TokenStore tokenStore;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
        clients.inMemory()
                .withClient("client")
                .authorizedGrantTypes("password", "refresh_token") //授权模式为password和refresh_token两种
                .accessTokenValiditySeconds(1800) // 配置access_token的过期时间
                .resourceIds("rid") //配置资源id
                .scopes("all")
                .secret("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq"); //123加密后的密码
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore) //配置令牌的存储（这里存放在内存中）
                .authenticationManager(authenticationManager)
                .userDetailsService(customUserDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        // 表示支持 client_id 和 client_secret 做登录认证
        security.allowFormAuthenticationForClients();
    }
}
