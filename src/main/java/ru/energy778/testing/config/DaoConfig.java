package ru.energy778.testing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.energy778.testing.dao.TestDataDAO;
import ru.energy778.testing.dao.TestDataDAOCSV;

@Configuration
public class DaoConfig {

    @Bean
//    TestDataDAO testDataDAO(String pathToFile){
    TestDataDAO testDataDAO(){
        return new TestDataDAOCSV("C:\\Users\\17857172\\Desktop\\otus spring framework\\hw01\\testFile.csv");
//        return new TestDataDAOCSV(pathToFile);
    }

}
