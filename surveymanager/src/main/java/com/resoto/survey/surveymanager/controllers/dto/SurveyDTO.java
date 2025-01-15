package com.resoto.survey.surveymanager.controllers.dto;

import com.resoto.survey.surveymanager.domain.Survey;
import com.resoto.survey.surveymanager.repository.interfaces.resoto.SurveyRepository;

public class SurveyDTO {
    private int id;
    private String title;


    public SurveyDTO() {}

    public SurveyDTO(Survey s)
    {
        this.id = s.getId();
        this.title = s.getTitle();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
