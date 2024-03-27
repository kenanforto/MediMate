package com.medimate.SurveyMicroservice.services;

import com.medimate.SurveyMicroservice.models.Survey;
import com.medimate.SurveyMicroservice.repositories.PatientRepository;
import com.medimate.SurveyMicroservice.repositories.SurveyRepository;
import com.medimate.SurveyMicroservice.viewModels.SurveyVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository repo;
    @Autowired
    private PatientRepository repoPatient;

    public void addOneSurvey(SurveyVM survey)
    {
        repo.save(new Survey(
                survey.getBody(),repoPatient.findById(survey.getPatientId()).orElse(null)
        ));
    }
    public List<Survey> getAllSurveys()
    {
        return repo.findAll();
    }
    public void deleteOneSurvey(Integer id)
    {
        repo.deleteById(id);
    }
}
