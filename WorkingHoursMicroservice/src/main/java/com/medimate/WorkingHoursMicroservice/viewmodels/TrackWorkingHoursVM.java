package com.medimate.WorkingHoursMicroservice.viewmodels;

import com.medimate.WorkingHoursMicroservice.models.Admin;

public class TrackWorkingHoursVM {

    private Integer totalHours;
    private Integer breakHours;

    private Admin admin;

    public TrackWorkingHoursVM(Integer totalHours, Integer breakHours, Admin admin) {
        this.totalHours = totalHours;
        this.breakHours = breakHours;
        this.admin = admin;
    }


    public Integer getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Integer totalHours) {
        this.totalHours = totalHours;
    }

    public Integer getBreakHours() {
        return breakHours;
    }

    public void setBreakHours(Integer breakHours) {
        this.breakHours = breakHours;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
