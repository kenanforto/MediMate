package com.medimate.SurveyMicroservice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue
    private Integer id;
    private String body;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    public Survey(Integer id, String body, Patient patient) {
        this.id = id;
        this.body = body;
        this.patient = patient;
    }

    public Survey() {}
}
