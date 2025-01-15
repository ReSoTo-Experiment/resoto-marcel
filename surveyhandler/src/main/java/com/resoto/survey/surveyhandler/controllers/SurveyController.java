package com.resoto.survey.surveyhandler.controllers;

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

    @GetMapping("/admin")
    public String Protected()
    {
        return "Protected";
    }
}
