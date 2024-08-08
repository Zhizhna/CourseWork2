package com.sky.coursework2;

import com.sky.coursework2.Impl.QuestionServiceImpl;
import com.sky.coursework2.Model.Question;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionServiceTest {

    private final QuestionServiceImpl questionService = new QuestionServiceImpl();

    @Test
    public void shouldCorrectlyAddQuestion() {
        Question question = new Question("a", "b");

        Question addedQuestion = questionService.add(question);

        assertEquals(question, addedQuestion);
    }

    @Test
    public void shouldCorrectlyRemoveQuestion() {
        Question question = new Question("a", "b");
        questionService.add(question);

        Question removedQuestion = questionService.remove(question);

        assertEquals(question, removedQuestion);
    }

    @Test
    public void shouldCorrectlyGetAll() {
        Question question1 = new Question("qw1", "answ1");
        Question question2 = new Question("qw2", "answ2");

        questionService.add(question1);
        questionService.add(question2);

        Collection<Question> actualQuestions = questionService.getAll();

        assertIterableEquals(List.of(question1, question2), actualQuestions);
    }

    @Test
    public void shouldCorrectlyGetRandomQuestion() {
        Question question1 = new Question("qw1", "answ1");
        Question question2 = new Question("qw2", "answ2");

        questionService.add(question1);
        questionService.add(question2);

        Question randomQuestion = questionService.getRandomQuestion();

        assertTrue(Set.of(question1, question2).contains(randomQuestion));
    }
}