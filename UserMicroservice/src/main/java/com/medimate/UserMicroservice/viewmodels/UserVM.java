package com.medimate.UserMicroservice.viewmodels;

import com.medimate.UserMicroservice.models.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class UserVM {

    @NotBlank(message = "Username is mandatory")
    @Size(max = 20, message = "Username must contain less than 20 characters")
    private String userName;

    @NotEmpty
    private String password;

    @Email(regexp = ".+[@].+[\\.].+")
    @Email(message="Please provide a valid email address")
    private String email;

    @NotNull
    private Integer roleId;

    public UserVM(String userName, String password, String email, Integer roleId) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roleId = roleId;
    }

    public static User toEntity(UserVM userVM) {
        return new User(userVM.userName, userVM.password, userVM.email, userVM.roleId);
    }

}
