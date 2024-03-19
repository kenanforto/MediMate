package com.medimate.UserMicroservice.models;

import jakarta.persistence.*;

@Entity
@Table(name="doctor")
public class Doctor {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String title;
    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    protected Doctor(){}

    public Doctor(String first_name, String last_name, String title) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.title = title;
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

    public String getTitle() {
        return title;
    }
}
