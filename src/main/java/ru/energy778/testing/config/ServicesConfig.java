package ru.energy778.testing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.energy778.testing.dao.TestDataDAO;
import ru.energy778.testing.service.*;

@Configuration
public class ServicesConfig {

    @Bean
    CheckService checkService(){
        return new CheckServiceImpl();
    }

    @Bean
    LoadTestService loadTestService(TestDataDAO dao){
        return new LoadTestServiceImpl(dao);
    }

    @Bean
    TestingService testingService(){
        return new TestingServiceImpl();
    }

}
