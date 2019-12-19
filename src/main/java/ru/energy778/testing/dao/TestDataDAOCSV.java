package ru.energy778.testing.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.energy778.testing.domain.Answer;
import ru.energy778.testing.domain.Question;
import ru.energy778.testing.domain.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TestDataDAOCSV implements TestDataDAO {

    private final String pathToFile;

    public TestDataDAOCSV(@Value("${db.url}") String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public List<Test> getQuestions(Integer count) {

        String COMMA_DELIMITER = ";";

        List<Test> result = new ArrayList<>();
        List<Answer> answers;

        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {

            String line;
            int numberString = 0;

            while ((line = br.readLine()) != null && numberString++ < count) {

                answers = new ArrayList<>();

                String[] values = line.split(COMMA_DELIMITER);

                if (values.length < 3){
                    // TODO: 16.12.2019 можно выбросить исключение отсутствия данных
                    System.out.println("В файле содержатся некорректные данные");
                    return result;
                }

                Question question = new Question(values[0], Integer.parseInt(values[1]) == 1);

                String answer = "";
                boolean correct;
                for (int i = 2; i < values.length; i++) {
                    if ((i%2) == 0)
                        answer = values[i];
                    else {
                        correct = Integer.parseInt(values[i]) == 1;
                        if (!answer.isEmpty())
                            answers.add(new Answer(answer, correct));
                    }

                }

                result.add(new Test(question, answers));

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

}
