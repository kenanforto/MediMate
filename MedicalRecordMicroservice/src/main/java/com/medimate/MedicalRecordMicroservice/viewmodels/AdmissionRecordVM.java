package com.medimate.MedicalRecordMicroservice.viewmodels;

import java.time.LocalDate;

public class AdmissionRecordVM {
    private LocalDate admittedAt;
    private boolean urgent;

    public AdmissionRecordVM(LocalDate admittedAt, boolean urgent) {
        this.admittedAt = admittedAt;
        this.urgent = urgent;
    }

    public LocalDate getAdmittedAt() {
        return admittedAt;
    }

    public boolean isUrgent() {
        return urgent;
    }
}
