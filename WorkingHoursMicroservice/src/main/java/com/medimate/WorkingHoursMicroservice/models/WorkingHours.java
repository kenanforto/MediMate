package com.medimate.WorkingHoursMicroservice.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="working_hours")
public class WorkingHours {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @NotBlank
    private LocalTime startTime;

    @NotNull
    @NotBlank
    private LocalTime endTime;

    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String title;

    @OneToOne
    private Doctor doctor;

    @ManyToOne
    private TrackWorkingHours trackWorkingHours;

    public WorkingHours(LocalTime startTime, LocalTime endTime, String title, Doctor doctor, TrackWorkingHours trackWorkingHours) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.doctor = doctor;
        this.trackWorkingHours = trackWorkingHours;
    }
}
