package com.medimate.UserMicroservice.viewmodels;
import lombok.Getter;

@Getter
public class ApiResponse {
    private String message;

    public ApiResponse(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

