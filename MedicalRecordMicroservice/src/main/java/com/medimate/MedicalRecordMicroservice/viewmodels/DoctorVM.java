package com.medimate.MedicalRecordMicroservice.viewmodels;

public class DoctorVM {
    private String firstName;
    private String lastName;
    private String title;

    public DoctorVM(String firstName, String lastName, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }
}
