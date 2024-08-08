package com.sky.coursework2;

import com.sky.coursework2.Exception.IncorrectAmountException;
import com.sky.coursework2.Impl.ExaminerServiceImpl;
import com.sky.coursework2.Impl.QuestionServiceImpl;
import com.sky.coursework2.Model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private QuestionServiceImpl javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void shouldThrowIncorrectAmountExceptionWhenThereIsNotEnoughQuestions() {

        int amount = 10;
        when(javaQuestionService.getAll()).thenReturn(List.of());

        Assertions.assertThrows(
                IncorrectAmountException.class,
                () -> examinerService.getQuestions(amount)
        );
    }

    @Test
    public void shouldCorrectlyGetQuestions() {

        int amount = 3;
        List<Question> questions = List.of(
                new Question("qw1", "answ1"),
                new Question("qw2", "answ2"),
                new Question("qw3", "answ3"),
                new Question("qw4", "answ4"),
                new Question("qw5", "answ5")
        );

        when(javaQuestionService.getAll()).thenReturn(questions);

        when(javaQuestionService.getRandomQuestion()).thenReturn(
                questions.get(0),
                questions.get(1),
                questions.get(1),
                questions.get(0),
                questions.get(1),
                questions.get(2)
        );

        Collection<Question> actualQuestions = examinerService.getQuestions(amount);

        Assertions.assertEquals(
                Set.of(questions.get(0), questions.get(1), questions.get(2)),
                actualQuestions
        );

        verify(javaQuestionService, times(6)).getRandomQuestion();
    }
}