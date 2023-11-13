package com.hamv.login.microservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hamv.login.microservice.security.jwt.AuthEntryPointJwt;
import com.hamv.login.microservice.security.jwt.AuthTokenFilter;
import com.hamv.login.microservice.security.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    public void userDetailsService(UserDetailsServiceImpl userDetailsService){
        this.userDetailsService=userDetailsService;
    }

    private AuthEntryPointJwt unauthorizedHandler;
    @Autowired
    public void unauthorizedHandler(AuthEntryPointJwt unauthorizedHandler){
        this.unauthorizedHandler=unauthorizedHandler;
    }

    @Bean
    AuthTokenFilter authenticationJwtTokenFilter(){
        return new AuthTokenFilter();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
	SessionRegistry sessionRegistry() {
	    return new SessionRegistryImpl();
	}

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	  http.csrf(csrf -> csrf.disable())
        .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
        .sessionManagement(
        		session -> session.
        		maximumSessions(1)
        		.maxSessionsPreventsLogin(true)
        		)
        .authorizeHttpRequests(auth -> 
          auth.requestMatchers("/api/auth/**").permitAll()
              .requestMatchers("/api/test/**").permitAll()
              .requestMatchers("/api/**").permitAll()
              .requestMatchers("/v3/**").permitAll()
              .requestMatchers("/swagger-ui/**").permitAll()
              .requestMatchers("/v3/api-docs/**").permitAll()
              .anyRequest().authenticated()
        );
    
    http.authenticationProvider(authenticationProvider());

    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    
    return http.build();
  }
}
