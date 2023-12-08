package com.dmkj.ljadmin.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.dmkj.ljadmin.common.filter.RequestValidationBeforeFilter;

/**
 * SpringSecurity的配置
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(
                "/swagger-ui/**", //
                "/swagger-resources/**",
                "/api/hardware/**",
                "/api/v3/api-docs/**");
    }

    // @Bean
    // SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws
    // Exception {
    // return http.authorizeHttpRequests((authorize) ->
    // authorize.anyRequest().authenticated())
    // .build();
    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                (authz) -> authz.requestMatchers("/login", "/api/hardware/**").permitAll()
                        .anyRequest().authenticated())
                .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class);
        // .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
