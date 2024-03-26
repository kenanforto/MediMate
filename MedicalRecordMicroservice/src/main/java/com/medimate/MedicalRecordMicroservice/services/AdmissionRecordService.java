package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.repositories.AdmissionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdmissionRecordService {
    @Autowired
    private AdmissionRecordRepository repo;

}
