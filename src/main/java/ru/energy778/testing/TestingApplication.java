package ru.energy778.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import ru.energy778.testing.domain.Test;
import ru.energy778.testing.service.CheckService;
import ru.energy778.testing.service.LoadTestService;
import ru.energy778.testing.service.TestingService;

import java.util.List;


//@Configuration
@SpringBootApplication
@PropertySource("classpath:application.properties")
//@EnableAspectJAutoProxy
//@ComponentScan(basePackages = "ru.energy778.testing")
public class TestingApplication {

    public static void main(String[] args) {

//        SpringApplication.run(TestingApplication.class, args);
//        AboutInfoLoader bean = ctx.getBean(AboutInfoLoader.class);
//        System.out.println(bean.getVersion());

//        System.out.println("It's working!");

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestingApplication.class);
        ConfigurableApplicationContext context = SpringApplication.run(TestingApplication.class, args);

        LoadTestService testLoadService = context.getBean(LoadTestService.class);
        TestingService testingService = context.getBean(TestingService.class);
        CheckService checkService = context.getBean(CheckService.class);

        List<Test> tests = testLoadService.getQuestions(5);
        List<String> enteredValues = testingService.passExamination(tests);
        String result = checkService.check(tests, enteredValues);

        System.out.println(result);

    }

}


