package com.medimate.SurveyMicroservice.models;

import com.medimate.SurveyMicroservice.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String firstName;

    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String lastName;

    @NotNull
    private LocalDate birthdate;

    @NotNull
    private Gender gender;

    @Pattern(regexp = "^(\\d+)?([A-Za-z](?= ))?(.*?)([^ ]+?)?((?<= )APT)? ?((?<= )\\d*)?$")
    private String address;

    @Pattern(regexp = "^\\+?[0-9]{7,14}$")
    private String phoneNumber;

    @OneToMany(mappedBy = "patient")
    private List<Survey> surveys;

    public Patient(String first_name, String last_name, LocalDate birthdate, Gender gender, String address, String phone_number) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phone_number;
    }

    public Patient() {
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
