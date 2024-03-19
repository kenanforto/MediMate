package com.medimate.AdmissionMicroservice.models;

import com.medimate.AdmissionMicroservice.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDate birthdate;

    private Gender gender;

    private String address;

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
