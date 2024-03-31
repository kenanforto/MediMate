package com.medimate.SurveyMicroservice.controllers;

import com.medimate.SurveyMicroservice.models.Survey;
import com.medimate.SurveyMicroservice.services.SurveyService;
import com.medimate.SurveyMicroservice.viewModels.SurveyVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/survey")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @PostMapping(path="/add")
    public void addOneSurvey(@RequestBody SurveyVM survey)
    {
        surveyService.addOneSurvey(survey);
    }
    @GetMapping(path="/getall")
    public List<Survey> getAllSurveys()
    {
        return surveyService.getAllSurveys();
    }
    @DeleteMapping(path="/delete/{id}")
    public void deleteOneSurvey(@PathVariable Integer id)
    {
        surveyService.deleteOneSurvey(id);
    }


}
