package com.medimate.SpringCloudGateway.security;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class RegistrationRequest {
    String firstName;
    String lastName;
    String email;
    String password;

    public RegistrationRequest(String firstName,String lastName,String email,String password)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
    }

}
