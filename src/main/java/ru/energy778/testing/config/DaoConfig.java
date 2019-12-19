package ru.energy778.testing.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.energy778.testing.dao.TestDataDAO;
import ru.energy778.testing.dao.TestDataDAOCSV;

@Configuration
public class DaoConfig {

    @Bean
    TestDataDAO testDataDAO(@Value("${db.url}") String pathToFile){
        return new TestDataDAOCSV(pathToFile);
    }

}
