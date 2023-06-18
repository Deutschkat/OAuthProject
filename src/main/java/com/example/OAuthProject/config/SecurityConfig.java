package com.example.OAuthProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/protected").authenticated()
                .anyRequest().permitAll()
                .and()
                .oauth2Login()
                .and()
                .logout()
                .logoutUrl("/logout")
                // implementation
                .logoutSuccessUrl("/logout-success") // Add a custom URL for logout success
                .permitAll()
                .and()
               // implementation
                .sessionManagement()
                .maximumSessions(3) // Set the maximum allowed sessions to 3
                .maxSessionsPreventsLogin(true) // Prevent a new login if the maximum number of sessions for a user has been reached
                .expiredUrl("/signin?expired"); // Forward requests made using an expired JSESSIONID to /signin?expired

        return http.build();
    }
}



