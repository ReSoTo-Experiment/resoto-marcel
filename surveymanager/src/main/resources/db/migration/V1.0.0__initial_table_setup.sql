CREATE TABLE survey (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE question (
    id         INT AUTO_INCREMENT PRIMARY KEY,
    question   VARCHAR(200) NOT NULL,
    survey_id  INT          NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_question_survey FOREIGN KEY (survey_id) REFERENCES survey (id) ON DELETE CASCADE
);

CREATE TABLE answer (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    answer      VARCHAR(200) NOT NULL,
    question_id INT          NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_answer_question FOREIGN KEY (question_id) REFERENCES question (id) ON DELETE CASCADE
);