package com.eazybytes.eazyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
//                .anyRequest().permitAll()                        //permit all requests inside the web application
//                .and().formLogin()
//                .and().httpBasic();

                //Deny all requests inside the web application
                .anyRequest().denyAll()
                .and().formLogin()
                .and().httpBasic();

        return  http.build();
    }

}
