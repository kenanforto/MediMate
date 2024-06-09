package com.medimate.SpringCloudGateway.security;

import com.medimate.SpringCloudGateway.enums.Role;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.concurrent.ExecutionException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final WebClient.Builder webClientBuilder;

    @Bean
    public ReactiveUserDetailsService userDetailsService() {
        return new ReactiveUserDetailsService() {
            public Mono<UserDetails> findByUsername(String username) {
                System.out.println("Uslo je ovdje ");
                return webClientBuilder.build()
                        .get()
                        .uri("lb://USERMICROSERVICE/users/{email}", username)
                        .retrieve()
                        .toEntity(User.class)
                        .flatMap(responseEntity ->{
                            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                                User user= new User.UserBuilder()
                                        .email(responseEntity.getBody().getEmail())
                                        .password(responseEntity.getBody().getPassword())
                                        .role(responseEntity.getBody().getRole())
                                        .isAccountNonExpired(true)
                                        .isAccountNonLocked(true)
                                        .isCredentialsNonExpired(true)
                                        .isEnabled(true)
                                        .build();
                                return Mono.just(user);

                                    }
                                    return Mono.empty();
                                }

                        );
            }
        };
    }
    @Bean
    public ReactiveAuthenticationManager reactiveAuthenticationManager()
    {
        var authenticationManager=new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService());
        authenticationManager.setPasswordEncoder(passwordEncoder());
        return authenticationManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
            }

}
