package com.example.springbootmydiaryserver.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll() // Gives first authorization to public routes
                // Then secure any other request, considering them to be private,
                // This shows how we should start matching all routes with the least privileges then the most secured come after
                .anyRequest()
                .authenticated()
                .and().formLogin()
                .and().httpBasic();

    }
}
