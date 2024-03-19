package com.medimate.UserMicroservice.models;

import com.medimate.UserMicroservice.enums.Gender;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="patient")
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

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    protected Patient(){}
    public Patient(String first_name, String last_name, Date birthdate, Gender gender, String adress, String phone_number) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = adress;
        this.phoneNumber = phone_number;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthdate() {
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
