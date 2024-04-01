package com.medimate.WorkingHoursMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Column(name = "admin_id")
    @NotNull
    private Integer adminId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "admin_id", insertable = false, updatable = false)
    private Admin admin;

    @JsonIgnore
    @OneToMany(mappedBy = "track_working_hours")
    private List<WorkingHours> workingHours;

    public TrackWorkingHours(Integer totalHours, Integer breakHours, Admin admin) {
        this.totalHours = totalHours;
        this.breakHours = breakHours;
        this.admin = admin;
    }

    public TrackWorkingHours(Integer totalHours, Integer breakHours, Integer adminId) {
        this.totalHours = totalHours;
        this.breakHours = breakHours;
        this.adminId = adminId;
    }
}
