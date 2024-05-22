package com.medimate.AppointmentMicroservice.models;

import com.medimate.AppointmentMicroservice.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;

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

//    @JsonIgnore
//    @OneToMany(mappedBy = "patient")
//    private List<Appointment> appointments;


    public Patient(String firstName, String lastName, LocalDate birthdate, Gender gender, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Patient() {}

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
