package com.medimate.MedicalRecordMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="doctor")
public class Doctor {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String lastName;

    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String title;

    public Doctor(String firstName, String lastName, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }
}
