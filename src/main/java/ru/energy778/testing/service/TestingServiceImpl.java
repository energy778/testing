package ru.energy778.testing.service;

import org.springframework.stereotype.Service;
import ru.energy778.testing.domain.Answer;
import ru.energy778.testing.domain.Question;
import ru.energy778.testing.domain.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestingServiceImpl implements TestingService {

    public List<String> passExamination(List<Test> tests) {

        System.out.println("Тестирование (вводите варианты ответов цифрами через пробел)");

        List<String> enteredValues = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for (Test test : tests) {

                Question question = test.getQuestion();
                System.out.print(question.getData());
                if (question.isSomeAnswers()) {
                    System.out.println(" (несколько вариантов ответа):");
                }
                else {
                    System.out.println(":");
                }

                List<Answer> answers = test.getAnswers();

                for (int i = 0; i < answers.size(); i++) {
                    System.out.println(String.format("%1$s. %2$s", 1+i, answers.get(i).getData()));
                }

                enteredValues.add(br.readLine());

                // TODO: 15.12.2019 тут можно добавить проверку на корректность введенных данных (не буквы ли ввели, не выходит ли за диапазон)

            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return enteredValues;

    }

}
