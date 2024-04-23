package com.axcore.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        UserDetails admin = User.builder()
                .username("axcoreacademy")
                .password(passwordEncoder().encode("portal123#"))
                .roles("ADMIN")
                .build();
        UserDetails user = User.builder()
                .username("axcoreuser")
                .password(passwordEncoder().encode("portaluser123#"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .requestMatchers("/css/**", "/fonts/**", "/js/**", "/images/**", "/vendors/**").permitAll() // Allow access to static resources
            .requestMatchers("/", "/home").permitAll() // Permit access to home page
            .requestMatchers("/admin").hasAuthority("ADMIN") // Require ADMIN authority for /admin page
            .requestMatchers("/user").hasAuthority("USER") // Require USER authority for /user page
            .anyRequest().authenticated() // Require authentication for any other request
            .and()
            .formLogin().loginPage("/login").permitAll() // Configure login page
            .and()
            .logout().permitAll(); // Configure logout page
        
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
