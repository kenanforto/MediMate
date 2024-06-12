package com.medimate.UserMicroservice.viewmodels;

import com.medimate.UserMicroservice.models.Role;
import com.medimate.UserMicroservice.models.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class UserVM {


    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String lastName;

    @NotEmpty
    private String password;

    @Email(regexp = ".+[@].+[\\.].+")
    @Email(message="Please provide a valid email address")
    private String email;

    @NotNull
    private Role role=Role.PATIENT;

    public UserVM(String firstName,String lastName,String email, String password) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.password = password;
        this.email = email;
    }

    public static User toEntity(UserVM userVM) {
        return new User( userVM.firstName,userVM.lastName,userVM.email,userVM.password,userVM.role);
    }

}
