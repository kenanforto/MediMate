package com.medimate.SpringCloudGateway.security;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class AuthenticationRequest {
    String email;
    String password;

    public AuthenticationRequest(String email,String password)
    {
        this.email=email;
        this.password=password;
    }

}
