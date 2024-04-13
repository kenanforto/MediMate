package com.medimate.SurveyMicroservice.controllers;

import com.medimate.SurveyMicroservice.models.Patient;
import com.medimate.SurveyMicroservice.models.Survey;
import com.medimate.SurveyMicroservice.services.SurveyService;
import com.medimate.SurveyMicroservice.viewModels.SurveyVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/survey")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @PostMapping
    public void addOneSurvey(@RequestBody SurveyVM survey) {
        surveyService.addOneSurvey(survey);
    }

    @GetMapping
    public ResponseEntity<Page<Survey>> getAllSurveys(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<Survey> surveys = surveyService.getAllSurveys(page, size, sortBy);

        return (surveys != null && !surveys.isEmpty()) ? ResponseEntity.ok().body(surveys) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteOneSurvey(@PathVariable Integer id) {
        surveyService.deleteOneSurvey(id);
    }


}
