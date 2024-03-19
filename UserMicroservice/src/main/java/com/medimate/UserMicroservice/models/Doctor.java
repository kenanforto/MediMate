package com.medimate.UserMicroservice.models;

import jakarta.persistence.*;

@Entity
@Table(name="doctors")
public class Doctor {
    @Id
    @GeneratedValue
    private Integer id;
    private String first_name;
    private String last_name;
    private String title;
    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    protected Doctor(){}

    public Doctor(String first_name, String last_name, String title) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.title = title;
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

    public String getTitle() {
        return title;
    }
}
