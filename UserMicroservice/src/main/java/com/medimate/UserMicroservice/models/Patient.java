package com.medimate.UserMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medimate.UserMicroservice.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate birthdate;

    private Gender gender;

    private String address;

    private String phoneNumber;

    @Column(name = "user_id")
    private Integer userId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User user;

    public Patient(LocalDate birthdate, Gender gender, String address, String phoneNumber,Integer userId) {
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userId=userId;
    }
}
