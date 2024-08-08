package com.sky.coursework2.Service;

import com.sky.coursework2.Model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
