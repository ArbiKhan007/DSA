package com.naukri.central_api.service;

import com.naukri.central_api.models.ApplicationForm;
import com.naukri.central_api.models.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationFormService {

    QuestionService questionService;

    @Autowired
    public ApplicationFormService(QuestionService questionService){
        this.questionService = questionService;

    }

    public ApplicationForm createApplicationFormByQuestions(List<String> questionList){
        // We are getting list of questions in strings
        // but to create application form we require list of question objects
        // we need to get all questions from database.
        List<Questions> questions = questionService.getAllQuestions(questionList);
        ApplicationForm applicationForm = new ApplicationForm();
        applicationForm.setQuestionsList(questions);
        return applicationForm;
    }
}
