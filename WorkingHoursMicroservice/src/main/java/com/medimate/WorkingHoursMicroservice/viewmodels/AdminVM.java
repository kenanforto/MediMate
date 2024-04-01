package com.medimate.WorkingHoursMicroservice.viewmodels;

import com.medimate.WorkingHoursMicroservice.models.Admin;
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

    public AdminVM(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public static Admin toEntity(AdminVM adminVM) {
        return new Admin(adminVM.firstName, adminVM.lastName);
    }
}
