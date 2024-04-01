package com.medimate.MedicalRecordMicroservice.viewmodels;

import com.medimate.MedicalRecordMicroservice.models.Doctor;
import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class DoctorVM {

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String lastName;

    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String title;

    public DoctorVM(String firstName, String lastName, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }

    public static Doctor toEntity(DoctorVM doctorVM) {
        return new Doctor(doctorVM.firstName, doctorVM.lastName, doctorVM.title);
    }

}
