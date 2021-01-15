package com.prokarma.poc.publisher.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableResourceServer
public class PublisherResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/publisher/v1/**").authenticated();
    }

    //.and().exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint())
    @Bean
    AccessDeniedHandler accessDeniedHandler() {
        return (request, response, authException) -> {
            System.out.println("am I executing babu ?? inside AccessDeniedHandler");
        };
    }

    @Bean
    public AuthenticationEntryPoint unauthorizedEntryPoint() {
        return (request, response, authException) -> {
            System.out.println("am I executing babu ?? inside AuthenticationEntryPoint");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        };
    }

    @Bean
    @Qualifier("encoder")
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
