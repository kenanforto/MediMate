package com.medimate.MedicalRecordMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medimate.MedicalRecordMicroservice.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patient")
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

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<MedicalRecord> medicalRecords;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<AdmissionRecord> admissionRecords;

    public Patient(String firstName, String lastName, LocalDate birthdate, Gender gender, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
