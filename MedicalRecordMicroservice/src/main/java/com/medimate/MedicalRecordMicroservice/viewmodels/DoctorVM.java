package com.medimate.MedicalRecordMicroservice.viewmodels;

import lombok.Getter;

@Getter
public class DoctorVM {
    private String firstName;
    private String lastName;
    private String title;

    public DoctorVM(String firstName, String lastName, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }

}
