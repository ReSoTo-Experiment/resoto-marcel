package com.resoto.survey.surveymanager.repository.impl;

import com.resoto.survey.surveymanager.domain.Survey;
import com.resoto.survey.surveymanager.repository.interfaces.jpa.SurveyRepositoryJPA;
import com.resoto.survey.surveymanager.repository.interfaces.resoto.SurveyRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SurveyRepositoryImpl implements SurveyRepository{

    private SurveyRepositoryJPA repo;

    public SurveyRepositoryImpl(SurveyRepositoryJPA repo)
    {
        this.repo = repo;
    }

    @Override
    public List<Survey> getSurveys() {
        return this.repo.findAll()
                .stream()
                .map(s -> new Survey(s.getId(), s.getTitle()))
                .collect(Collectors.toList());
    }
}
