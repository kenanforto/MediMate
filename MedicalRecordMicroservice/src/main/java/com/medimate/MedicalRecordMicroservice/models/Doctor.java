package com.medimate.MedicalRecordMicroservice.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="doctor")
public class Doctor {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String title;

    @OneToMany(mappedBy = "doctor")
    private List<MedicalRecord> medicalRecords;
    protected Doctor(){}

    public Doctor(String firstName, String lastName, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
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
