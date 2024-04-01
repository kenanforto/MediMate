package com.medimate.MedicalRecordMicroservice.viewmodels;

import com.medimate.MedicalRecordMicroservice.enums.Gender;
import com.medimate.MedicalRecordMicroservice.models.Doctor;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PatientVM {

    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String firstName;

    @NotNull
    @NotBlank
    @Pattern(regexp="[A-Za-z]+")
    private String lastName;

    @NotNull
    private LocalDate birthdate;

    @NotNull
    private Gender gender;

    @Pattern(regexp = "^(\\d+)?([A-Za-z](?= ))?(.*?)([^ ]+?)?((?<= )APT)? ?((?<= )\\d*)?$")
    private String address;

    @Pattern(regexp = "^\\+?[0-9]{7,14}$")
    private String phoneNumber;

    public PatientVM(String firstName, String lastName, LocalDate birthdate, Gender gender, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static Patient toEntity(PatientVM patientVM) {
        return new Patient(patientVM.firstName, patientVM.lastName, patientVM.birthdate, patientVM.gender, patientVM.address, patientVM.phoneNumber);
    }

}
