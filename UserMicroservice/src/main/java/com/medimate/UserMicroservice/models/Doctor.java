package com.medimate.UserMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Pattern(regexp="[A-Za-z]+")
    private String title;

    @Column(name = "user_id")
    private Integer userId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User user;

    public Doctor( String title, Integer userId) {
        this.title = title;
        this.userId=userId;
    }
}
