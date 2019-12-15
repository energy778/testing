package ru.energy778.testing;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.energy778.testing.domain.Test;
import ru.energy778.testing.service.CheckService;
import ru.energy778.testing.service.LoadTestService;
import ru.energy778.testing.service.TestingService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        LoadTestService testLoadService = context.getBean(LoadTestService.class);
        TestingService testingService = context.getBean(TestingService.class);
        CheckService checkService = context.getBean(CheckService.class);

        List<Test> tests = testLoadService.getQuestions(5);
        List<String> enteredValues = testingService.passExamination(tests);
        String result = checkService.check(tests, enteredValues);

        System.out.println(result);

    }

}
