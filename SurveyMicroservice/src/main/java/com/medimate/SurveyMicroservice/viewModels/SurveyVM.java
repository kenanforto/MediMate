package com.medimate.SurveyMicroservice.viewModels;

import com.medimate.SurveyMicroservice.models.Patient;

public class SurveyVM {
    private String body;
    private Integer patientId;

    public SurveyVM(String body, Integer patientId) {
        this.body = body;
        this.patientId = patientId;
    }

    public String getBody() {
        return body;
    }

    public Integer getPatientId() {
        return patientId;
    }
}
