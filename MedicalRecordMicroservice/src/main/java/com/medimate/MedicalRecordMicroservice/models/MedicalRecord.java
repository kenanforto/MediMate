package com.medimate.MedicalRecordMicroservice.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="medical_record")
public class MedicalRecord {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @OneToOne(mappedBy = "medicalRecord")
    private AdmissionRecord admisionRecord;

    protected MedicalRecord(){}
    public MedicalRecord(Integer id,String description) {
        this.id=id;
        this.description = description;
        this.createdDate=LocalDate.now();
    }
}
