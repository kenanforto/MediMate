package com.medimate.MedicalRecordMicroservice.viewmodels;

import com.medimate.MedicalRecordMicroservice.enums.Gender;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PatientVM {
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private Gender gender;
    private String address;
    private String phoneNumber;

    public PatientVM(String firstName, String lastName, LocalDate birthdate, Gender gender, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
