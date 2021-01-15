package com.prokarma.poc.publisher.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class PublisherAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("encoder")
    PasswordEncoder passwordEncoder;

    @Value("${publisher-clientId}")
    private String clientId;

    @Value("${publisher-clientSecret}")
    private String clientSecret;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient(clientId).secret(passwordEncoder.encode(clientSecret))
                .authorizedGrantTypes("client_credentials").scopes("all").accessTokenValiditySeconds(900);
    }

   /*
                .refreshTokenValiditySeconds(240000)   */


}
