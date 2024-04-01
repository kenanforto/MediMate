package com.medimate.UserMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Username is mandatory")
    @Size(max = 20, message = "Username must contain less than 20 characters")
    private String userName;

    @NotEmpty
    private String password;

    @Email(regexp = ".+[@].+[\\.].+")
    @Email(message="Please provide a valid email address")
    private String email;

    @Column(name = "role_id")
    private Integer roleId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="role_id", insertable = false, updatable = false)
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


    public User( String user_name, String password, Role role) {
        this.userName = user_name;
        this.password = password;
        this.role = role;
    }

}
