package com.medimate.WorkingHoursMicroservice.viewmodels;

import com.medimate.WorkingHoursMicroservice.models.Doctor;
import com.medimate.WorkingHoursMicroservice.models.TrackWorkingHours;

import java.time.LocalTime;

public class WorkingHoursVM {

    private LocalTime startTime;
    private LocalTime endTime;
    private String title;

    private Doctor doctor;

    private TrackWorkingHours trackWorkingHours;

    public WorkingHoursVM(LocalTime startTime, LocalTime endTime, String title, Doctor doctor, TrackWorkingHours trackWorkingHours) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.doctor = doctor;
        this.trackWorkingHours = trackWorkingHours;
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public TrackWorkingHours getTrackWorkingHours() {
        return trackWorkingHours;
    }

    public void setTrackWorkingHours(TrackWorkingHours trackWorkingHours) {
        this.trackWorkingHours = trackWorkingHours;
    }
}
