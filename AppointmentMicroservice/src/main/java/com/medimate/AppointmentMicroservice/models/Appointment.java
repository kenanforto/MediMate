package com.medimate.AppointmentMicroservice.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime appointmentDateTime;

    private LocalDateTime createdDate = ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime();

    @Column(name="patient_id")
    private Integer patientId;
    @Column(name="doctor_id")
    private Integer doctorId;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "patient_id",insertable=false,updatable = false)
//    private Patient patient;
//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "doctor_id",insertable = false,updatable = false)
//    private Doctor doctor;

    public Appointment(LocalDateTime appointmentDateTime, Integer doctorId,Integer patientId) {
        this.appointmentDateTime = appointmentDateTime;
        this.doctorId=doctorId;
        this.patientId=patientId;
    }

    public Appointment() {}

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }
}
