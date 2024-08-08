package com.sky.coursework2.Impl;

import com.sky.coursework2.Exception.IncorrectAmountException;
import com.sky.coursework2.Model.Question;
import com.sky.coursework2.Service.ExaminerService;
import com.sky.coursework2.Service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new IncorrectAmountException("Недостаточно вопросов в хранилище");
        }

        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }

        return questions;
    }
}