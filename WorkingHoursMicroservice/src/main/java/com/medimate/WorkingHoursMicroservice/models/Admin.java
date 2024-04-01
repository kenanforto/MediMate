package com.medimate.WorkingHoursMicroservice.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;

    public Admin(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
