package com.resoto.survey.surveymanager.repository.interfaces.resoto;

import com.resoto.survey.surveymanager.domain.Survey;

import java.util.List;

public interface SurveyRepository {
    List<Survey> getSurveys();
}
