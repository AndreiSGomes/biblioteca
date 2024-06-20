package com.example.biblioteca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
		@Bean
		SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
			return http
					.formLogin(form->form
							.loginPage("/login")
							.permitAll())
					
					.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					.authorizeHttpRequests(auth->auth
							.requestMatchers("/images/**").permitAll()
							.requestMatchers("/css/**").permitAll()
							.requestMatchers(HttpMethod.GET, "/**").permitAll()
							.requestMatchers(HttpMethod.POST, "/**").permitAll()
							.anyRequest().authenticated())
					
					.csrf(csrf -> csrf.disable())
					.build();
						
		}
}
