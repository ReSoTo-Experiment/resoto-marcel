package com.resoto.survey.surveymanager.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/surveys")
public class SurveyController {

    @GetMapping
    public String HelloWorld()
    {
        return "Hello World";
    }
}
