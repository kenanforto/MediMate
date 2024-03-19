package com.medimate.SurveyMicroservice.models;

import com.medimate.SurveyMicroservice.enums.Gender;
import jakarta.persistence.*;

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

    private Date birthdate;

    private Gender gender;

    private String address;

    private String phoneNumber;

    @OneToMany(mappedBy = "patient")
    private List<Survey> surveys;

    public Patient(String first_name, String last_name, Date birthdate, Gender gender, String address, String phone_number) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phone_number;
    }

    public Patient() {
    }
}
