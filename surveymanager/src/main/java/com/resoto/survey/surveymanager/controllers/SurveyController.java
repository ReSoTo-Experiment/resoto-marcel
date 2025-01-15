package com.resoto.survey.surveymanager.controllers;

import com.resoto.survey.surveymanager.controllers.dto.SurveyDTO;
import com.resoto.survey.surveymanager.service.interfaces.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/surveys")
public class SurveyController {

    private SurveyService service;

    public SurveyController(SurveyService service)
    {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SurveyDTO>> getSurveys()
    {
        var results = service.getAllSurveys()
                .stream()
                .map(s -> new SurveyDTO(s))
                .collect(Collectors.toList());

        return ResponseEntity.ok(results);
    }

    @PostMapping
    public ResponseEntity<Integer> createSurvey(@RequestBody SurveyDTO survey)
    {
        return ResponseEntity.ok(this.service.createNewSurvey(survey.getTitle()));
    }
}
