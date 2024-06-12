package com.medimate.UserMicroservice.viewmodels;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.medimate.UserMicroservice.enums.Gender;
import com.medimate.UserMicroservice.models.Patient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class PatientVM {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;
    @NotBlank
    private Gender gender;
    @Pattern(regexp = "^(\\d+)?([A-Za-z](?= ))?(.*?)([^ ]+?)?((?<= )APT)? ?((?<= )\\d*)?$")
    private String address;
    @Pattern(regexp = "^\\+?[0-9]{7,14}$")

    private String phoneNumber;

    private Integer userId;

    public PatientVM(LocalDate birthdate, Gender gender, String address, String phoneNumber) {
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public static Patient toEntity(PatientVM patient)
    {
        return new Patient(patient.birthdate,patient.gender,patient.address,patient.phoneNumber,patient.userId);
    }
}
