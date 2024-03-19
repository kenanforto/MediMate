package com.medimate.UserMicroservice.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue
    private Integer id;
    private String first_name;
    private String last_name;
    private Date birthdate;
    private Gender gender;
    private String adress;
    private String phone_number;


    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    public enum Gender{
        male,female
    }
    protected Patient(){}
    public Patient(String first_name, String last_name, Date birthdate, Gender gender, String adress, String phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.adress = adress;
        this.phone_number = phone_number;
    }

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone_number() {
        return phone_number;
    }
}
