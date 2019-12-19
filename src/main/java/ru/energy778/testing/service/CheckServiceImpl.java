package ru.energy778.testing.service;

import org.springframework.stereotype.Service;
import ru.energy778.testing.domain.Answer;
import ru.energy778.testing.domain.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class CheckServiceImpl implements CheckService {

    @Override
    public String check(List<Test> tests, List<String> enteredValues) {

        int countCorrect = 0;
        int countTotal = 0;

        for (int i = 0; i < tests.size(); i++) {

            List<Answer> curAnswers = tests.get(i).getAnswers();
            String need = Arrays.toString(
                    IntStream.range(1, curAnswers.size() +1)
                            .filter(ind -> curAnswers.get(ind-1).isCorrect())
                            .toArray()
            );
            String entered = Arrays.toString(
                    Arrays.stream(enteredValues.get(i)
                            .split(" "))
                            .map(Integer::valueOf)          // valueOf кеширует от -127 до 128 (в отличие от parseInt)
                            .sorted(Integer::compareTo)
                            .toArray()
            );

            countTotal++;
            if (need.equals(entered))
                countCorrect++;

        }

        return String.format("Тестирование закончено. Вы верно ответили на %1$s вопросов из %2$s", countCorrect, countTotal);

    }

}
