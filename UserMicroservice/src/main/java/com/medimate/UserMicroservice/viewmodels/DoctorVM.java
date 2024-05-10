package com.medimate.UserMicroservice.viewmodels;

import com.medimate.UserMicroservice.models.Doctor;
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

    Integer userId;
    public DoctorVM(String firstName, String lastName, String title,Integer userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.userId=userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public static Doctor toEntity(DoctorVM doctor)
    {
        return new Doctor(doctor.firstName, doctor.lastName, doctor.title, doctor.userId);
    }
}
