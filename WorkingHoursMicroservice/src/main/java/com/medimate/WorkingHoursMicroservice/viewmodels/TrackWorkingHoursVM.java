package com.medimate.WorkingHoursMicroservice.viewmodels;

import com.medimate.WorkingHoursMicroservice.models.Admin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TrackWorkingHoursVM {

    @NotNull
    @Min(4)
    @Max(8)
    private Integer totalHours;

    @NotNull
    @Min(1)
    @Max(2)
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
