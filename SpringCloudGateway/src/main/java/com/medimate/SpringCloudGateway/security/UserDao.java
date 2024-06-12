package com.medimate.SpringCloudGateway.security;

import com.medimate.SpringCloudGateway.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDao {
    private Integer id;
    private String firstName;
    private Role role;
}
