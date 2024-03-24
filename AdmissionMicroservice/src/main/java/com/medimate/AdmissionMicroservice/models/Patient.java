package com.medimate.AdmissionMicroservice.models;

import com.medimate.AdmissionMicroservice.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

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
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "patient")
    List<AdmissionRecord> admissionRecords;

    public Patient(String firstName, String lastName, LocalDate birthdate, Gender gender, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Patient() {}
}
