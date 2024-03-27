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

    private Integer adminId;

    public TrackWorkingHoursVM(Integer totalHours, Integer breakHours, Integer adminId) {
        this.totalHours = totalHours;
        this.breakHours = breakHours;
        this.adminId = adminId;
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

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
}
