package com.resoto.survey.surveyhandler.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.http.HttpMethod;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${run.secure}")
    private Boolean runSecure;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        if (runSecure) {
            return getSecureFilterChain(http);
        }
        else
        {
            return getOpenFilterChain(http);
        }
    }

    private DefaultSecurityFilterChain getOpenFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()
                )
                .addFilterAfter(new RolesBasedFilter(), UsernamePasswordAuthenticationFilter.class)
                .oauth2Login(withDefaults());
        return http.build();
    }

    private DefaultSecurityFilterChain getSecureFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, "/surveys").authenticated()
                        .anyRequest().authenticated()
                )
                .addFilterAfter(new RolesBasedFilter(), UsernamePasswordAuthenticationFilter.class)
                .oauth2Login(withDefaults());
        return http.build();
    }
}