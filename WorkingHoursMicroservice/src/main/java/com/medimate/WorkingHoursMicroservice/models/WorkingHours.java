package com.medimate.WorkingHoursMicroservice.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "working_hours")
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
    @Pattern(regexp = "[A-Za-z]+")
    private String title;

    @Column(name = "doctor_id")
    @NotNull
    private Integer doctorId;

    @Column(name = "track_working_hours_id")
    @NotNull
    private Integer trackWorkingHoursId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false)
    private Doctor doctor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "track_working_hours_id", insertable = false, updatable = false)
    private TrackWorkingHours trackWorkingHours;

    public WorkingHours(LocalTime startTime, LocalTime endTime, String title, Doctor doctor, TrackWorkingHours trackWorkingHours) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.doctor = doctor;
        this.trackWorkingHours = trackWorkingHours;
    }

    public WorkingHours(LocalTime startTime, LocalTime endTime, String title, Integer doctorId, Integer trackWorkingHoursId
    ) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.doctorId = doctorId;
        this.trackWorkingHoursId = trackWorkingHoursId;
    }
}
