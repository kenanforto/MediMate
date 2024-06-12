package com.medimate.UserMicroservice.viewmodels;

import com.medimate.UserMicroservice.models.Admin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AdminVM {

    Integer userId;
    public AdminVM(Integer userId) {
        this.userId=userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public static Admin toEntity(AdminVM adminVM) {
        return new Admin(adminVM.userId);
    }
}

