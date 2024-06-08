package com.medimate.SpringCloudGateway.security;

import com.medimate.SpringCloudGateway.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDao {
    private Integer id;
    private String email;
    private String password;
    private Role role;
}
