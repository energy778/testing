package ru.energy778.testing.dao;

import ru.energy778.testing.domain.Answer;
import ru.energy778.testing.domain.Question;
import ru.energy778.testing.domain.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDataDAOMock implements TestDataDAO {

    @Override
    public List<Test> getQuestions(Integer count) {

        List<Test> result = new ArrayList<>();
        List<Answer> answers;

        Test test1 = new Test();
        test1.setQuestion(new Question("Это первый вопрос?", false));
        answers = new ArrayList<>();
        answers.add(new Answer("Да", true));
        answers.add(new Answer("Нет", false));
        answers.add(new Answer("Не знаю", false));
        answers.add(new Answer("Кто здесь?", false));
        test1.setAnswers(answers);
        result.add(test1);

        Test test2 = new Test();
        test2.setQuestion(new Question("Это второй вопрос?", false));
        answers = new ArrayList<>();
        answers.add(new Answer("Да", true));
        answers.add(new Answer("Нет", false));
        test2.setAnswers(answers);
        result.add(test2);

        Test test3 = new Test();
        test3.setQuestion(new Question("Это третий вопрос?", false));
        answers = new ArrayList<>();
        answers.add(new Answer("Да", true));
        answers.add(new Answer("Нет", false));
        test3.setAnswers(answers);
        result.add(test3);

        return result;

    }

}

