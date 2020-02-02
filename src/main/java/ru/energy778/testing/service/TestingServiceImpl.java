package ru.energy778.testing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.energy778.testing.domain.Answer;
import ru.energy778.testing.domain.Question;
import ru.energy778.testing.domain.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class TestingServiceImpl implements TestingService {

    private MessageSource messageSource;

    public List<String> passExamination(List<Test> tests) {

/* примеры интернационализации
        Locale english = Locale.ENGLISH;
        Locale russian = new Locale("ru", "RU");

        System.out.println(messageSource.getMessage("msg", null, english));
        System.out.println(messageSource.getMessage("msg", null, russian));

        System.out.println(messageSource.getMessage("nameMsg", new Object[] { "Name1", "Name2"}, english));
        System.out.println(messageSource.getMessage("nameMsg", new Object[] { "Name1", "Name2"}, russian));
*/
//        System.out.println(
//                messageSource.getMessage("hello.input",
//                        null,
//                        Locale.ENGLISH)
////                        Locale.getDefault()
////                не подтягивается англ бандл
//        );

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
