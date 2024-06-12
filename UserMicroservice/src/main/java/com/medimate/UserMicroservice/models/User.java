package com.medimate.UserMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Builder
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
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

    @NotEmpty
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email(regexp = ".+[@].+[\\.].+")
    @Email(message="Please provide a valid email address")
    private String email;

    @NotNull
    @Column(name = "role_id")
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Admin admin;

    @JsonIgnore
    @OneToOne(mappedBy ="user")
    private Doctor doctor;

    @JsonIgnore
    @OneToOne(mappedBy ="user")
    private Patient patient;

    public User(String firstName , String lastName,String email,String password, Role role) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
