package com.medimate.SurveyMicroservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    @NotBlank
    private String body;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    public Survey(String body, Patient patient) {
        this.body = body;
        this.patient = patient;
    }

    public Survey() {}

    public String getBody() {
        return body;
    }

    public Patient getPatient() {
        return patient;
    }
}
