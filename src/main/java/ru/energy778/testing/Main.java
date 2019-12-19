package ru.energy778.testing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.energy778.testing.domain.Test;
import ru.energy778.testing.service.CheckService;
import ru.energy778.testing.service.LoadTestService;
import ru.energy778.testing.service.TestingService;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "ru.energy778.testing.config")
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        LoadTestService testLoadService = context.getBean(LoadTestService.class);
        TestingService testingService = context.getBean(TestingService.class);
        CheckService checkService = context.getBean(CheckService.class);

        List<Test> tests = testLoadService.getQuestions(5);
        List<String> enteredValues = testingService.passExamination(tests);
        String result = checkService.check(tests, enteredValues);

        System.out.println(result);

    }

}
