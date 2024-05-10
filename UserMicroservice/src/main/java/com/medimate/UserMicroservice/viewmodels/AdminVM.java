package com.medimate.UserMicroservice.viewmodels;

import com.medimate.UserMicroservice.models.Admin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AdminVM {
    @NotBlank
    @NotNull
    @Pattern(regexp="[A-Za-z]+")
    private String firstName;

    @NotBlank
    @NotNull
    @Pattern(regexp="[A-Za-z]+")
    private String lastName;

    Integer userId;
    public AdminVM(String firstName, String lastName,Integer userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId=userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public static Admin toEntity(AdminVM adminVM) {
        return new Admin(adminVM.firstName, adminVM.lastName,adminVM.userId);
    }
}

