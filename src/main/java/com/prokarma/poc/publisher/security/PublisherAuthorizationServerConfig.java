package com.prokarma.poc.publisher.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class PublisherAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private PasswordEncoder passwordEncoder;

    @Value("${authorization.clientId}")
    private String clientId;

    @Value("${authorization.clientSecret}")
    private String clientSecret;

    @Value("${authorization.grantTypes}")
    private String grantTypes;

    @Value("${authorization.authorizedScopes}")
    private String authorizedScopes;

    @Value("${authorization.tokenExpiryTime}")
    private Integer expiryTime;

    @Autowired
    PublisherAuthorizationServerConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient(clientId).secret(passwordEncoder.encode(clientSecret))
                .authorizedGrantTypes(grantTypes).scopes(authorizedScopes).accessTokenValiditySeconds(expiryTime);
    }


}
