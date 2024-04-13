package com.medimate.SurveyMicroservice.services;

import com.medimate.SurveyMicroservice.models.Patient;
import com.medimate.SurveyMicroservice.models.Survey;
import com.medimate.SurveyMicroservice.repositories.PatientRepository;
import com.medimate.SurveyMicroservice.repositories.SurveyRepository;
import com.medimate.SurveyMicroservice.viewModels.SurveyVM;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository repo;
    @Autowired
    private PatientRepository repoPatient;

    public void addOneSurvey(SurveyVM survey) {
        repo.save(new Survey(
                survey.getBody(), repoPatient.findById(survey.getPatientId()).orElse(null)
        ));
    }

    public Page<Survey> getAllSurveys(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Survey> surveys = repo.findAll(pageable);
        if (surveys.isEmpty()) {
            throw new EntityNotFoundException("There are no surveys");
        }
        return surveys;
    }

    public void deleteOneSurvey(Integer id) {
        repo.deleteById(id);
    }
}
