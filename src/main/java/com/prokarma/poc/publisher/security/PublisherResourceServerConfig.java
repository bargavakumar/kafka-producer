package com.prokarma.poc.publisher.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.poc.publisher.constants.PublisherConstant;
import com.prokarma.poc.publisher.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@Configuration
@EnableResourceServer
public class PublisherResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static Logger logger = LoggerFactory.getLogger(PublisherResourceServerConfig.class);
    private String exceptionMsg = "applicationName=Publisher|Exception thrown={}";

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/publisher/v1/**").authenticated().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler()).authenticationEntryPoint(authenticationEntryPoint());
    }

    @Bean
    AccessDeniedHandler accessDeniedHandler() {
        return (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) -> {
            ResponseEntity<ErrorResponse> errorResponseResponseEntity = new ResponseEntity<>(new ErrorResponse(PublisherConstant.Error, e.getMessage(), e.getClass().getSimpleName()), HttpStatus.FORBIDDEN);
            OutputStream out = httpServletResponse.getOutputStream();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out, errorResponseResponseEntity);
            logger.error(exceptionMsg, errorResponseResponseEntity);
            out.flush();
        };

    }

    @Bean
    AuthenticationEntryPoint authenticationEntryPoint() {
        return (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) -> {
            ResponseEntity<ErrorResponse> errorResponseResponseEntity = new ResponseEntity<>(new ErrorResponse(PublisherConstant.Error, e.getMessage(),  e.getClass().getSimpleName()), HttpStatus.UNAUTHORIZED);
            OutputStream out = httpServletResponse.getOutputStream();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out, errorResponseResponseEntity);
            logger.error(exceptionMsg, errorResponseResponseEntity);
            out.flush();
        };
    }


    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
