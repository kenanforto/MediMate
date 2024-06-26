package com.medimate.AppointmentMicroservice.viewModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.medimate.AppointmentMicroservice.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class PatientVM {
    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String firstName;
    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String lastName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate birthdate;
    @NotBlank
    private Gender gender;
    @Pattern(regexp = "^(\\d+)?([A-Za-z](?= ))?(.*?)([^ ]+?)?((?<= )APT)? ?((?<= )\\d*)?$")
    private String address;
    @Pattern(regexp = "^\\+?[0-9]{7,14}$")

    private String phoneNumber;

    public PatientVM(String firstName, String lastName, LocalDate birthdate, Gender gender, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

}