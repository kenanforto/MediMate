package com.medimate.WorkingHoursMicroservice.viewmodels;

import com.medimate.WorkingHoursMicroservice.models.Admin;
import com.medimate.WorkingHoursMicroservice.models.Doctor;
import com.medimate.WorkingHoursMicroservice.models.TrackWorkingHours;
import com.medimate.WorkingHoursMicroservice.models.WorkingHours;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

public class WorkingHoursVM {

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime startTime;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime endTime;

    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String title;

    @NotNull
    private Integer doctorId;

    @NotNull
    private Integer trackWorkingHoursId;

    public WorkingHoursVM(LocalTime startTime, LocalTime endTime, String title, Integer doctorId, Integer trackWorkingHoursId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.doctorId = doctorId;
        this.trackWorkingHoursId = trackWorkingHoursId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getTrackWorkingHoursId() {
        return trackWorkingHoursId;
    }

    public void setTrackWorkingHoursId(Integer trackWorkingHoursId) {
        this.trackWorkingHoursId = trackWorkingHoursId;
    }

    public static WorkingHours toEntity(WorkingHoursVM workingHoursVM) {
        return new WorkingHours(workingHoursVM.startTime, workingHoursVM.endTime, workingHoursVM.title, workingHoursVM.doctorId, workingHoursVM.trackWorkingHoursId);
    }
}
