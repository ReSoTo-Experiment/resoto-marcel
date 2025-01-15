package com.resoto.survey.surveymanager.service.interfaces;

import com.resoto.survey.surveymanager.domain.Survey;

import java.util.List;

public interface SurveyService {
    List<Survey> getAllSurveys();

    Integer createNewSurvey(String title);
}
