package ru.energy778.testing.service;

import ru.energy778.testing.dao.TestDataDAO;
import ru.energy778.testing.domain.Test;

import java.util.List;

public class LoadTestServiceImpl implements LoadTestService {

    private final TestDataDAO dao;

    public LoadTestServiceImpl(TestDataDAO dao) {
        this.dao = dao;
    }

    public List<Test> getQuestions(Integer count) {
        return dao.getQuestions(count);
    }

}
