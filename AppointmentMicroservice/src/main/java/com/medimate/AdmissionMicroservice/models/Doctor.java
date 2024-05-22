package com.medimate.AppointmentMicroservice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

    private String title;

//    @JsonIgnore
//    @OneToMany(mappedBy = "doctor")
//    private List<Appointment> appointments;

    public Doctor(String firstName, String lastName, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }

    public Doctor() {}

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
