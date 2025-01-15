package com.resoto.survey.surveymanager.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("healthcheck")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Service is healthy!");
    }
}
