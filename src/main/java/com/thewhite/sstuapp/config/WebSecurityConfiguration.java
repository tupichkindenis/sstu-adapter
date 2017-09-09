package com.thewhite.sstuapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by tupichkindenis on 16.08.17.
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/").permitAll()
                .and()
                .authorizeRequests().antMatchers("/console/**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/v2/api-docs",
                    "/configuration/ui",
                    "/swagger-resources",
                    "/configuration/security",
                    "/webjars/**",
                    "/swagger-resources/configuration/ui",
                    "/swagge‌​r-ui.html",
                    "/metrics/**",
                    "/swagger-resources/configuration/security").permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
}
