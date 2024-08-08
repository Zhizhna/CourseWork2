package com.sky.coursework2.Impl;

import com.sky.coursework2.Model.Question;
import com.sky.coursework2.Service.QuestionService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    private final Random random = new Random();

    @PostConstruct
    public void init() {
        add("QW1", "answ1");
        add("QW2", "answ2");
        add("QW3", "answ3");
        add("QW4", "answ4");
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(randomIndex);
    }
}