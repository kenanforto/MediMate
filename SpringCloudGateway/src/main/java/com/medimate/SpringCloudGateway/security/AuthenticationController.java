package com.medimate.SpringCloudGateway.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public Mono<ResponseEntity<String>> registerUser(@RequestBody AuthenticationRequest user) throws ExecutionException, InterruptedException {
        return authenticationService.register(user);
    }

    @PostMapping(path = "/login")
    public Mono<ResponseEntity<String>> loginUser(@RequestBody AuthenticationRequest authenticationRequest)
    {
        return authenticationService.authenticate(authenticationRequest);

    }

}
