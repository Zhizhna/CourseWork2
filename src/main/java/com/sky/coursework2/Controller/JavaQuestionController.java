package com.sky.coursework2.Controller;

import com.sky.coursework2.Model.Question;
import com.sky.coursework2.Service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;


    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("add")
    public Question add(String question, String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("remove")
    public Question remove(String question, String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> geAll() {
        return questionService.getAll();
    }
}