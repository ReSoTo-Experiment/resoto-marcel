package com.resoto.survey.surveymanager.repository.interfaces.jpa;

import com.resoto.survey.surveymanager.repository.entities.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepositoryJPA extends JpaRepository<SurveyEntity, Integer> {

}
