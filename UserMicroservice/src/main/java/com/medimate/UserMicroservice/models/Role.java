package com.medimate.UserMicroservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

public enum Role {
    Admin,
    Doctor,
    Patient
}
