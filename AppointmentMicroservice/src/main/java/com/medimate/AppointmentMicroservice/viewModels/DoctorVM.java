package com.medimate.AppointmentMicroservice.viewModels;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class DoctorVM {
    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String firstName;
    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String lastName;
    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String title;
    public DoctorVM(String firstName, String lastName, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

}
