package com.medimate.SpringCloudGateway.security;

import com.medimate.SpringCloudGateway.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final WebClient.Builder webClientBuilder;
    private final JwtConfig jwtConfig;
    private final ReactiveUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final ReactiveAuthenticationManager authenticationManager;
    public Mono<ResponseEntity<String>> authenticate(AuthenticationRequest authenticationRequest) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        )
                .flatMap(authentication -> {
                    UserDetails userDetails=(UserDetails) authentication.getPrincipal();
                    return userDetailsService.findByUsername(userDetails.getUsername())

                .map(jwtConfig::generateToken)
                .map(token -> ResponseEntity.ok().body(token))
                .doOnError( error -> ResponseEntity.badRequest().body(error.getMessage()));
                })
                .onErrorResume(error ->
                {
                    return Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password!"));
                });
    }

    public Mono<ResponseEntity<String>> register(AuthenticationRequest user) throws ExecutionException, InterruptedException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return webClientBuilder.build()
                .post()
                .uri("lb://USERMICROSERVICE/users")
                .bodyValue(user)
                .retrieve()
                .bodyToMono(User.class)
                .map(userVM -> ResponseEntity.ok("The user has been created successfully"))
                .onErrorResume(e -> {
                    System.out.println(e.getMessage());
                    return Mono.just(ResponseEntity.status(500).body("An error occurred"));
                });
    }
}
