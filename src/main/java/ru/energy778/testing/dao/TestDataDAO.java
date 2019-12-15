package ru.energy778.testing.dao;

import ru.energy778.testing.domain.Test;

import java.util.List;

public interface TestDataDAO {
    List<Test> getQuestions(Integer count);
}
