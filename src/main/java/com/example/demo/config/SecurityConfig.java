package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();

        UserDetails traveler = User.withDefaultPasswordEncoder()
                .username("traveler")
                .password("password")
                .roles("TRAVELER")
                .build();
        return new InMemoryUserDetailsManager(admin, traveler);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/traveler/**").hasRole("TRAVELER");
                    auth.requestMatchers("/admin/**").hasRole("ADMIN");
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}