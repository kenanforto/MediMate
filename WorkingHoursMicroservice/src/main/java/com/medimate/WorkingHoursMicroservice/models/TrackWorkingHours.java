package com.medimate.WorkingHoursMicroservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "track_working_hours")
public class TrackWorkingHours {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer totalHours;
    private Integer breakHours;

    @OneToOne
    @JoinColumn(name="admin_id")
    private Admin admin;

    public TrackWorkingHours(Integer totalHours, Integer breakHours, Admin admin) {
        this.totalHours = totalHours;
        this.breakHours = breakHours;
        this.admin = admin;
    }
}
