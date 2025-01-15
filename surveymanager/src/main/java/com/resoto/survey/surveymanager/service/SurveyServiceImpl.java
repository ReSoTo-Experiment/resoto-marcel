package com.resoto.survey.surveymanager.service;

import com.resoto.survey.surveymanager.domain.Survey;
import com.resoto.survey.surveymanager.repository.interfaces.resoto.SurveyRepository;
import com.resoto.survey.surveymanager.service.interfaces.SurveyService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService{

    private SurveyRepository repo;

    public SurveyServiceImpl(SurveyRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public List<Survey> getAllSurveys() {
        return repo.getSurveys();
    }
}
